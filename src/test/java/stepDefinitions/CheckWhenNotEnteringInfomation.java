package stepDefinitions;

import Common.Events;
import Common.Setup;
import FilesUtils.MapData;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.CheckDescriptionAction;
import pageobjects.CheckDisplayScreenAction;
import pageobjects.CheckWhenNotEnteringInfomationAction;
import pageobjects.LoginAction;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CheckWhenNotEnteringInfomation{
    private Setup setup;
    private CheckDescriptionAction checkDescriptionAction = null;
    private CheckDisplayScreenAction checkDisplayScreenAction = null;
    private CheckWhenNotEnteringInfomationAction checkWhenNotEnteringInfomationAction = null;
    private LoginAction loginAction = null;
    private WebDriver driver = null;
    private String screnario = "Check when not entering information in 1 of 2 fields";
    private String testname = "Check when not entering information in 1 of 2 fields and entering 2 fields";
    private String urlLink = "https://careerlink.fun/nguoi-tim-viec/login";
    private static List<Map<String,Object>> data  = null;
    private String browser = "firefox";
    //format path excel Tên file >sheet name > testcase name
    private String dataExcelPath = "CheckEntering.xlsx>data>Cover_letter_3_4_5";
    private  Map<String,Object> dataItem = null;
    private static Integer i = 0;

    public CheckWhenNotEnteringInfomation(){
        Setup.pass = 0;
        setup= new Setup(screnario,testname);
        setup.setupDriver(urlLink,browser);
        if (data == null){
            data = setup.getDataFromExcelFile(dataExcelPath, MapData.checkWhenNotEnteringInfomationColoumn);
        }
        if (driver == null){
            driver = Setup.driver;
        }
        if (checkDescriptionAction == null){
            checkDescriptionAction = new CheckDescriptionAction();
        }
        if (loginAction == null){
            loginAction = new LoginAction();
        }
        if (checkDisplayScreenAction == null){
            checkDisplayScreenAction = new CheckDisplayScreenAction();
        }
        if (checkWhenNotEnteringInfomationAction == null){
            checkWhenNotEnteringInfomationAction = new CheckWhenNotEnteringInfomationAction();
        }
        Setup.colPass = 7;
        Setup.colFail = 8;
        i++;
        dataItem = data.get(i-1);
    }
    @Given("The user to login with username and password")
    public void loginPageNotEntering(){
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
    @And("At the screen to create a cover letter")
    public void navigateToScreenCreate(){
        try {
            assertTrue(loginAction.navigateToJobApplication(driver));
            Setup.testLogs.log(LogStatus.PASS,"Navigate to cover letter success","");
            assertTrue(checkDisplayScreenAction.navigateToCreateJob(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button create job success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Navigate to cover letter fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    // Cover_letter_3
    @When("Do not enter Title and import content")
    public void inputTitleAndContent(){
        try {
            assertTrue(checkDisplayScreenAction.checkShowTitleAndDescription(driver));
            Setup.testLogs.log(LogStatus.PASS,"Show screen add title and description","");
            assertTrue(checkWhenNotEnteringInfomationAction.checkInputTitleAndDescription(driver,dataItem.get("Title").toString(),dataItem.get("Description").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Do not enter Title and import content success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Do not enter Title and import content fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Click the button Create a cover letter")
    public void clickButtonCreate(){
        try {
            assertTrue(checkWhenNotEnteringInfomationAction.clickButtonCreate(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button create success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button create fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Show error message error title")
    public void checkMessageErrorTitle(){
        try {
            assertTrue(checkWhenNotEnteringInfomationAction.checkMessageShowInTitle(driver,dataItem.get("Message").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Check show message in title is success","");
            Setup.pass++;
            Thread.sleep(1000);
            Events.captureScreenSelenium(driver);
            Thread.sleep(2000);
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Check show message in title is fail",e.getMessage());
            setup.afterFail(true);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    // Cover_letter_4
    @When("Enter Title and do not enter content")
    public void inputTitleAndNotContent(){
        try {
            assertTrue(checkDisplayScreenAction.checkShowTitleAndDescription(driver));
            Setup.testLogs.log(LogStatus.PASS,"Show screen add title and description","");
            assertTrue(checkWhenNotEnteringInfomationAction.checkInputTitleAndDescription(driver,dataItem.get("Title").toString(),dataItem.get("Description").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Do not enter Title and import content success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Do not enter Title and import content fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Click the button create letter")
    public void clickButtonCreateLetter(){
        try {
            assertTrue(checkWhenNotEnteringInfomationAction.clickButtonCreate(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button create success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button create fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Show error message error content")
    public void checkMessageErrorContent(){
        try {
            assertTrue(checkWhenNotEnteringInfomationAction.checkMessageShowDescription(driver,dataItem.get("Message").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Check show message in content is success","");
            Setup.pass++;
            Thread.sleep(1000);
            Events.captureScreenSelenium(driver);
            Thread.sleep(2000);
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Check show message in content is fail",e.getMessage());
            setup.afterFail(true);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    // Cover_letter_5
    @When("Enter Title and enter content")
    public void inputAllTitleAndContent(){
        try {
            assertTrue(checkDisplayScreenAction.checkShowTitleAndDescription(driver));
            Setup.testLogs.log(LogStatus.PASS,"Show screen add title and description","");
            assertTrue(checkWhenNotEnteringInfomationAction.checkInputTitleAndDescription(driver,dataItem.get("Title").toString(),dataItem.get("Description").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Do import Title and import content success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Do import Title and import content fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Click the button create a cover")
    public void clickButtonCreateConverLetter(){
        try {
            assertTrue(checkWhenNotEnteringInfomationAction.clickButtonCreate(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button create success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button create fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Create mail success")
    public void checkMessageSucces(){
        try {
            assertTrue(checkWhenNotEnteringInfomationAction.checkMessageShowSuccess(driver,dataItem.get("Message").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Check show message create success is success","");
            Setup.pass++;
            Thread.sleep(1000);
            Events.captureScreenSelenium(driver);
            Thread.sleep(2000);
            setup.after(false);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Check show message create success  is fail",e.getMessage());
            setup.afterFail(false);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
