package Common;

import FilesUtils.ExcelFile;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Setup {

    public static WebDriver driver;

    private String testname;
    private String screnario;

    public static int pass = 0;
    public static int colPass = 0;

    public static int colFail = 0;
    public static int row = 0;
    public static ExtentReports extent = null;
    public static ExtentTest testLogs;
    public static ITestContext ctxLocal;
    public static ITestResult resultLocal;
    public static String videoName;
    public static String pathfileIMGSave;
    public static String pathVideoMp4;

    public Setup(String screnario, String testname){
        this.testname = testname;
        this.screnario = screnario;
        beforeAll();
    }
    public static DesiredCapabilities ChromeCap(String browser) {
		//System.setProperty("webdriver.chrome.driver", "/Users/mac/Desktop/123.0.6312.86/chromedriver");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
//		chromePrefs.put("download.default_directory", txtFolderSave);
        // disable save password pop-up
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("safebrowsing.enabled", "true");
        // setup path to folder 'data/downloads' when downloads file
        chromePrefs.put("download.default_directory",
                System.getProperty("user.dir") + File.separator + "data" + File.separator + "downloads");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-print-preview");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-gpu", "start-maximized", "--log-level=3");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);

        return cap;
    }

    public void setupDriver(String bareURL, String chrome) {
        try {
            if (chrome.contains("chrome")) {
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "/Users/mac/Desktop/chromedriver");
                //WebDriver driver = new ChromeDriver();
                driver = new ChromeDriver();

            } else if (chrome.contains("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if (chrome.contains("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.firefox.driver", "/Users/mac/Desktop/geckodriver");
                driver = new FirefoxDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(ChromeCap("firefox"));
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Constans.TIME_WAITING, TimeUnit.SECONDS);
            driver.get(bareURL);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    public List<Map<String,Object>> getDataFromExcelFile(String pathToFile, List<String> mapColoum){
        List<Map<String,Object>> data = new ArrayList<>();
        try {
            ExcelFile.getSetUp(pathToFile);
            ExcelFile.setExcelInfo(Constans.dataFolder + Constans.fileExcelName, Constans.sheetName);
            ArrayList<Integer> allRows = ExcelFile.getRowByTCNameIndex(Constans.testCaseName, 1);
            Object[][] dataMatrix = ExcelFile.getData(Constans.testCaseName, mapColoum.size(), 1);
            for (int i = 0 ; i< allRows.size(); i++){
                Map<String,Object> dataItem = new HashMap<>();
                for (int j = 0;j< mapColoum.size();j++){
                    dataItem.put(mapColoum.get(j),dataMatrix[i][j]);
                }
                data.add(dataItem);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    public void after(boolean isContinue){
        ExcelFile.setPass(colPass,row ,colFail);
        if (isContinue){
            Events.captureScreenSelenium(driver);
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            driver.quit();
        }else {
            afterAll();
        }
    }
    public void afterFail(boolean isContinue){
        ExcelFile.setFail(Setup.colPass,Setup.row ,Setup.colFail);
        if (isContinue){
            Events.captureScreenSelenium(driver);
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            driver.quit();
        }else {
            afterAll();
            fail();
        }

    }

    // phần này xử lý cho testng setup
    public void beforeAll() {
        try{
            // cấu hình screnario
            if (extent == null){
                extent = ScreenshotAndVideo.Instance(extent, this.screnario);
                extent.loadConfig(new File("reports/report-config.xml"));
                // cấu hình report
                Constans.errorLog = null;
                testLogs = extent.startTest(this.screnario, "Đang test testcase: " + this.testname);
                testLogs.assignCategory(this.screnario);
                System.err.println("Video screen");
                videoName = RandomName.VideoAvi(this.testname.replace(" ","").replace(">","").replace("<",""));
                pathVideoMp4 = RandomName.pathVideoMp4(this.testname.replace(" ","").replace(">","").replace("<",""));
                ScreenshotAndVideo.startRecord(videoName);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void afterAll(){
        try{
                System.err.println("After all");
                pathfileIMGSave = RandomName.pathImg(this.testname);
                String imgPath = "";
                try {
                    imgPath = ScreenshotAndVideo.screenShotBySelenium(driver, pathfileIMGSave);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("CaptureScreen by selenium error");
                    try {
                        imgPath = ScreenshotAndVideo.screenShotByJava(pathfileIMGSave);
                    } catch (Exception e2) {
                        // TODO: handle exception
                        System.out.println("CaptureScreen by java error");
                    }
                }
                System.out.println(imgPath);
                File imgFile = new File(Constans.folderReprotLocation + imgPath);
                if (imgFile.exists() && !imgFile.isDirectory()) {
                    testLogs.log(LogStatus.INFO, testLogs.addScreenCapture(imgPath), "");
                }
                // Stop video
                System.err.println("Stop video");
                String pathVideoAvi = RandomName.pathVideoAvi(videoName);
                ScreenshotAndVideo.stopRecord();
                // convert video to mp4
//                convert.AviToMp4(pathVideoAvi, pathVideoMp4);
//                // xóa video đuôi AVI
//                if (fileUtils.deleteIfExists(Constans.folderReprotLocation + pathVideoAvi)) {
//                    System.out.println("Delete file success");
//                }
                extent.endTest(testLogs);
                extent.flush();
                // kiểm tra xem có lỗi không để ghi log
                if (!StringUtils.isBlank(Constans.errorLog)) {
                    testLogs.log(LogStatus.FAIL, Constans.errorLog.toString(),"");
                }
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                driver.quit();
                colPass = 0;
                colFail = 0;
                row = 0;
                extent.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
