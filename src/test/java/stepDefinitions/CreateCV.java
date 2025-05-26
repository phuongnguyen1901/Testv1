package stepDefinitions;

import Common.Setup;
import FilesUtils.MapData;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.CreateCVAction;
import pageobjects.LoginAction;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CreateCV {
    private Setup setup;
    private LoginAction loginAction = null;
    private CreateCVAction createCVAction = null;
    private WebDriver driver = null;
    private String screnario = "Validate CV and create cv";
    private String testname = "Validate and create CV";
    private String urlLink = "https://careerlink.fun/nguoi-tim-viec/login";
    private static List<Map<String,Object>> data  = null;
    private String browser = "firefox";
    //format path excel Tên file >sheet name > testcase name
    private String dataExcelPath = "CreateCV.xlsx>data>CreateCV";
    private  Map<String,Object> dataItem = null;
    private static Integer i = 0;

    public CreateCV(){
        Setup.pass = 0;
        setup= new Setup(screnario,testname);
        setup.setupDriver(urlLink,browser);
        if (data == null){
            data = setup.getDataFromExcelFile(dataExcelPath, MapData.createCVColoumn);
        }
        if (driver == null){
            driver = Setup.driver;
        }
        if (loginAction == null){
            loginAction = new LoginAction();
        }
        if (createCVAction == null){
            createCVAction = new CreateCVAction();
        }
        Setup.colPass = 27;
        Setup.colFail = 28;
        i++;
        dataItem = data.get(i-1);
    }
    @Given("The user login with username and password and naviate to tạo hồ sơ")
    public void loginPageCheckDescription(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.checkLoginPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Check login page success","");
            assertTrue(loginAction.insertUsernameAndPassword(driver,dataItem.get("Username").toString(),dataItem.get("Password").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Input username and password and click button login success ","");
            assertTrue(loginAction.checkLoginSuccess(driver));
            Setup.testLogs.log(LogStatus.PASS,"login page success","");
            assertTrue(loginAction.navigateToJobApplication(driver));
            Setup.testLogs.log(LogStatus.PASS,"Navigate to job application success","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Navigate to job application fail",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Button Tạo hồ sơ -> Tạo hồ sơ theo từng bước")
    public void navigateToTaoHoSo(){
        try{
            assertTrue(createCVAction.clickButtonTaoHoSo(driver));
            Setup.testLogs.log(LogStatus.PASS,"Button Tạo hồ sơ -> Tạo hồ sơ theo từng bước thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Button Tạo hồ sơ -> Tạo hồ sơ theo từng bước thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Hiển thị màn hình hồ sơ xin việc")
    public void showTaoHoSo(){
        try{
            assertTrue(createCVAction.switchScreen(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị màn hình hồ sơ xin việc thành công","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị màn hình hồ sơ xin việc thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }

    //crCV_4
    @And("Nhập các thông tin hợp lệ")
    public void createCV(){
        try{
//            assertTrue(createCVAction.clickButtonTaoHoSo(driver));
//            Setup.testLogs.log(LogStatus.PASS,"Button Tạo hồ sơ -> Tạo hồ sơ theo từng bước thành công","");
            assertTrue(createCVAction.switchScreen(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị màn hình hồ sơ xin việc thành công","");

            assertTrue(createCVAction.inputScreenStep1(driver,dataItem.get("TenHoSo").toString(),dataItem.get("Ten").toString(),dataItem.get("QuocTich").toString(),dataItem.get("Ngay").toString(),dataItem.get("Thang").toString(),dataItem.get("Nam").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập thông tin màn 1","");
            assertTrue(createCVAction.clickButtonContinue(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button continue screen 1","");

            assertTrue(createCVAction.inputScreenStep2(driver,dataItem.get("SDT").toString(),dataItem.get("Email").toString(),dataItem.get("DiaChiDuong").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập thông tin màn 2","");
            assertTrue(createCVAction.clickButtonContinue(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button continue screen 2","");

            assertTrue(createCVAction.inputScreenStep3(driver,dataItem.get("TenTruong").toString(),dataItem.get("NgayBatDau").toString(),dataItem.get("NgayKetThuc").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập thông tin màn 3","");
            assertTrue(createCVAction.clickButtonContinue(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button continue screen 3","");
            assertTrue(createCVAction.clickButtonContinue(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button continue screen 3 save","");

            assertTrue(createCVAction.inputScreenStep4(driver,dataItem.get("TrinhDo").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập thông tin màn 4","");
            assertTrue(createCVAction.clickButtonContinue(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button continue screen 4","");

            assertTrue(createCVAction.inputScreenStep5(driver,dataItem.get("TongSoNamKinhNghiem").toString(),dataItem.get("TenCongTy").toString(),dataItem.get("ChucNang").toString(),dataItem.get("NgayBatDau").toString(),dataItem.get("NgayKetThuc").toString(),dataItem.get("MoTa").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập thông tin màn 5","");
            assertTrue(createCVAction.clickButtonContinue(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button continue screen 5","");
            assertTrue(createCVAction.clickButtonContinue(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button continue screen 5 save","");

            assertTrue(createCVAction.clickButtonContinue(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button continue screen 6","");

            assertTrue(createCVAction.inputScreenStep7(driver,dataItem.get("KyNang").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập thông tin màn 7","");
            assertTrue(createCVAction.clickButtonContinue(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button continue screen 7","");

            assertTrue(createCVAction.inputScreenStep8(driver,dataItem.get("ViTriMongMuon").toString(),dataItem.get("MucLuongMongMuon").toString(),dataItem.get("LoaiCongViec").toString(),dataItem.get("CapBacMongMuon").toString(),dataItem.get("MucTieuNgheNghiep").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập thông tin màn 8","");
            assertTrue(createCVAction.clickButtonContinue(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button continue screen 8","");

            assertTrue(createCVAction.clickButtonContinue(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button continue screen 9","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị màn hình hồ sơ xin việc thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Tạo cv thành công")
    public void createCVSuccess(){
        try{
            assertTrue(createCVAction.checkButtonTaoHoSo(driver));
            Setup.testLogs.log(LogStatus.PASS,"Tạo cv thành công","");
            Setup.pass++;
            setup.after(false);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Tạo cv  thất bại",e.getMessage());
            setup.afterFail(false);
        }
    }
}
