package pageobjects;

import Common.Constans;
import Common.Events;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchJobAction {
    public boolean clickButtonSearchJob(WebDriver driver) {
        boolean result = false;
        try {
            if (Events.clickButton(driver, By.xpath("//*[@id=\"top-navigation\"]/div[2]/ul/div[1]/li[1]/a"))) {
                result = true;
            }
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;

    }

    public boolean inputCityAndCompany(WebDriver driver, String city, String company) {
        boolean result = false;
        try {
            if (Events.inputTextField(driver, By.xpath("//input[@placeholder='Nhập tên vị trí, công ty, từ khoá']"), company)) {
                if (Events.inputTextField(driver, By.xpath("//input[@placeholder='Nhập tỉnh, thành phố']"), city)) {
                    if (!StringUtils.isBlank(city)) {
                        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Nhập tỉnh, thành phố']"));
                        Actions action = new Actions(driver);
                        action.sendKeys(element,Keys.ARROW_DOWN).build().perform();
                        Thread.sleep(1000);
                        action.sendKeys(Keys.ENTER).build().perform();
                        Thread.sleep(3000);
                    }
                    result = true;
                }
            }
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean clickButtonSearch(WebDriver driver) {
        boolean result = false;
        try {
            if (Events.clickButton(driver, By.xpath("//*[@id=\"top_nav_search\"]/form/button"))) {
                result = true;
            }
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean checkResultWhenSearch(WebDriver driver) {
        boolean result = false;
        try {
            boolean checkListItemSearch = driver.findElements(By.xpath("/html/body/div[2]/div/div/div/div[1]/h1")).size() > 0;
            if (checkListItemSearch) {
                result = true;
            }
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean checkItemInPage(WebDriver driver) {
        boolean result = false;
        try {
            boolean checkInput1 = driver.findElements( By.xpath("//*[@id=\"ea5c43a0-8c7d-4dfe-a4d7-c4ec99dfa60c\"]")).size() > 0;
            boolean checkInput2 = driver.findElements(By.xpath("//*[@id=\"c2e6d54c-801b-45bd-bb17-3f0a5c9d0bdd\"]")).size() > 0;

            if (checkInput1 && checkInput2) {
                result = true;
            }
        } catch (Exception e) {
            Constans.errorLog.concat(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }
}
