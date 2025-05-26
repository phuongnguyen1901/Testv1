package Common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constans {
    public static String dataFolder = "data/";
    public static String fileExcelName = "";
    public static String fileTxtPath = "DataTxt/";
    public static String pass = "Pass";
    public static String fail = "Fail";
    public static String sheetName = "";
    public static String testCaseName = "";
    public static final int TIME_WAITING = 30;
    public static final String folderImgReport = "imgReport/";
    public static final String folderVideoReport = "videoReport/";
    public static String errorLog = "";
    public static String getCurrentDateTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date timenow = new Date();
        String strtimenow = sdf.format(timenow);
        return strtimenow;
    }

    public static String getCurrentTime2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        Date timenow = new Date();
        String strtimenow = sdf.format(timenow);
        return strtimenow;
    }

    public static String getCurrentDay2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date timenow = new Date();
        String strtimenow = sdf.format(timenow);
        return strtimenow;
    }

    public static int rowNumber(String no) {
        return Integer.valueOf(no);
    }
    // sử dụng cho phần report
    public static String pattern = "yyyy-MM-dd HH:mm:ss";
    public static SimpleDateFormat formatDate = new SimpleDateFormat(pattern);
    public static String patternMilliS = "SSSS";
    public static SimpleDateFormat formatMillisecond = new SimpleDateFormat(patternMilliS);
    public static SimpleDateFormat formateTimeStamp = new SimpleDateFormat("HH:mm:ss");
    public static String timeDateReport(Date date) {
        return formatDate.format(date);
    }
    public static  String folderReprotLocation = "reports/" + getCurrentDateTime("yyyyMMdd-HHmmss") + "/";


}
