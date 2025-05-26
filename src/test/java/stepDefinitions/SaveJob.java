package stepDefinitions;

import Common.Events;
import Common.Setup;
import FilesUtils.ExcelFile;
import FilesUtils.MapData;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginAction;
import pageobjects.SaveJobAction;
import pageobjects.SearchJobAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class SaveJob {
    private LoginAction loginAction = null;
    private SaveJobAction saveJobAction= null;
    private SearchJobAction searchJobAction = null;
    private Setup setup;
    private WebDriver driver = null;
    private String screnario = "Check save job page";
    private String testname = "Testcase to save job page and step to save job";
    private String urlLink = "https://careerlink.fun/nguoi-tim-viec/login";
    private static List<Map<String,Object>> data  = null;
    private String browser = "firefox";
    //format path excel Tên file >sheet name > testcase name
    private String dataExcelPath = "SaveJob.xlsx>data>Save_Job";
    private String dataExcelPathSave = "SaveJob.xlsx>data>Save_Job";
    private  Map<String,Object> dataItem = null;
    private static Integer i = 0;

    public SaveJob(){
        Setup.pass = 0;
        setup= new Setup(screnario,testname);
        setup.setupDriver(urlLink,browser);
        if (data == null){
            data = setup.getDataFromExcelFile(dataExcelPath, MapData.saveJobColoumn);
        }
        if(saveJobAction == null){
            saveJobAction = new SaveJobAction();
        }
        if (searchJobAction == null){
            searchJobAction = new SearchJobAction();
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
    @Given("Đăng nhập vào trang web")
    public void loginPage(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.checkLoginPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Check login page success","");
            assertTrue(loginAction.insertUsernameAndPassword(driver,dataItem.get("Username").toString(),dataItem.get("Password").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Input username and password success","");
            assertTrue(loginAction.checkLoginSuccess(driver));
            Setup.testLogs.log(LogStatus.PASS,"Login success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Login fail",e.getMessage());
            setup.afterFail(true);
        }
    }
//    @And("Click button tìm kiếm")
//    public void naviagetToSearchPage(){
//        try{
//            assertTrue(searchJobAction.clickButtonSearchJob(driver));
//            Setup.testLogs.log(LogStatus.PASS,"Navigate to search job page success","");
//            Setup.pass++;
//        }catch (AssertionError e){
//            Setup.testLogs.log(LogStatus.FAIL,"Navigate to search job page fail",e.getMessage());
//            setup.afterFail(true);
//        }
//    }
    //Save_job_1
    @And("Nhập 2 trường và click button tìm kiếm")
    public void inputSearchJob(){
        try{
            assertTrue(searchJobAction.inputCityAndCompany(driver,dataItem.get("City").toString(),dataItem.get("Company").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Input city and company success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Input city and company fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Click button lưu")
    public void clickButtonSave(){
        try{
            assertTrue(saveJobAction.clickButtonSaveJob(driver,dataExcelPathSave,MapData.saveJobColoumn));
            Setup.testLogs.log(LogStatus.PASS,"Click button lưu success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button lưu fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Lưu thành công, button chuyển sang trạng thái lưu thành công")
    public void checkSaveSuccess(){
        try{
            assertTrue(saveJobAction.checkWhenClickSave(driver));
            Setup.testLogs.log(LogStatus.PASS,"Lưu thành công, button chuyển sang trạng thái lưu thành công","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Lưu thành công, button chuyển sang trạng thái lưu fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    //Save_job_2
    @And("Tại màn hình lưu công việc")
    public void checkInSaveJobPage(){
        try{
            assertTrue(saveJobAction.navigateToSaveJob(driver));
            Setup.testLogs.log(LogStatus.PASS,"Tại màn hình lưu công việc thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Tại màn hình lưu công việc thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Hiển thị công việc đã lưu")
    public void checkViewJobInPage(){
        try{
            assertTrue(saveJobAction.checkJobWhenSave(driver,SaveJobAction.jobTitle));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị công việc đã lưu thành công","");
            Events.captureScreenSelenium(driver);
            Thread.sleep(3000);
            saveJobAction.removeSaveJob(driver);
            Setup.pass++;
            setup.after(false);
            if(!StringUtils.isBlank(SaveJobAction.jobTitle)){
                Map<String,Object> listData = new HashMap<>();
                listData.put("TitleJob",SaveJobAction.jobTitle);
                ExcelFile.insertDataToExcelFile(listData,MapData.saveJobColoumn,dataExcelPath);
                System.out.println("insert cell to file excel success");
            }
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị công việc đã lưu thất bại",e.getMessage());
            setup.afterFail(false);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
