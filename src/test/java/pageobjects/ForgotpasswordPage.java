package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotpasswordPage {

    @FindBy(css = "input[type=\"email\"]")
    WebElement Email;
    @FindBy(css = "button[type=submit]")
    WebElement ConfirmButton;

    By errorLocator = By.cssSelector("div.alert");
    By successLocator = By.cssSelector("(//h1/following-sibling::p)[1]");

    private WebDriver driver;
    public ForgotpasswordPage(WebDriver driver)
    {
        this.driver = driver;
        this.driver.manage().window().maximize();
    }

    public void Open()
    {
        this.driver.get("https://www.careerlink.vn/en/jobseeker/reset/reset_request");
       //this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        PageFactory.initElements(this.driver, this);
    }

    public void enterEmail(String email)
    {
        this.Email.sendKeys(email);
    }

    public void submitEmail()
    {
        this.ConfirmButton.click();
    }


    public String typeOfEmailField()
    {
        return this.Email.getAttribute("type");
    }

//    public String getErrorMessage()
//    {
//        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
//        WebElement lbError = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
//        return lbError.getText().replace("\n×", "");
//    }
//
//    public String getSuccessMessage()
//    {
//        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
//        WebElement lbSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(successLocator));
//        return lbSuccess.getText();
//    }
}
