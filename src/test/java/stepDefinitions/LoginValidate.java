package stepDefinitions;

import Common.Setup;
import FilesUtils.MapData;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginAction;
import pageobjects.RegisterAction;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginValidate {
    private Setup setup;
    private LoginAction loginAction = null;
    private RegisterAction register = null;
    private WebDriver driver = null;
    private String screnario = "Check login page";
    private String testname = "Validate login page";
    private String urlLink = "https://careerlink.fun/nguoi-tim-viec/login";
    private static List<Map<String,Object>> data  = null;
    private String browser = "firefox";
    //format path excel Tên file >sheet name > testcase name
    private String dataExcelPath = "Login.xlsx>data>login_4_5_6_7_8";
    private  Map<String,Object> dataItem = null;
    private static Integer i = 0;

    public LoginValidate(){
        Setup.pass = 0;
        setup= new Setup(screnario,testname);
        setup.setupDriver(urlLink,browser);
        if(register == null){
            register = new RegisterAction();
        }
        if (data == null){
            data = setup.getDataFromExcelFile(dataExcelPath, MapData.loginColoumn);
        }
        if (driver == null){
            driver = Setup.driver;
        }
        if (loginAction == null){
            loginAction = new LoginAction();
        }
        Setup.colPass = 7;
        Setup.colFail = 8;
        i++;
        dataItem = data.get(i-1);
    }
    //login 4
    @Given("Nhập password")
    public void checkItemInLoginPage(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.insertUsernameAndPasswordNoClick(driver,dataItem.get("Username").toString(),dataItem.get("Password").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập password thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Login fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Click button Hiển thị mật khẩu và Hiển thị mật khẩu đã nhập")
    public void checkLoginValidatePage(){
        try{
            assertTrue(register.clickShowPassword(driver));
            Setup.testLogs.log(LogStatus.PASS," Click button Hiển thị mật khẩu và Hiển thị mật khẩu đã nhập","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button Hiển thị mật khẩu và Hiển thị mật khẩu đã nhập fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    // login_5
    @Given("Nhập email không tồn tại và nhập password hợp lệ và Click button đăng nhập")
    public void checkLoginSuccess(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.checkLoginPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Check login page success","");
            assertTrue(loginAction.insertUsernameAndPassword(driver,dataItem.get("Username").toString(),dataItem.get("Password").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập email không tồn tại và nhập password hợp lệ và Click button đăng nhập thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Nhập email không tồn tại và nhập password hợp lệ và Click button đăng nhập thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Hiển thị thông báo lỗi : E-mail hoặc mật khẩu bị sai. Vui lòng đăng nhập lại")
    public void checkMessageError(){
        try{
            assertTrue(loginAction.checkLoginFail(driver,dataItem.get("Message").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị thông báo lỗi : E-mail hoặc mật khẩu bị sai. Vui lòng đăng nhập lại thành công ","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị thông báo lỗi : E-mail hoặc mật khẩu bị sai. Vui lòng đăng nhập lại thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }

    // login_6
    @Given("Nhập email tồn tại và nhập password không hợp lệ và Click button đăng nhập page")
    public void inputLoginPage(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.checkLoginPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị trang đăng nhập","");
            assertTrue(loginAction.insertUsernameAndPassword(driver,dataItem.get("Username").toString(),dataItem.get("Password").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập email tồn tại và nhập password không hợp lệ và Click button đăng nhập page thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Nhập email tồn tại và nhập password không hợp lệ và Click button đăng nhập page thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("E-mail hoặc mật khẩu bị sai. Vui lòng đăng nhập lại")
    public void checkError(){
        try{
            assertTrue(loginAction.checkLoginFail(driver,dataItem.get("Message").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị thông báo lỗi : E-mail hoặc mật khẩu bị sai. Vui lòng đăng nhập lại thành công ","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị thông báo lỗi : E-mail hoặc mật khẩu bị sai. Vui lòng đăng nhập lại thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }

    // login_7
    @Given("Click button Quên mật khẩu")
    public void clickButtonQuenMatKhau(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.checkLoginPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị trang đăng nhập","");
            assertTrue(loginAction.clickButtonQuenMK(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button Quên mật khẩu thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button Quên mật khẩu thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Hiển thị màn hình quên mật khẩu")
    public void checkQuenMKPage(){
        try{
            assertTrue(loginAction.checkQuenMKPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị màn hình quên mật khẩu thành công ","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị màn hình quên mật khẩu thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    // login_8
    @Given("Click button Đăng kí")
    public void clickButtonDangKy(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.checkLoginPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị trang đăng nhập","");
            assertTrue(loginAction.clickButtonDangKy(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button Đăng kí thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button Đăng kí thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Hiển thị màn hình đăng kí")
    public void checkDangKyPage(){
        try{
            assertTrue(register.checkItemInPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị màn hình đăng kí thành công ","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị màn hình đăng kí thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
}


