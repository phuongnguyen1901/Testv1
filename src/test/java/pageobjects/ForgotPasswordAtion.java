package pageobjects;

import Common.Constans;
import Common.Events;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordAtion {
    public boolean checkShowItemInPage(WebDriver driver){
        boolean result = false;
        try {
            boolean checkInputShow = driver.findElements(By.name("email")).size()>0;
            if (checkInputShow){
                result = true;
            }
        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }
    public boolean inputEmailAndClickButton(WebDriver driver,String email){
        boolean result = false;
        try {
            if (Events.inputTextField(driver,By.name("email"),email)){
                if (Events.clickButton(driver,By.xpath("//*[@id=\"reset_request_form\"]/button"))){
                    result = true;
                }
            }
        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }
    public boolean checkMessageShow(WebDriver driver,String message){
        boolean result = false;
        try {
            boolean messageWhenPass = driver.findElements(By.xpath("/html/body/div[4]/div/div/h1")).size()>0;
            // khi chạy case thành công
            if (messageWhenPass){
                String messageResult = driver.findElement(By.xpath("/html/body/div[4]/div/div/h1")).getText();
                if (messageResult.contains(message)){
                    result = true;
                }
            }else { // khi chạy case thất bại
                String messageResult = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]")).getText();
                if (messageResult.contains(message)){
                    result = true;
                }
            }
        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean checkMessageShowFail(WebDriver driver,String message){
        boolean result = false;
        try {
            // khi chạy case thất bại
            String messageResult = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]")).getText();
            if (messageResult.contains(message)){
                result = true;
            }

        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }
}
