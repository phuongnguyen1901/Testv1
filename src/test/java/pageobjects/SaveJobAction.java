package pageobjects;

import Common.Constans;
import Common.Events;
import FilesUtils.ExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SaveJobAction {
    public static  String jobTitle = "";
    public boolean clickButtonSaveJob(WebDriver driver, String fileSave, List<String> coloumName){
        boolean result = false;
        try {
            if (Events.clickButtonUsingJS(driver, By.xpath("/html/body/div[2]/div/div[1]/ul/li[1]/div/div[2]/button"))){
                String title = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul/li[1]/div/div[2]/a[2]")).getAttribute("title");
                System.out.println("Show title is "+title);
                if (!Objects.isNull(title)){
                    jobTitle = title;
                    result = true;
                }
            }
        }catch (Exception e){
            Constans.errorLog.append(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean navigateToSaveJob(WebDriver driver){
        boolean result = false;
        try {
            if(Events.clickButton(driver,By.xpath("//*[@id=\"top-navigation\"]/ul/li[5]/button"))){
                if (Events.clickButton(driver,By.xpath("//*[@id=\"top-navigation\"]/ul/li[5]/div/div/div[3]/a[2]"))){
                    result = true;
                }
            }
        }catch (Exception e){
            Constans.errorLog.append(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }
    public boolean checkJobWhenSave(WebDriver driver,String titleJob){
        boolean result = false;
        try {
            String titleJobInWeb = driver.findElement(By.xpath("//*[@id=\"saved-jobs-list\"]/li/div/div[2]/div[1]/a[2]/span")).getAttribute("title");
            if (titleJobInWeb.contains(titleJob)){
                Events.captureScreenSelenium(driver);
                result = true;
            }
        }catch (Exception e){
            Constans.errorLog.append(e.getMessage());
            System.out.println(e.getMessage());
        }
        return  result;
    }
    public boolean removeSaveJob(WebDriver driver){
        boolean result = false;
        try {
          if (Events.clickButtonUsingJS(driver,By.xpath("//*[@id=\"saved-jobs-list\"]/li/div/div[2]/div[1]/a[2]/span"))){
                result = true;
          }
        }catch (Exception e){
            Constans.errorLog.append(e.getMessage());
            System.out.println(e.getMessage());
        }
        return  result;
    }
    public boolean checkWhenClickSave(WebDriver driver){
        boolean result = false;
        try {
            boolean exists = driver.findElements(By.xpath("/html/body/div[2]/div/div/ul/li[1]/div/div[2]/button/span/strong")).size()>0;
            if (exists){
                result = true;
            }
        }catch (Exception e){
            Constans.errorLog.append(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }
}
