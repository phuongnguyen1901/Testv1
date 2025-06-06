package pageobjects;

import Common.Constans;
import Common.Events;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckWhenNotEnteringInfomationAction {
    public boolean navigateToCreateJob(WebDriver driver){
        boolean result = false;
        try{
            if (Events.clickButton(driver, By.xpath("/html/body/div[4]/div/div[1]/div[4]/div[2]/a"))){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.append(e.getMessage());
        }
        return result;
    }

    public boolean checkShowTitleAndDescription(WebDriver driver){
        boolean result = false;
        try {
            boolean checkTitle = driver.findElements(By.xpath("//input[@name='cover_letter[title]']")).size()>0;
            boolean checkDesciption = driver.findElements(By.xpath("//textarea[@name='cover_letter[message]']")).size()>0;
            if (checkTitle && checkDesciption){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.append(e.getMessage());
        }
        return result;
    }

    public boolean checkInputTitleAndDescription(WebDriver driver,String title, String description){
        boolean result = false;
        try {
            if(Events.inputTextField(driver,By.xpath("//*[@id=\"cover_letter_title\"]"),title)){
                if(Events.inputTextField(driver,By.xpath("//*[@id=\"cover_letter_message\"]"),description)){
                    result = true;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.append(e.getMessage());
        }
        return result;
    }
    public boolean checkMessageShowInTitle(WebDriver driver, String message){
        boolean result = false;
        try {
            if(Events.getMessageRequiredInInputHtml(By.xpath("//*[@id=\"cover_letter_title\"]"),message,driver)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.append(e.getMessage());
        }
        return result;
    }
    public boolean checkMessageShowDescription(WebDriver driver, String message){
        boolean result = false;
        try {
            if(Events.getMessageRequiredInInputHtml(By.xpath("//*[@id=\"cover_letter_message\"]"),message,driver)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.append(e.getMessage());
        }
        return result;
    }

    public boolean checkMessageShowSuccess(WebDriver driver, String message){
        boolean result = false;
        try {
            String messageInPage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show mt-3 mx-3 mx-lg-0']")).getText();
            if(messageInPage.contains(message)){
                return true;
            }
        }catch (Exception e){
            System.out.println(Constans.errorLog.append(e.getMessage()));
        }
        return result;
    }
    public boolean clickButtonCreate(WebDriver driver) {
        boolean result = false;
        try {
            if (Events.clickButton(driver, By.cssSelector("/html/body/div[4]/div/div[1]/div/form/div[3]/button"))) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Constans.errorLog.append(e.getMessage());
        }
        return result;
    }
}
