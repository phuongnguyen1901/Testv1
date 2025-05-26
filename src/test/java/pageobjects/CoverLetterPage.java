package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class CoverLetterPage {

    @FindBy(xpath = "//*[@id=\"cover_letter_title\"]")
    WebElement Tieude;
    @FindBy(xpath = "//*[@id=\"cover_letter_message\"]")
    WebElement Noidung;
    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div/form/div[3]/button")
    WebElement btnTaothuxinviec;
    private  WebDriver driver;
    public  CoverLetterPage(WebDriver driver){
        this.driver = driver;
        this.driver.manage().window().maximize();
    }
    public  void OpenCoverLetterPage()
    {
        this.driver.get("https://www.careerlink.vn/nguoi-tim-viec/thu-xin-viec/moi");
        //this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        PageFactory.initElements(this.driver,this);

    }
   public  void enterTieude(String TD) {this.Tieude.sendKeys(TD);}
    public  void enterNoidung(String ND) {this.Noidung.sendKeys(ND);}
    public  void clickbuttonTao(){this.btnTaothuxinviec.click();}
    // public  void CoverLetter(CoverLetterKeyWord coverLetterKeyWord) throws ParseException{
      //  Tieude.sendKeys(coverLetterKeyWord.Tieude);
       // Noidung.sendKeys(coverLetterKeyWord.Noidung);
       // btnTaothuxinviec.click();
    //}



}
