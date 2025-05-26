package stepDefinitions;

import Common.Setup;
import FilesUtils.MapData;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginAction;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class Login {
    private Setup setup;
    private LoginAction loginAction = null;

    private WebDriver driver = null;
    private String screnario = "Check login page";
    private String testname = "Check item in page and login success";
    private String urlLink = "https://careerlink.fun/nguoi-tim-viec/login";
    private static List<Map<String,Object>> data  = null;
    private String browser = "firefox";
    //format path excel Tên file >sheet name > testcase name
    private String dataExcelPath = "Login.xlsx>data>login_2_3";
    private  Map<String,Object> dataItem = null;
    private static Integer i = 0;

    public Login(){
        Setup.pass = 0;
        setup= new Setup(screnario,testname);
        setup.setupDriver(urlLink,browser);
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
    @Given("Kiểm tra màn hình bao gồm các thông tin")
    public void checkItemInLoginPage(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.validateScreenLogin_2(driver));
            Setup.testLogs.log(LogStatus.PASS,"Kiểm tra các thông tin màn đăng nhập thành công","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Kiểm tra các thông tin màn đăng nhập thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Given("Nhập thông tin email hợp lệ và nhập password hợp lệ và  Click button Đăng nhập")
    public void checkLogin(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.checkLoginPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Check login page success","");
            assertTrue(loginAction.insertUsernameAndPassword(driver,dataItem.get("Username").toString(),dataItem.get("Password").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Input username and password and click button login success ","");
            assertTrue(loginAction.checkLoginSuccess(driver));
            Setup.testLogs.log(LogStatus.PASS,"login page success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"login page fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Đăng nhập thành công, hiển thị màn hình home")
    public void checkLoginSuccess(){
        try{
            assertTrue(loginAction.checkLoginSuccess(driver));
            Setup.testLogs.log(LogStatus.PASS,"Check login page success","");
            Setup.pass++;
            setup.after(false);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Check login page fail",e.getMessage());
            setup.afterFail(false);
        }
    }
}
