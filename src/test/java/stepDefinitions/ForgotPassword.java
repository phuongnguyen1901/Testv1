package stepDefinitions;

import Common.Setup;
import FilesUtils.MapData;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.ForgotPasswordAtion;
import pageobjects.LoginAction;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ForgotPassword {
    private Setup setup;
    private LoginAction loginAction = null;
    private ForgotPasswordAtion forgotPasswordAtion = null;
    private WebDriver driver = null;
    private String screnario = "Check forgot password page";
    private String testname = "Testcase forgot password page";
    private String urlLink = "https://www.careerlink.vn/nguoi-tim-viec/login";
    private static List<Map<String,Object>> data  = null;
    private String browser = "firefox";
    //format path excel Tên file >sheet name > testcase name
    private String dataExcelPath = "ForgotPassword.xlsx>data>forgot_password";
    private  Map<String,Object> dataItem = null;
    private static Integer i = 0;

    public ForgotPassword(){
        Setup.pass = 0;
        setup= new Setup(screnario,testname);
        setup.setupDriver(urlLink,browser);
        if (data == null){
            data = setup.getDataFromExcelFile(dataExcelPath, MapData.forgotPasswordColoumn);
        }
        if (driver == null){
            driver = Setup.driver;
        }
        if (loginAction == null){
            loginAction = new LoginAction();
        }
        if (forgotPasswordAtion == null){
            forgotPasswordAtion = new ForgotPasswordAtion();
        }
        Setup.colPass = 4;
        Setup.colFail = 5;
        i++;
        dataItem = data.get(i-1);
    }
    @When("Tại màn hình quên mật khẩu")
    public void navigateToPassword(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.checkLoginPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị trang đăng nhập","");
            assertTrue(loginAction.clickButtonQuenMK(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button quên mật khẩu thành công","");
            assertTrue(loginAction.checkQuenMKPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Check màn hình quên mật khẩu","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Chuyển sang màn hình quên mật khẩu thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    //Fwpw_1
    @Then("Hiển thị các thông tin màn quên mật khẩu")
    public void checkShowAllItemInPage(){
        try{
            assertTrue(forgotPasswordAtion.checkShowItemInPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị các thông tin trên màn hình quên mật khẩu thành công","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị các thông tin trên màn hình quên mật khẩu thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }

    //Fwpw_2
    @And("Nhập Email không tồn tại và click button xác nhận")
    public void inputEmailAndClickButton(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(forgotPasswordAtion.inputEmailAndClickButton(driver,dataItem.get("Email").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập thông tin email không tồn tại và click buton xác nhận thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Nhập thông tin email không tồn tại và click buton xác nhận thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Hiển thị thông báo lỗi : Your email address does not exist")
    public void checkMessageFail(){
        try{
            assertTrue(forgotPasswordAtion.checkMessageShowFail(driver,dataItem.get("Message").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị thông báo lỗi : Your email address does not exist thành công","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị thông báo lỗi : Your email address does not exist thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }

    //Fwpw_3
    @And("Nhập email hợp lệ và click button xác nhận")
    public void inputEmailSuccessAndClickButton(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(forgotPasswordAtion.inputEmailAndClickButton(driver,dataItem.get("Email").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập email hợp lệ và click button xác nhận thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Nhập email hợp lệ và click button xác nhận thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Xác nhận thành công, hiển thị thông báo thành công")
    public void checkMessagePass(){
        try{
            assertTrue(forgotPasswordAtion.checkMessageShow(driver,dataItem.get("Message").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Xác nhận thành công, hiển thị thông báo thành công thành công","");
            Setup.pass++;
            setup.after(false);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Xác nhận thành công, hiển thị thông báo thành công thất bại",e.getMessage());
            setup.afterFail(false);
        }
    }
}
