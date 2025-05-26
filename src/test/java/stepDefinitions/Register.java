package stepDefinitions;

import Common.Setup;
import FilesUtils.MapData;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.LoginAction;
import pageobjects.RegisterAction;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class Register {
    private Setup setup;
    private LoginAction loginAction = null;
    private RegisterAction registerAction = null;
    private WebDriver driver = null;
    private String screnario = "Test register";
    private String testname = "Validate and register";
    private String urlLink = "https://careerlink.fun/nguoi-tim-viec/login";
    private static List<Map<String,Object>> data  = null;
    private String browser = "firefox";
    //format path excel Tên file >sheet name > testcase name
    private String dataExcelPath = "Register.xlsx>data>Register";
    private  Map<String,Object> dataItem = null;
    private static Integer i = 0;

    public Register(){
        Setup.pass = 0;
        setup= new Setup(screnario,testname);
        setup.setupDriver(urlLink,browser);
        if (data == null){
            data = setup.getDataFromExcelFile(dataExcelPath, MapData.registerColoumn);
        }
        if (driver == null){
            driver = Setup.driver;
        }
        if (loginAction == null){
            loginAction = new LoginAction();
        }
        if (registerAction == null){
            registerAction = new RegisterAction();
        }
        Setup.colPass = 7;
        Setup.colFail = 8;
        i++;
        dataItem = data.get(i-1);
    }
    @When("Tại màn hình đăng ký")
    public void navigateToRegister(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(loginAction.checkLoginPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị trang đăng nhập","");
            assertTrue(loginAction.clickButtonDangKy(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button Đăng kí thành công","");
            assertTrue(registerAction.checkItemInPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị màn hình đăng kí thành công ","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị màn hình đăng kí thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Hiển thị các thông tin")
    public void checkToRegister(){
        try{
            assertTrue(registerAction.checkItemInPage(driver));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị các thông tin thành công","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị các thông tin thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }

    //DK_3
    @And("Nhập email đã tồn tại và nhập các trường khác hợp lệ")
    public void inputEmailExistAndAllField(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(registerAction.inputAllDataInPageRegister(driver,dataItem.get("FullName").toString(),dataItem.get("Email").toString(),dataItem.get("Password").toString(),dataItem.get("PasswordConfirm").toString()));
            WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"job_seeker_agreement\"]"));
            if (!checkbox.isSelected()){
                checkbox.click();
            }
            Setup.testLogs.log(LogStatus.PASS,"Nhập email đã tồn tại và nhập các trường khác hợp lệ thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị các thông tin thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @And("Click button đăng ký")
    public void clickButtonRegister(){
        try{
            assertTrue(registerAction.clickButtonDangKy(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button đăng ký thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button đăng ký thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Hiển thị thông báo lỗi : Email đã được sử dụng")
    public void checkMessageInEmail(){
        try{
            assertTrue(registerAction.checkResult(driver,dataItem.get("Message").toString(), By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]")));
            Setup.testLogs.log(LogStatus.PASS,"Hiển thị thông báo lỗi : Email đã được sử dụng thành công","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị thông báo lỗi : Email đã được sử dụng thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }

    //DK_4
    @And("Nhập mật khẩu hợp lệ và nhập xác nhận mật khẩu không khớp với mật khẩu")
    public void inputPassword(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(registerAction.inputAllDataInPageRegister(driver,dataItem.get("FullName").toString(),dataItem.get("Email").toString(),dataItem.get("Password").toString(),dataItem.get("PasswordConfirm").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập mật khẩu hợp lệ và nhập xác nhận mật khẩu không khớp với mật khẩu thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Nhập mật khẩu hợp lệ và nhập xác nhận mật khẩu không khớp với mật khẩu thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Mật khẩu không khớp. Hãy nhập lại")
    public void checkMessageInPassword(){
        try{
            assertTrue(registerAction.checkResult(driver,dataItem.get("Message").toString(), By.xpath("//*[@id=\"register_form\"]/div[3]/div[2]/div/div")));
            Setup.testLogs.log(LogStatus.PASS,"Mật khẩu không khớp. Hãy nhập lại thành công","");
            Setup.pass++;
            setup.after(true);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Mật khẩu không khớp. Hãy nhập lại thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }

    //DK_5
    @And("Nhập mật khâu và xác nhận mật khẩu hợp lệ")
    public void inputPassAndConfirmPass(){
        try{
            Setup.row = Integer.parseInt(dataItem.get("No").toString());
            assertTrue(registerAction.inputAllDataInPageRegister(driver,dataItem.get("FullName").toString(),dataItem.get("Email").toString(),dataItem.get("Password").toString(),dataItem.get("PasswordConfirm").toString()));
            Setup.testLogs.log(LogStatus.PASS,"Nhập mật khâu và xác nhận mật khẩu hợp lệ thành công","");
            Setup.pass++;
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Nhập mật khâu và xác nhận mật khẩu hợp lệ thất bại",e.getMessage());
            setup.afterFail(true);
        }
    }
    @Then("Click Hiển thị mật khẩu và Hiển thị mật khẩu đã nhập")
    public void clickButtonShowPassword(){
        try{
            assertTrue(registerAction.clickShowPassword(driver));
            Setup.testLogs.log(LogStatus.PASS,"Click button Hiển thị mật khẩu và Hiển thị mật khẩu đã nhập thất bại","");
            Setup.pass++;
            setup.after(false);
        }catch (AssertionError e){
            Setup.testLogs.log(LogStatus.FAIL,"Click button Hiển thị mật khẩu và Hiển thị mật khẩu đã nhập thất bại",e.getMessage());
            setup.afterFail(false);
        }
    }

    //DK_6
//    @And("Nhập các trường hợp lệ")
//    public void inputAllField(){
//        try{
//            Setup.row = Integer.parseInt(dataItem.get("No").toString());
//            assertTrue(registerAction.inputAllDataInPageRegister(driver,dataItem.get("FullName").toString(),dataItem.get("Email").toString(),dataItem.get("Password").toString(),dataItem.get("PasswordConfirm").toString()));
//            Setup.testLogs.log(LogStatus.PASS,"Nhập email đã tồn tại và nhập các trường khác hợp lệ thành công","");
//            Setup.pass++;
//        }catch (AssertionError e){
//            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị các thông tin thất bại",e.getMessage());
//            setup.afterFail();
//        }
//    }
//    @And("Click button đăng ký tài khoản người tìm việc")
//    public void clickRegister(){
//        try{
//            assertTrue(registerAction.clickButtonDangKy(driver));
//            Setup.testLogs.log(LogStatus.PASS,"Click button đăng ký tài khoản người tìm việc thành công","");
//            Setup.pass++;
//        }catch (AssertionError e){
//            Setup.testLogs.log(LogStatus.FAIL,"Click button đăng ký tài khoản người tìm việc thất bại",e.getMessage());
//            setup.afterFail();
//        }
//    }
//    @Then("Hiển thị màn hình gửi mã email thành công")
//    public void checkMessage(){
//        try{
//            assertTrue(registerAction.checkResult(driver,dataItem.get("Message").toString(), By.xpath("//span[@data-message='taken']")));
//            Setup.testLogs.log(LogStatus.PASS,"Hiển thị màn hình gửi mã email thành công","");
//            Setup.pass++;
//            setup.after(false);
//        }catch (AssertionError e){
//            Setup.testLogs.log(LogStatus.FAIL,"Hiển thị màn hình gửi mã email thất bại",e.getMessage());
//            setup.afterFail();
//        }
//    }
}
