package stepDefinitions;

import Common.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void BeforeScenario()
    {
        System.out.println("run before success");
       // WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("-disable notifications");
//        DesiredCapabilities cp = new DesiredCapabilities();
//        cp.setCapability(ChromeOptions.CAPABILITY,options);
//        options.merge(cp);

    }

    @After
    public void AfterScenario(Scenario scenario)
    {
        System.out.println("run after success");
//        if(scenario.isFailed())
//        {
//            byte[] img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(img, "Image/png", "error");
//        }
//        Common.Utility.waitABit(2);
//        driver.quit();
    }
}
