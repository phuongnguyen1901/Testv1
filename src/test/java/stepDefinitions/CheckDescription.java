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

public class CheckDescription {
    private Setup setup;
    private CheckDescriptionAction checkDescriptionAction = null;
    private CheckDisplayScreenAction checkDisplayScreenAction = null;
    private CheckWhenNotEnteringInfomationAction checkWhenNotEnteringInfomation = null;
    private LoginAction loginAction = null;
    private WebDriver driver = null;
    private String screnario = "Check when entering content";
    private String testname = "Entering content < 10 characters and content > 10 characters";
    private String urlLink = "https://careerlink.fun/nguoi-tim-viec/login";
    private static List<Map<String,Object>> data  = null;
    private static List<Map<String,Object>> data1  = null;
    private String browser = "firefox";
    //format path excel Tên file >sheet name > testcase name
    private String dataExcelPath = "CheckDescription1.xlsx>data>Cover_letter_6_7";
    private String dataExcelPath1 = "CheckDescription2.xlsx>data>Cover_letter_6_7";
    private  Map<String,Object> dataItem = null;
    private  Map<String,Object> dataItem1 = null;
    private static Integer i = 0;

    public CheckDescription(){
        Setup.pass = 0;
        setup= new Setup(screnario,testname);
        setup.setupDriver(urlLink,browser);
        if (data == null){
            data = setup.getDataFromExcelFile(dataExcelPath, MapData.checkDescriptionColoum);
        }
        if (data1 == null){
            data1= setup.getDataFromExcelFile(dataExcelPath1, MapData.checkDescriptionColoum);
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
        if (checkWhenNotEnteringInfomation == null){
            checkWhenNotEnteringInfomation = new CheckWhenNotEnteringInfomationAction();
        }
        Setup.colPass = 7;
        Setup.colFail = 8;
        i++;
        dataItem = data.get(0);
        dataItem1 = data1.get(0);
    }
    @Given("The user login with username and password")
    public void loginPageCheckDescription(){
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
    @And("In the screen to create a cover letter")
    public void navigateToScreenCheckDescripTion(){
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
    //testcase Cover_letter_6
    @When("Enter Valid Title and enter text <10 characters")
    public void enterTextSmall10(){
        try{
            assertTrue(checkDisplayScreenAction.checkShowTitleAndDescription(driver));
            Setup.testLogs.log(LogStatus.PASS,"Show screen add title and description","");
            assertTrue(checkWhenNotEnteringInfomation.checkInputTitleAndDescription(driver,dataItem.get("Title").toString(),dataItem.get("Description").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Enter title and description  < 10 characters success","");
            Setup.pass++;
        }catch (Exception e){
            Setup.testLogs.log(LogStatus.FAIL,"Enter title and description  < 10 characters fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Click the button create")
    public void clickButtonCreate(){
        try{
            assertTrue(checkWhenNotEnteringInfomation.clickButtonCreate(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button success","");
            Setup.pass++;
        }catch (Exception e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Show error message")
    public void checkMessageShowData(){
        try {
            assertTrue(checkDescriptionAction.validateMessageCharacters(driver,dataItem.get("Message").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Check message success","");
            Thread.sleep(1000);
            Events.captureScreenSelenium(driver);
            Thread.sleep(2000);
            setup.after(true);
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Check message fail",e.getMessage());
            setup.afterFail(true);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //testcase Cover_letter_7
    @When("Enter Valid Title and enter text >10 characters")
    public void enterTextBigger10(){
        try{
            assertTrue(checkDisplayScreenAction.checkShowTitleAndDescription(driver));
            Setup.testLogs.log(LogStatus.PASS,"Show screen add title and description","");
            assertTrue(checkWhenNotEnteringInfomation.checkInputTitleAndDescription(driver,dataItem1.get("Title").toString(),dataItem1.get("Description").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Enter title and description  > 10 characters success","");
            Setup.pass++;
        }catch (Exception e){
            Setup.testLogs.log(LogStatus.FAIL,"Enter title and description  > 10 characters fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Click the button create a cover letter")
    public void clickButton(){
        try{
            assertTrue(checkWhenNotEnteringInfomation.clickButtonCreate(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button success","");
            Setup.pass++;
        }catch (Exception e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Create mail successfully")
    public void checkMessageSuccess(){
        try {
            assertTrue(checkWhenNotEnteringInfomation.checkMessageShowSuccess(driver,dataItem1.get("Message").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Check message success","");
            Thread.sleep(1000);
            Events.captureScreenSelenium(driver);
            Thread.sleep(2000);
            Setup.pass++;
            setup.after(false);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Check message fail",e.getMessage());
            setup.afterFail(false);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
