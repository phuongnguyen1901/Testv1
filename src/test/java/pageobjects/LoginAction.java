package pageobjects;

import Common.Constans;
import Common.Events;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAction {
    public boolean checkLoginPage(WebDriver driver){
        boolean result = false;
        try{
            boolean logo = driver.findElements(By.xpath("//img[@alt='CareerLink']")).size()>0;
            if (logo){
                return true;
            }
        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean insertUsernameAndPassword(WebDriver driver, String username,String password){
        boolean result = false;
        try{
            Events.inputTextField(driver,By.xpath("//input[@name='_username']"),username);
            Events.inputTextField(driver,By.xpath("//input[@name='_password']"),password);
            Events.clickButton(driver,By.xpath("//*[@id=\"login_submit\"]"));
            result = true;
        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }
    public boolean insertUsernameAndPasswordNoClick(WebDriver driver, String username,String password){
        boolean result = false;
        try{
            Events.inputTextField(driver,By.xpath("//input[@name='_username']"),username);
            Events.inputTextField(driver,By.xpath("//input[@name='_password']"),password);
            result = true;
        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean checkLoginSuccess(WebDriver driver){
        boolean result = false;
        try{
            boolean checkSuccess = driver.findElements(By.xpath("//*[@id=\"top-navigation\"]/ul/li[5]")).size()>0;
            if (checkSuccess){
                result = true;
            }
        }catch (Exception e){
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean navigateToJobApplication(WebDriver driver){
        boolean result = false;
        try{
            if(Events.clickButton(driver,By.xpath("//li[@class='nav-item dropdown']//button[@class='nav-link dropdown-toggle border  font-weight-bolder mx-1 items-center !rounded-3xl !flex']"))){
                if (Events.clickButton(driver,By.xpath("//div[@class='col-8 px-2 py-0']//a[@href='/nguoi-tim-viec/ho-so']"))){
                    result = true;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return  result;
    }

    public boolean validateScreenLogin_2(WebDriver driver){
        boolean result = false;
        try {
            boolean checkInputEmail = driver.findElements(By.xpath("//input[@name='_username']")).size()>0;
            boolean checkInputPass = driver.findElements(By.xpath("//input[@name='_password']")).size()>0;
            boolean checkInputHienThi = driver.findElements(By.xpath("//*[@id=\"login_submit\"]")).size()>0;
            boolean checkQuenMK = driver.findElements(By.xpath("//a[@class='float-right text-small']")).size()>0;
            boolean checkDangKy= driver.findElements(By.xpath("//a[@class='text-small']")).size()>0;
            if(checkInputEmail&&checkInputPass&& checkInputHienThi&&checkQuenMK&&checkDangKy){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return  result;
    }

    public boolean checkLoginFail(WebDriver driver, String message){
        boolean result = false;
        try {
            String messageInPage = driver.findElement(By.xpath("//*[@id=\"jobseeker_login_form\"]/div[1]")).getText();
            if(message.contains(messageInPage)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
    public boolean clickButtonQuenMK(WebDriver driver){
        boolean resutl = false;
        try {
            if (Events.clickButton(driver,By.xpath("//a[@class='float-right text-small']"))){
                Thread.sleep(3000);
                boolean checkInputEmail = driver.findElements(By.xpath("//h1[@class='h2 mb-4']")).size()>0;
                if (checkInputEmail){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return resutl;
    }
    public boolean checkQuenMKPage(WebDriver driver){
        boolean resutl = false;
        try {
            boolean checkInputEmail = driver.findElements(By.xpath("//h1[@class='h2 mb-4']")).size()>0;
            if (checkInputEmail){
                return true;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return resutl;
    }

    public boolean clickButtonDangKy(WebDriver driver){
        boolean resutl = false;
        try {
            if (Events.clickButton(driver,By.xpath("//a[@class='text-small']"))){
               return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return resutl;
    }
    public static boolean clickButtonSeachjob(WebDriver driver){
        boolean resutl = false;
        try {
            if (Events.clickButton(driver,By.xpath("//*[@id=\"top-navigation\"]/div[2]/ul/div[1]/li[1]/a"))){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return resutl;
    }

}
