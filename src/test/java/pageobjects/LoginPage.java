package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    // dùng khai báo biến mà mình bắt location
    @FindBy(css = "input[type=\"email\"]")
    WebElement Email;
    @FindBy(css = "input.password")
    WebElement Password;
    @FindBy(css="input#toggle_password")
    WebElement ShowPassword;
    @FindBy(css = "//*[@id=\"login_submit\"]")
    WebElement LoginButton;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div[3]/a")
            WebElement forgotpassword;

    By errorLocator = By.cssSelector("div.alert");

    private WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        // dùng để mở trình duyệt
        this.driver = driver;
        this.driver.manage().window().maximize();
    }

//    public void Open()
//    {
//        // mở trang lên
//        this.driver.get("https://www.careerlink.vn/nguoi-tim-viec/login");
//        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        PageFactory.initElements(this.driver, this);
//    }

    public void enterEmail(String email)
    {
        this.Email.sendKeys(email);
    }

    public void enterPassword(String pwd)
    {
        this.Password.sendKeys(pwd);
    }

    public void submitLogin()
    {
        this.LoginButton.click();
    }

    public void selectShowPassword()
    {
        //if(ShowPassword.isSelected())
        ShowPassword.click();
    }
 public  void clickforgotpassword()
 {this.forgotpassword.click();}
    public String typeOfEmailField()
    {
        return this.Email.getAttribute("type");
    }

    public String typeOfPasswordField()
    {
        return this.Password.getAttribute("type");
    }

//    public String errorMessage()
//    {
//        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
//        WebElement lbError = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
//        return lbError.getText();
//    }
}
