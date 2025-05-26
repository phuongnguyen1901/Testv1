package Common;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    // dùng để khai báo biến dùng chung
    // tạo hàm dùng biến
    public static String getXpath(String xpath, String value) {
        return String.format(xpath, value); //a[text()='%s']
    }

    public static String getActivationLink(String email, String password) {
        //Tạo trường thuộc tính
        Properties mail = new Properties();
        //trước khi mở phiên, đặt số cổng và xác thực ssl
        mail.put("mail.pop3.host", "pop.gmail.com");
        mail.put("mail.pop3.port", "995");
        mail.put("mail.pop3.starttls.enable", "true");

        Session emailSession = Session.getDefaultInstance(mail);
        try {
            // tạo đối tượng store POP3 và kết nối với máy chủ pop
            Store store = emailSession.getStore("pop3s");
            store.connect("pop.gmail.com", email, password);
            // tạo đối tượng thư mục và mở nó
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            // lấy các thư từ thư mục trong một mảng và in nó
            Message[] messages = emailFolder.getMessages();

            return Utility.getTextFromMessage(messages[messages.length - 1]);

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    //Đọc văn bản bên trong nội dung thư
    private static String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        } else {
            result = message.getContent().toString();
        }
        return extractActiveLinkFromContent(result);
    }

    private static String extractActiveLinkFromContent(String content) {
        String pattern = "href=\"(https:\\/\\/.*?\\/confirm\\/.*?)\"";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(content);
        if (m.find()) {
            return m.group(0);
        }
        return "";
    }

    private static String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }

    public static void waitABit(int durationInSecond) {
        try {
            Thread.sleep(durationInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
