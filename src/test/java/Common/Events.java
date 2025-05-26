package Common;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Events {
    public static void captureScreenJava() {
        try{
            String pathfileIMGSave = RandomName.pathImg(RandomStringUtils.randomNumeric(5));
            String imgPath;
            imgPath = ScreenshotAndVideo.screenShotByJava(pathfileIMGSave);
            File img = new File(Constans.folderReprotLocation+imgPath);
            if (img.createNewFile()) {
                System.out.println("File created: " + img.getName());
            } else {
                System.out.println("File already exists.");
            }
            if(img.exists() && !img.isDirectory()) {
                Setup.testLogs.log(LogStatus.INFO, Setup.testLogs.addScreenCapture(imgPath),"");
            }
        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }

    }
    public static void captureScreenSelenium(WebDriver driver) {
        try {
            String pathfileIMGSave = RandomName.pathImg(RandomStringUtils.randomNumeric(5));
            String imgPath;
            imgPath = ScreenshotAndVideo.screenShotBySelenium(driver,pathfileIMGSave);
            File img = new File(Constans.folderReprotLocation + imgPath);
            if (img.createNewFile()) {
                System.out.println("File created: " + img.getName());
            } else {
                System.out.println("File already exists.");
            }
            if(img.exists() && !img.isDirectory()) {
                Setup.testLogs.log(LogStatus.INFO, Setup.testLogs.addScreenCapture(imgPath),"");
            }
        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public static boolean clickButton(WebDriver driver, By elementFindBy) {
        boolean click = false;
        try {
            WebElement btnClick = driver.findElement(elementFindBy);
            btnClick.click();
            click = true;
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return click;
    }

    public static boolean inputTextField(WebDriver driver, By elementFindBy, String valueInput) {
        boolean input = false;
        try {
            WebElement textField = driver.findElement(elementFindBy);
            textField.clear();
            textField.sendKeys(valueInput);
            input = true;
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return input;
    }

    public static boolean selectComboboxByValue(WebDriver driver, By elementFindBy, String valueSelect) {
        boolean check = false;
        try {
            WebElement combobox = driver.findElement(elementFindBy);
            Select selectCombobox = new Select(combobox);
            selectCombobox.selectByValue(valueSelect);
            check = true;
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return check;
    }

    public static boolean selectComboboxByIndex(WebDriver driver, By elementFindBy, int valueIndex) {
        boolean check = false;
        try {
            WebElement combobox = driver.findElement(elementFindBy);
            Select selectCombobox = new Select(combobox);
            selectCombobox.selectByIndex(valueIndex);
            check = true;
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return check;
    }

    public static boolean selectComboboxByVisibleText(WebDriver driver, By elementFindBy, String visibleText) {
        boolean check = false;
        try {
            WebElement combobox = driver.findElement(elementFindBy);
            Select selectCombobox = new Select(combobox);
            selectCombobox.selectByVisibleText(visibleText);
            check = true;
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return check;
    }

    public static boolean checkElementInPage(WebDriver driver, By elementFindBy) {
        boolean check = false;
        try {
            boolean element = driver.findElements(elementFindBy).size()>0;
            if (element) {
                check = true;
            }
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return check;
    }
    public static List<String> getAllOptionValueInSelectComboBox(WebDriver driver, By elementFindBy) {
        List<String> allOption = new ArrayList<>();
        try {
            WebElement combobox = driver.findElement(elementFindBy);
            Select selectCombobox = new Select(combobox);
            selectCombobox.getOptions().forEach(o -> {
                allOption.add(o.getAttribute("value"));
            });
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return allOption;
    }
    public static boolean switchWindowHasString(WebDriver driver, String stringInWindow) {
        boolean result = false;
        try {
            Set<String> lstWindow = driver.getWindowHandles();
            if (lstWindow.size()>0) {
                for (String window : lstWindow) {
                    driver.switchTo().window(window);
                    if (driver.getPageSource().contains(stringInWindow)) {
                        result = true;
                        break;
                    }
                    else {
                        Thread.sleep(1000);
                    }
                }
            }

        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return result;
    }
    public static boolean clickButtonUsingJS(WebDriver driver, By elementFindBy) {
        boolean result = false;
        try {
            WebElement element = driver.findElement(elementFindBy);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
            result = true;

        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return result;
    }
    public boolean hoverToElement(WebDriver driver, By findElementBy){
        boolean result = false;
        try {
            WebElement element = driver.findElement(findElementBy);
            Actions action = new Actions(driver);
            action.moveToElement(element).build().perform();
        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static boolean getMessageRequiredInInputHtml(By by, String message,WebDriver driver){
        boolean result = false;
        try {
            String messageHtml  = driver.findElement(by).getAttribute("validationMessage");
            if (StringUtils.isBlank(messageHtml)){
                Alert alert = driver.switchTo().alert();
                messageHtml = alert.getText();
            }
            if (messageHtml.contains(message)){
                return true;
            }
        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }
}
