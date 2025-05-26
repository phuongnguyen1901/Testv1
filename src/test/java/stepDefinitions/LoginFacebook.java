package stepDefinitions;

import Common.Events;
import Common.Setup;
import FilesUtils.ExcelFile;
import FilesUtils.MapData;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.FacebookAction;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
public class LoginFacebook {
    private Setup setup;
    private FacebookAction facebookAction = null;
    private WebDriver driver = null;
    private String screnario = "Test chức năng đăng nhập facebook";
    private String testname = "login facebook";
    private String urlLink = "https://www.facebook.com/";
    private static List<Map<String,Object>> data  = null;
    private String browser = "chrome";
    //format path excel Tên file >sheet name > testcase name
    private String dataExcelPath = "Login.xlsx>data>login";

    public LoginFacebook(){
        setup= new Setup(screnario,testname);
        setup.setupDriver(urlLink,browser);
        if (data == null){
            data = setup.getDataFromExcelFile(dataExcelPath, MapData.loginColoumn);
        }
        if (driver == null){
            driver = Setup.driver;
        }
        if (facebookAction == null){
            facebookAction = new FacebookAction();
        }
        if (Setup.colPass == 0 || Setup.colFail== 0){
            Setup.colPass = 5;
            Setup.colFail = 6;
        }
    }
    @When("Điền thông tin user và password")
    public void inputUsernameAndPassword(){
        try {
            Setup.row = Integer.parseInt(data.get(0).get("No").toString());
            Map<String,Object> dataItem = data.get(0);
            assertTrue(facebookAction.inputUsernameAndPassword(driver,dataItem.get("Username").toString(),dataItem.get("Password").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Input email and password success","");
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Input username and password fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Click button đăng nhập")
    public void clickButtonDangNhap(){
        try {
            assertTrue(facebookAction.clickButtonLogin(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button success","");
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button fail",e.getMessage());
            setup.afterFail(true);
        }

    }
    @Then("Thực hiện bắn lỗi không thể đăng nhập thành công")
    public void showMessage(){
        try {
            String message = data.get(0).get("Message").toString();
            if(facebookAction.checkResult(driver,message)){
                Setup.testLogs.log(LogStatus.PASS,"Check message success","");
                ExcelFile.setPass(Setup.colPass, Setup.row,Setup.colFail);
            }else {
                Setup.testLogs.log(LogStatus.FAIL,"Check message fail","");
                ExcelFile.setFail(Setup.colPass, Setup.row,Setup.colFail);
            }
            Events.captureScreenSelenium(driver);
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Check message fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    // hết step 1
    @When("Điền thông tin user")
    public void inputUsernameAndPasswordTest2(){
        try {
            Map<String,Object> dataItem = data.get(1);
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(facebookAction.inputUsernameAndPassword(driver,dataItem.get("Username").toString(),dataItem.get("Password").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Input email and password is null success","");
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Input username and password fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Click button login")
    public void clickButtonDangNhapTest2(){
        try {
            assertTrue(facebookAction.clickButtonLogin(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button success","");
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button fail",e.getMessage());
            setup.afterFail(true);
        }

    }
    @Then("Kiểm tra thông tin lỗi thiếu password trên màn hình")
    public void showMessageTest2(){
        try {
            String message = data.get(1).get("Message").toString();
            if(facebookAction.checkResult(driver,message)){
                Setup.testLogs.log(LogStatus.PASS,"Check message success","");
                ExcelFile.setPass(Setup.colPass, Setup.row,Setup.colFail);
            }else {
                Setup.testLogs.log(LogStatus.FAIL,"Check message fail","");
                ExcelFile.setFail(Setup.colPass, Setup.row,Setup.colFail);
            }
            Events.captureScreenSelenium(driver);
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Check message fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    // hết step 2
    @When("Điền thông tin password")
    public void inputUsernameAndPasswordTest3(){
        try {
            Map<String,Object> dataItem = data.get(2);
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(facebookAction.inputUsernameAndPassword(driver,dataItem.get("Username").toString(),dataItem.get("Password").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Input email is null and password success","");
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Input email is null and password success",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("button đăng nhập")
    public void clickButtonDangNhapTest3(){
        try {
            assertTrue(facebookAction.clickButtonLogin(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button success","");
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button fail",e.getMessage());
            setup.afterFail(true);
        }

    }
    @Then("Kiểm tra thông tin lỗi không điền username trên màn hình")
    public void showMessageTest3(){
        try {
            String message = data.get(2).get("Message").toString();
            if(facebookAction.checkResult(driver,message)){
                Setup.testLogs.log(LogStatus.PASS,"Check message success","");
                ExcelFile.setPass(Setup.colPass, Setup.row,Setup.colFail);
            }else {
                Setup.testLogs.log(LogStatus.FAIL,"Check message fail","");
                ExcelFile.setFail(Setup.colPass, Setup.row,Setup.colFail);
            }
            Events.captureScreenSelenium(driver);
            setup.after(false);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Check message fail",e.getMessage());
            setup.afterFail(false);
        }
    }
    // hết step 3
}
