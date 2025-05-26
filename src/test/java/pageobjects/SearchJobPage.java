package pageobjects;

import Model.SearchJobKeyWords;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchJobPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'Kết quả tìm kiếm')]")
    WebElement Result;
    @FindBy(css = "div.search-suggestion .input-with-icon input")
    WebElement TextBoxJob;
    @FindBy(css = "div.mx-1 .multiple-input  input")
    WebElement TextArea;
    @FindBy(xpath="//*[@id=\"top_nav_search\"]/form/button")
    WebElement ButtonSearch;
    String xpathSuggestionLocation = "//div[@class=\"dropdown-item\"][contains(text(), \"{0}\")]";
    By suggestionBox = By.cssSelector("div.cl-autocomplete--menu");

    public SearchJobPage( WebDriver driver){
        this.driver=driver;
    }


}
