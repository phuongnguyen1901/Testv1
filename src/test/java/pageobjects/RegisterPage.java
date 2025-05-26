package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;

public class RegisterPage {
    @FindBy(css="input#full_name")
    public WebElement FullName;
    @FindBy(css = "input#email")
    public WebElement Email;
    @FindBy(css="input#password")
    public WebElement Password;
    @FindBy(css = "input#password_confirmation")
    public WebElement ConfirmPassword;
    @FindBy(css = "button#register_submit")
    public WebElement RegisterButton;
    @FindBy(css = "input#toggle_password")
    public WebElement ShowPassword;
    @FindBy(xpath = "//span[contains(.,'Email này đã được đăng ký. Vui lòng nhập email khác')]")
    WebElement assertMessage ;
    @FindBy(xpath = "//h1[contains(.,'Kiểm tra email của bạn')]")
    WebElement assertCheckEmail ;
    By emailTakenMessage = By.cssSelector("span[data-message=\"taken\"]");

    By invalidConfirmPassword = By.cssSelector("div#invalid_password_feedback");
    By errorLocator = By.cssSelector("div.alert");


    WebDriver driver;
    public RegisterPage(WebDriver driver)
    {
        this.driver =driver;
    }
//    public void open()
//    {
//        this.driver.get("https://www.careerlink.vn/nguoi-tim-viec/dang-ky");
//        this.driver.manage().timeouts().implicitlyWait();
//        PageFactory.initElements(driver, this);
//    }

    public void enterEmail(String email)
    {
        this.Email.sendKeys(email);
    }

    public void enterFullName(String fullname)
    {
        this.FullName.sendKeys(fullname);
    }

    public void enterPassword(String password)
    {
        this.Password.sendKeys(password);
    }

    public void enterConfirmPassword(String password)
    {
        this.ConfirmPassword.sendKeys(password);
    }

    public void selectShowPassword()
    {
        if(!this.ShowPassword.isSelected())
            this.ShowPassword.click();
    }

    public void submitRegister()
    {
        this.RegisterButton.click();
    }

//    public String getEmailTakenMessage()
//    {
//        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
//        WebElement lbMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTakenMessage));
//        return lbMsg.getText();
//    }

//    public String emailinvalidMessage()
//    {
//        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
//        WebElement lbMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTakenMessage));
//        return lbMsg.getText();
//    }
//    public String getPasswordConfirmMessage()
//    {
//        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
//        WebElement lbMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidConfirmPassword));
//        return lbMsg.getText();
//    }

    public String checkEmailTakenMessageShow() throws ParseException
    {
        String ActualTitle = assertMessage.getText();
        return ActualTitle;
    }
    public String checkSignupSuccess() throws ParseException {
        String Email = assertCheckEmail.getText();
        return Email;

    }
    public String getTypeOfPasswordField()
    {
        return this.Password.getAttribute("type");
    }

    public String getTypeOfConfirmPasswordField()
    {
        return this.ConfirmPassword.getAttribute("type");
    }
//    public String errorMessage()
//    {
//        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
//        WebElement lbError = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
//        return lbError.getText();
//    }
}
