package stepDefinitions;

import Common.Setup;
import FilesUtils.MapData;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.CheckDescriptionAction;
import pageobjects.CheckDisplayScreenAction;
import pageobjects.CheckWhenNotEnteringInfomationAction;
import pageobjects.LoginAction;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CheckDisplayScreen {
    private Setup setup;
    private CheckDescriptionAction checkDescriptionAction = null;
    private CheckDisplayScreenAction checkDisplayScreenAction = null;
    private CheckWhenNotEnteringInfomationAction checkWhenNotEnteringInfomation = null;
    private LoginAction loginAction = null;
    private WebDriver driver = null;
    private String screnario = "Cover_letter_2 Check the display of the cover letter";
    private String testname = "Check the display of the cover letter creation screen";
    private String urlLink = "https://careerlink.fun/nguoi-tim-viec/login";
    private static List<Map<String,Object>> data  = null;
    private String browser = "firefox";
    //format path excel Tên file >sheet name > testcase name
    private String dataExcelPath = "CheckDisplay.xlsx>data>Cover_letter_2";
    private  Map<String,Object> dataItem = null;
    private static Integer i = 0;

    public CheckDisplayScreen() {
        Setup.pass = 0;
        setup = new Setup(screnario, testname);
        setup.setupDriver(urlLink, browser);
        if (data == null) {
            data = setup.getDataFromExcelFile(dataExcelPath, MapData.checkDisplayScreenColoumn);
        }
        if (driver == null) {
            driver = Setup.driver;
        }
        if (checkDescriptionAction == null) {
            checkDescriptionAction = new CheckDescriptionAction();
        }
        if (loginAction == null) {
            loginAction = new LoginAction();
        }
        if (checkDisplayScreenAction == null) {
            checkDisplayScreenAction = new CheckDisplayScreenAction();
        }
        if (checkWhenNotEnteringInfomation == null) {
            checkWhenNotEnteringInfomation = new CheckWhenNotEnteringInfomationAction();
        }
        if (Setup.colPass == 0 || Setup.colFail == 0) {
            Setup.colPass = 4;
            Setup.colFail = 5;
        }
        i++;
        dataItem = data.get(i-1);
    }
    @Given("The user login to page with username and password")
    public void loginPage(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.checkLoginPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Check login page success","");
            assertTrue(loginAction.insertUsernameAndPassword(driver,dataItem.get("Username").toString(),dataItem.get("Password").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Input username and password success","");
            assertTrue(loginAction.checkLoginSuccess(driver));
            Setup.testLogs.log(LogStatus.PASS,"Check login page success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Login fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("At the job application screen and at the cover letter folder")
    public void navigateToScreenJobAppication(){
        try{
            assertTrue(loginAction.navigateToJobApplication(driver));
            Setup.testLogs.log(LogStatus.PASS,"Navigate the job application screen and at the cover letter folder success","");
            Setup.pass++;
        }catch (Exception e){
            Setup.testLogs.log(LogStatus.FAIL,"Navigate the job application screen and at the cover letter folder fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Click the button Create new mail")
    public void navigateToScreen(){
        try {
            assertTrue(checkDisplayScreenAction.navigateToCreateJob(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click the button Create new mail success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click the button Create new mail fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Show screen create new mail")
    public void checkScreenSuccess(){
        try {
            assertTrue(checkDisplayScreenAction.checkShowTitleAndDescription(driver));
            Setup.testLogs.log(LogStatus.PASS,"Check Show Title And Description success","");
            setup.after(false);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Check Show Title And Description fail",e.getMessage());
            setup.afterFail(false);
        }
    }

}
