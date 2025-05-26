package pageobjects;

import Common.Events;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookAction {
    public boolean inputUsernameAndPassword(WebDriver driver, String username, String password){
        boolean check = false;
        try {
            Events.inputTextField(driver, By.id("email"),username);
            Events.inputTextField(driver, By.id("pass"),password);
            check= true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return check;
    }
    public boolean clickButtonLogin(WebDriver driver){
        boolean check = false;
        try {
            Events.clickButton(driver,By.name("login"));
            check= true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return check;
    }

    public boolean checkResult(WebDriver driver, String message){
        boolean check = false;
        try {
            boolean resutlAlert = driver.findElements(By.cssSelector("div[class='_9ay7']")).size()>0;
            if(resutlAlert) {
                WebElement resutlEl = driver.findElement(By.cssSelector("div[class='_9ay7']"));
                System.out.println("Message hiện ra là " +resutlEl.getText() );
                System.out.println("Message file excel là " +message );
                if(resutlEl.getText().equals(message)){
                    check = true;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return check;
    }
}
