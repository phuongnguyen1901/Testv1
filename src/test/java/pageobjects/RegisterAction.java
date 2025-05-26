package pageobjects;

import Common.Constans;
import Common.Events;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAction {
    public boolean checkItemInPage(WebDriver driver){
        boolean result = false;
        try {
            boolean checkInputName = driver.findElements(By.id("full_name")).size()>0;
            boolean checkInputEmail = driver.findElements(By.id("email")).size()>0;
            boolean checkInputPass = driver.findElements(By.id("password")).size()>0;
            boolean checkRePass = driver.findElements(By.id("password_confirmation")).size()>0;
            if(checkInputName&&checkInputEmail&& checkInputPass&&checkRePass){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }

    public boolean inputAllDataInPageRegister(WebDriver driver,String fullName,String email,String password, String passwordConfirm){
        boolean result = false;
        try {
            if (Events.inputTextField(driver, By.id("full_name"),fullName)){
                if (Events.inputTextField(driver, By.id("email"),email)){
                    if (Events.inputTextField(driver, By.id("password"),password)){
                        if (Events.inputTextField(driver, By.id("password_confirmation"),passwordConfirm)){
                            return true;
                        }
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }

    public boolean clickButtonDangKy(WebDriver driver){
        boolean result = false;
        try {
            if (Events.clickButton(driver, By.id("register_submit"))){
               return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
    // email tồn tại //span[@data-message='taken']  -> Email này đã được đăng ký. Vui lòng nhập email khác
    // mật khẩu không hợp lệ   -> id = invalid_password_feedback; message = Mật khẩu không khớp. Hãy nhập lại
    public boolean checkResult(WebDriver driver, String message, By by){
        boolean result = false;
        try {
            String messageInPage = driver.findElement(by).getText();
            if(message.trim().contains(messageInPage.trim())){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }


    // dùng được cả cho case đăng nhập và đăng ký
    public boolean clickShowPassword(WebDriver driver){
        boolean result = false;
        try {
            if (Events.clickButton(driver,By.id("toggle_password"))){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
}
