package pageobjects;

import Common.Constans;
import Common.Events;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckDisplayScreenAction {
    public boolean navigateToCreateJob(WebDriver driver){
        boolean result = false;
        try{
            if (Events.clickButton(driver, By.xpath("/html/body/div[3]/div/div[1]/div[4]/div[1]/a"))){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
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
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
}
