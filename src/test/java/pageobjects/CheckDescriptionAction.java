package pageobjects;

import Common.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckDescriptionAction {
    public boolean validateMessageCharacters(WebDriver driver, String message){
        boolean result = false;
        try {
            String messageInPage = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
            if(messageInPage.equals(message)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
}
