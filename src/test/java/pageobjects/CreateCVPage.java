package pageobjects;

import Common.Utility;
import Model.CVInformations;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.time.Duration;

public class CreateCVPage {
    WebDriver driver;
    // dùng khai báo biến mà mình bắt location
    @FindBy(css=".create-resume")
    WebElement btnCreateCV;
    @FindBy(xpath = "//*[@id=\"form-edit-container\"]/div/form/label/input")
    WebElement tbTieuDeHoSo;
    @FindBy(xpath = "//div[contains(text(), \"Quốc tịch\")]/..//select")
    WebElement cboQuocTich;
    //    @FindBy(css="input[name=\"uploadedImage\"]")
//    WebElement uploadAvatar;
    @FindBy(xpath = "//div[@class='col-3']//div[@class='fluent-select']//select")
    WebElement cboNgay;
    @FindBy(xpath = "//div[@class='col']//div[@class='fluent-select']//select")
    WebElement cboThang;
    @FindBy(xpath = "//div[@class='col-4']//div[@class='fluent-select']//select")
    WebElement cboNam;
    @FindBy(xpath = "//label[3]//label[1]/div[@class='checkmark']")
    WebElement btnSingle;
    @FindBy(xpath = "//label[4]//label[1]/div[@class='checkmark']")
    WebElement btnSex ;
    @FindBy(xpath = "//button[@id='go-to-next']")
    WebElement btnNext ;
    @FindBy(xpath ="//button[.='Tiếp tục']")
    WebElement btnGo;
    @FindBy(xpath = "//div[@class='form-row']//input")
    WebElement inputNumberPhone;
    @FindBy(xpath = "//div[@class='dropdown cl-select']")
    WebElement labelNation;
    @FindBy(xpath = "//button[.='Viet Nam']")
    WebElement labelVietNam;

    @FindBy (xpath = "//div[@class='form-row']//button[@class='btn button-dropdown  ']")
    WebElement labelCity;
    @FindBy(xpath = "//button[.='Hà Nội']")
    WebElement labelNameCity;
    @FindBy (xpath = "//button[.='Vui lòng chọn']")
    WebElement labelDistrict;
    @FindBy(xpath = "//button[.='Quận Cầu Giấy']")
    WebElement labelNameDistrict;
    @FindBy(xpath = "//form//div[@class='form-group required'][3]//input")
    WebElement labelStreet;
    @FindBy(xpath = "//div[@class='form-group required']/div[@class='dropdown cl-select']//div[1]/div[.='Vui lòng chọn']")
    WebElement labelEducation ;
    @FindBy(xpath = "//button[.='Kỹ sư']")
    WebElement labelNameEducation;
    @FindBy(xpath = "//div[@class='form-row']//div[@class='col']/div[@class='dropdown cl-select']//div/div")
    WebElement labelUniversity;
    @FindBy(xpath = "//button[.='ĐH Giao Thông Vận Tải']")
    WebElement labelNameUniversity;
    @FindBy(xpath = "//div[@class='form-row form-group required']/div[@class='col']//div[1]/div[.='Vui lòng chọn']")
    WebElement labelMajor;
    @FindBy(xpath = "//input[@placeholder='Tìm kiếm']")
    WebElement inputName;
    @FindBy(xpath = "//button[.='Khoa học Máy tính / Công nghệ thông tin']")
    WebElement labelNameMajor;
    @FindBy(xpath = "//div[@class='row']/div[1]//div[@class='col']//select[@class='form-control cl-scrollbar fluent-form-control ']")
    WebElement inputStartDay;
    @FindBy(xpath = "//div[@class='row']/div[1]//div[@class='col-4']//select[@class='form-control cl-scrollbar fluent-form-control ']")
    WebElement inputStartYear;
    @FindBy(xpath = "//div[@class='d-flex flex-column align-items-center']//div[2]//div[@class='col']//select[@class='form-control cl-scrollbar fluent-form-control ']")
    WebElement inputFinalMonth;
    @FindBy(xpath = "//div[@class='d-flex flex-column align-items-center']//div[2]//div[@class='col-4']//select[@class='form-control cl-scrollbar fluent-form-control ']")
    WebElement inputFinalYear;

    @FindBy(xpath = "//button[@class='btn button-dropdown  ']/div[1]/div[.='Vui lòng chọn']")
    WebElement SelectType;
    @FindBy(xpath = "//button[.='Tiếng Anh']")
    WebElement labelNameLanguage;
    @FindBy(xpath = "//div[@class='fluent-select']//select")
    WebElement SelectLevelLanguage;
    @FindBy(xpath = "//button[.='Thêm học vấn']")
    WebElement SelectAddEducation;
    @FindBy(xpath = "//form//ul/div[1]//li[1]/div//div[2]//button[2]")
    WebElement selecDelete;
    @FindBy(xpath = "//button[contains(text(),'Xoá')]")
    WebElement SelectButtonDelete;
    @FindBy(xpath = "//div[@class='fluent-select flex-fill']//select")
    WebElement inputNumberEXP;
    @FindBy(xpath ="//div[@class='form-row']//div[1]//input[1]")
    WebElement inputNameCompany;
    @FindBy(xpath = "//div[@class='form-row']//div[2]//input[1]")
    WebElement inputNameJobTitle;
    @FindBy(xpath = "//div[@class='dropdown cl-select']")
    WebElement inputMajor;
    @FindBy(xpath = "//div[contains(text(),'Vui lòng chọn')]")
    WebElement inputNameMajor;
    @FindBy(xpath = "//button[contains(text(),'CNTT - Phần mềm')]")
    WebElement  selectNameMajor;
    @FindBy(xpath = "(//select[contains(@class,'form-control cl-scrollbar fluent-form-control')])[1]")
    WebElement inputStartDayOfEXP;
    @FindBy(xpath = "(//select[contains(@class,'form-control cl-scrollbar fluent-form-control')])[2]")
    WebElement inputStartYearEXP;
    @FindBy(xpath = "(//select[contains(@class,'form-control cl-scrollbar fluent-form-control')])[3]")
    WebElement inputFinalMonthEXP;
    @FindBy(xpath = "(//select[contains(@class,'form-control cl-scrollbar fluent-form-control')])[4]")
    WebElement inputFinalYearEXP;
    @FindBy(xpath = "//div[@class='form-group required']//textarea")
    WebElement inputDescribe;
    @FindBy(xpath = "//input[@placeholder='Ex: Microsoft Word']")
    WebElement inputSkills;
    @FindBy(xpath = "(//div[@class='proficiency-item'])[3]")
    WebElement SelectLevelSkill;
    @FindBy(xpath = "//div[@class='form-group required row']//div[@class='col-sm-8']/input")
    WebElement inputLocationJob;
    @FindBy(xpath = "//div[@class='mr-2 flex-fill']//input")
    WebElement inputSalary;
    @FindBy(xpath = "//div[@class='form-group row']//label[2]/div[@class='checkmark']")
    WebElement selectMoneyUSD;
    @FindBy(xpath = "//div[@class='mt-2']//label[2]/div[@class='checkmark']")
    WebElement selectMoneyUSDNew;
    @FindBy(xpath = "//select[@class='form-control fluent-form-control']")
    WebElement selectTitleSalary;
    @FindBy(xpath = "//div[@class='mr-2 w-100 salary-from']//input")
    WebElement inputSalaryToMew;
    @FindBy(xpath = "//div[@class='salary-to w-100']//input")
    WebElement inputSalaryFromMew;
    @FindBy(xpath = "//div[@class='d-flex flex-column align-items-center']//div[4]//select")
    WebElement selectTypeJob;
    @FindBy(xpath = "//div[@class='d-flex flex-column align-items-center']//div[5]//select")
    WebElement selectLevelDesired;
    @FindBy(xpath = "//div[@class='dropdown cl-select']/div[@class='btn p-0 text-primary font-weight-bold']")
    WebElement selectJob;
    @FindBy(xpath = "//div[contains(text(),'Tất cả quận/huyện')]")
    WebElement selectNameDistrict;
    @FindBy(xpath = "//div[@class='dropdown cl-select']//div[1]/div[.='Quận Ba Đình']")
    WebElement slectCancle;
    @FindBy(xpath = "//div[@class='form-group required row']//textarea")
    WebElement inputDescribeJob;
    @FindBy(xpath = "//div[@class='d-flex flex-column align-items-center']//div[9]//label[1]/div[@class='checkmark']")
    WebElement selectChangeLocation;
    @FindBy(xpath = "//div[10]//label[1]/div[@class='checkmark']")
    WebElement selectCanGoWork;
    @FindBy(xpath = "//div[@class='row']/div[1]//div[@class='col']//select[@class='form-control cl-scrollbar fluent-form-control ']")
    By CreateCVByStepsEl = By.cssSelector("a[href=\"/nguoi-tim-viec/ho-so/moi\"]");
    @FindBy(xpath = "//a[@title='Tester']")
    WebElement assertTitle;
    //@FindBy(xpath = "(//button[@type='button'])[3]")
    //WebElement deleteButtonCV;
    //@FindBy(xpath = "//button[normalize-space()='Xoá']")
    //WebElement deleteCV;
    // dùng để mở driver
    public CreateCVPage( WebDriver driver){
        this.driver=driver;

    }
    // dùng để mở trang web và click button create
    public void OpenCreateCVPage(){
//        this.driver.get("https://www.careerlink.vn/nguoi-tim-viec/ho-so");
//        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        PageFactory.initElements(this.driver,this);
//        btnCreateCV.click();
//        WebDriverWait waiter =new WebDriverWait(this.driver,Duration.ofSeconds(15));
//        WebElement btnCreateCVBySteps= waiter.until(ExpectedConditions.visibilityOfElementLocated(CreateCVByStepsEl));
//        btnCreateCVBySteps.click();
//        PageFactory.initElements(this.driver,this);
//        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    // dùng khai báo biến mà mình bắt location
    public void CreateCV(CVInformations cvInfo) throws ParseException {
        tbTieuDeHoSo.sendKeys(cvInfo.ThongTinCaNhan.TieuDeHoSo);
        Select slQuocTich=new Select(this.cboQuocTich);
        slQuocTich.selectByVisibleText(cvInfo.ThongTinCaNhan.QuocTich);
        Select slNgaySinh=new Select(this.cboNgay);
        slNgaySinh.selectByVisibleText(cvInfo.ThongTinCaNhan.NgaySinh);
        Select slThangSinh=new Select(this.cboThang);
        slThangSinh.selectByVisibleText(cvInfo.ThongTinCaNhan.ThangSinh);
        Select slNamSinh=new Select(this.cboNam);
        slNamSinh.selectByVisibleText(cvInfo.ThongTinCaNhan.NamSinh);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        btnSingle.click();
        btnSex.click();
        btnNext.click();
        inputNumberPhone.sendKeys((cvInfo.ThongTinLienHe.DienThoai));
        labelNation.click();
        labelVietNam.click();
        labelCity.click();
        labelNameCity.click();
        labelDistrict.click();
        labelNameDistrict.click();
        labelStreet.sendKeys(cvInfo.ThongTinLienHe.Duong);
        btnNext.click();
        labelEducation.click();
        labelNameEducation.click();
      //  inputName.sendKeys(cvInfo.ThongTinLienHe.Tentruong);
        Utility.sleep(5);
        labelNameUniversity.click();
        labelMajor.click();
        inputName.sendKeys(cvInfo.ThongTinLienHe.ChuyenMon);
        labelNameMajor.click();
        Select slInputStartDay=new Select(this.inputStartDay);
        slInputStartDay.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.ThangBD));
        Select slInputStartYear=new Select(this.inputStartYear);
        slInputStartYear.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.NamBD));
        Select slInputFinalMonth=new Select(this.inputFinalMonth);
        slInputFinalMonth.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.ThangKT));
        Select slInputFinalYear=new Select(this.inputFinalYear);
        slInputFinalYear.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.NamKT));
        btnNext.click();

        Utility.sleep(1);

        btnNext.click();
        SelectType.click();
        inputName.sendKeys(cvInfo.ThongTinLienHe.NgoaiNgu);
        labelNameLanguage.click();
        Select slSelectLevelLanguage=new Select(this.SelectLevelLanguage);
        slSelectLevelLanguage.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.TrinhDo));
        Utility.sleep(1);

        btnNext.click();
        Select slInputNumberEXP=new Select(this.inputNumberEXP);
        slInputNumberEXP.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.SoNam));
        inputNameCompany.sendKeys(cvInfo.ThongTinLienHe.TenCongTy);
        inputNameJobTitle.sendKeys(cvInfo.ThongTinLienHe.ChucDanh);
        inputMajor.click();
        inputName.sendKeys(cvInfo.ThongTinLienHe.NganhNghe);
        selectNameMajor.click();
        Select slInputStartDayOfEXP=new Select(this.inputStartDayOfEXP);
        slInputStartDayOfEXP.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.ThangBD));
        Select slInputStartYearEXP=new Select(this.inputStartYearEXP);
        slInputStartYearEXP.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.NamBD));
        Select slInputFinalMonthEXP=new Select(this.inputFinalMonthEXP);
        slInputFinalMonthEXP.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.ThangKT));
        Select slInputFinalYearEXP=new Select(this.inputFinalYearEXP);
        slInputFinalYearEXP.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.NamKT));
        Utility.sleep(1);
        inputDescribe.sendKeys(cvInfo.ThongTinLienHe.MoTa);
        btnNext.click();
        Utility.sleep(1);

        btnNext.click();
        Utility.sleep(1);

        btnNext.click();
        //Bước 7
        inputSkills.sendKeys(cvInfo.ThongTinLienHe.KyNang);
        SelectLevelSkill.click();
        btnNext.click();
        inputLocationJob.sendKeys(cvInfo.ThongTinLienHe.ViTriMongMuon);
        inputSalary.sendKeys(cvInfo.ThongTinLienHe.LuongGanNhat);
        selectMoneyUSD.click();
        selectMoneyUSDNew.click();
        Select slSelectTitleSalary = new Select(this.selectTitleSalary);
        slSelectTitleSalary.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.LoaiLuong));
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)", "");
        inputSalaryToMew.sendKeys(cvInfo.ThongTinLienHe.Tu);
        inputSalaryFromMew.sendKeys(cvInfo.ThongTinLienHe.Den);

        Select slSelectTypeJob = new Select(this.selectTypeJob);
        slSelectTypeJob.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.LoaiCongViec));
        Select slSelectLevelDesired = new Select(this.selectLevelDesired);
        slSelectLevelDesired.selectByVisibleText(String.valueOf(cvInfo.ThongTinLienHe.CapBacMongMuon));
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(750,1000)", "");
        selectJob.click();
        inputName.sendKeys(cvInfo.ThongTinLienHe.NganhNghe);
        selectNameMajor.click();
        SelectType.click();
//        labelNameLanguage.click();
        labelNameCity.click();
        selectNameDistrict.click();
        inputName.sendKeys(cvInfo.ThongTinLienHe.QuanHuyen);
        labelNameDistrict.click();
//        slectCancle.click();
        Utility.sleep(1);
        inputDescribeJob.click();
        inputDescribeJob.sendKeys(cvInfo.ThongTinLienHe.MucTieuNgheNghiep);

        selectChangeLocation.click();
        selectCanGoWork.click();
        btnNext.click();
//        inputDescribe.sendKeys(cvInfo.ThongTinLienHe.MoTa);
        Utility.sleep(1);
        btnNext.click();

    }

    public void AssertTitle(CVInformations cvInfo) throws ParseException {
        String ActualTitle = assertTitle.getText();
        String abc = cvInfo.ThongTinCaNhan.TieuDeHoSo + "Đang chờ";
        Assert.assertEquals(abc, ActualTitle);
        // deleteButtonCV.click();
        //deleteCV.click();
    }
}
