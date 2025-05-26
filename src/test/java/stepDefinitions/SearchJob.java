package stepDefinitions;

import Common.Setup;
import FilesUtils.MapData;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginAction;
import pageobjects.SaveJobAction;
import pageobjects.SearchJobAction;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class SearchJob {
    private LoginAction loginAction = null;
    private SaveJobAction saveJobAction= null;
    private SearchJobAction searchJobAction = null;
    private Setup setup;
    private WebDriver driver = null;
    private String screnario = "Check search job page";
    private String testname = "Testcase search job";
    private String urlLink = "https://careerlink.fun/nguoi-tim-viec/login";
    private static List<Map<String,Object>> data  = null;
    private String browser = "firefox";
    //format path excel Tên file >sheet name > testcase name
    private String dataExcelPath = "SearchJob.xlsx>data>Search_Job";
    private String dataExcelPathSave = "SearchJob.xlsx>data>Search_Job";
    private  Map<String,Object> dataItem = null;
    private static Integer i = 0;

    public SearchJob(){
        Setup.pass = 0;
        setup= new Setup(screnario,testname);
        setup.setupDriver(urlLink,browser);
        if (data == null){
            data = setup.getDataFromExcelFile(dataExcelPath, MapData.searchJobColoumn);
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
        Setup.colPass = 6;
        Setup.colFail = 7;
        i++;
        dataItem = data.get(i-1);
    }
    @Given("Đăng nhập vào trang chủ")
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
//    @And("Ấn button tìm kiếm")
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

    //Search_2
    @Then("Hiển thị các ô input")
    public void checkShowItemInPage(){
        try{
            assertTrue(searchJobAction.checkItemInPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Navigate to search job page success","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Navigate to search job page fail",e.getMessage());
            setup.afterFail(true);
        }
    }

    //Search_3
    @And("Bỏ trống 2 trường click button tìm kiếm")
    public void inputSearchJob(){
        try{
            assertTrue(searchJobAction.inputCityAndCompany(driver,dataItem.get("City").toString(),dataItem.get("Company").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Input city and company success","");
            assertTrue(searchJobAction.clickButtonSearch(driver));
            Setup.testLogs.log(LogStatus.PASS,"Input city and company success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Input city and company fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Hiển thị toàn bộ kết quả")
    public void clickButtonSave(){
        try{
            assertTrue(searchJobAction.checkResultWhenSearch(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị toàn bộ kết quả success","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị toàn bộ kết quả fail",e.getMessage());
            setup.afterFail(true);
        }
    }

    //Search_4
    @And("Nhập Tên vị trí, công ty từ khóa và click button tìm kiếm")
    public void inputCompany(){
        try{
            assertTrue(searchJobAction.inputCityAndCompany(driver,dataItem.get("City").toString(),dataItem.get("Company").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Input  company success","");
            assertTrue(searchJobAction.clickButtonSearch(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button search success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Nhập Tên vị trí, công ty từ khóa và click button tìm kiếm fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Hiển thị toàn bộ kết quả khi nhập tên vị trí")
    public void checkResultWhenInputLocaltion(){
        try{
            assertTrue(searchJobAction.checkResultWhenSearch(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị toàn bộ kết quả khi nhập tên vị trí success","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị toàn bộ kết quả khi nhập tên vị trí fail",e.getMessage());
            setup.afterFail(true);
        }
    }

    //Search_5
    @And("Nhập tỉnh, thành phố và click button tìm kiếm")
    public void inputCity(){
        try{
            assertTrue(searchJobAction.inputCityAndCompany(driver,dataItem.get("City").toString(),dataItem.get("Company").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập tỉnh, thành phố success","");
            assertTrue(searchJobAction.clickButtonSearch(driver));
            Setup.testLogs.log(LogStatus.PASS,"click button tìm kiếm success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Nhập tỉnh, thành phố và click button tìm kiếm fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Hiển thị toàn bộ kết quả khi nhập tỉnh, thành phố")
    public void checkResultWhenInputCity(){
        try{
            assertTrue(searchJobAction.checkResultWhenSearch(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị toàn bộ kết quả khi nhập tỉnh, thành phố success","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị toàn bộ kết quả khi nhập tỉnh, thành phố fail",e.getMessage());
            setup.afterFail(true);
        }
    }

    //Search_6
    @And("Nhập 2 trường tìm kiếm và click button tìm kiếm")
    public void inputAllTwoField(){
        try{
            assertTrue(searchJobAction.inputCityAndCompany(driver,dataItem.get("City").toString(),dataItem.get("Company").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập 2 trường và click button tìm kiếm success","");
            assertTrue(searchJobAction.clickButtonSearch(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button tìm kiếm success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Nhập 2 trường và click button tìm kiếm thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Hiển thị toàn bộ kết quả khi nhập thông tin 2 trường tìm kiếm")
    public void checkResult(){
        try{
            assertTrue(searchJobAction.checkResultWhenSearch(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị toàn bộ kết quả khi nhập thông tin 2 trường tìm kiếm thành công","");
            Setup.pass++;
            setup.after(false);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị toàn bộ kết quả khi nhập thông tin 2 trường tìm kiếm thất bại",e.getMessage());
            setup.afterFail(false);
        }
    }
}
