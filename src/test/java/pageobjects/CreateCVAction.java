package pageobjects;

import Common.Constans;
import Common.Events;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateCVAction {
    public boolean clickButtonTaoHoSo(WebDriver driver){
        boolean result = false;
        try{
            boolean checkShow = driver.findElements(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/span")).size()>0;
            if (checkShow){
                if (Events.clickButton(driver, By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/span"))){
                    result = true;
                }
            }
            else {
                if (Events.clickButton(driver, By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div/span"))){
                    result = true;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return  result;
    }
    public boolean checkButtonTaoHoSo(WebDriver driver){
        boolean result = false;
        try{
            boolean check = driver.findElements(By.xpath("//button[@class='create-button create-resume btn btn-link font-weight-bold ml-auto p-0']")).size()>0;
            if (check){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
    public boolean switchScreen(WebDriver driver){
        boolean result = false;
        try {
            String oldWindow = driver.getWindowHandle();
            if (Events.switchWindowHasString(driver,"Tạo hồ sơ xin việc mới")){
                if (Events.clickButton(driver,By.xpath("//a[@href='/nguoi-tim-viec/ho-so/moi']"))){
                    driver.switchTo().window(oldWindow);
                    result= true;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
    public boolean inputScreenStep1(WebDriver driver,String tenHoSo, String ten, String quocTich, String ngay, String thang, String nam){
        boolean result = false;
        try{
            int count = 0;
            if (Events.inputTextField(driver,By.xpath("//*[@id=\"form_class\"]/label/input"),tenHoSo)){
                if (Events.inputTextField(driver,By.xpath("//*[@id=\"form_class\"]/div[1]/div[1]/label[1]/input"),ten)){
                    if (Events.selectComboboxByValue(driver,By.xpath("//*[@id=\"form_class\"]/div[1]/div[2]/label/div[2]/select"),quocTich)){
                        if (Events.selectComboboxByValue(driver,By.xpath("//*[@id=\"form_class\"]/div[1]/div[1]/label[2]/div[2]/div[1]/div/select"),ngay)){
                            if (Events.selectComboboxByValue(driver,By.xpath("//*[@id=\"form_class\"]/div[1]/div[1]/label[2]/div[2]/div[2]/div/select"),thang)){
                                if (Events.selectComboboxByValue(driver,By.xpath("//*[@id=\"form_class\"]/div[1]/div[1]/label[2]/div[2]/div[3]/div/select"),nam)){
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            if (count>=0){
                if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[1]/div[1]/label[3]/div[2]/label[1]/div"))){
                    if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[1]/div[1]/label[4]/div[2]/label[2]/div"))){
                            count++;
                    }
                }

            }
            if (count>=1){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
    public boolean clickButtonContinue(WebDriver driver){
        boolean result = false;
        try {
            if (Events.clickButton(driver,By.id("go-to-next"))){
                Thread.sleep(3000);
                result = true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
    public boolean inputScreenStep2(WebDriver driver, String sdt, String email, String diachiDuong){
        boolean result = false;
        try {
            int count = 0;
            if (Events.inputTextField(driver,By.xpath("//*[@id=\"form-edit-container\"]/div/form/div[1]/div/input"),sdt)){
                if (Events.inputTextField(driver,By.xpath("//*[@id=\"form_class\"]/div[2]/input"),email)){
                  count++;
                }
            }
            if (count>=1){
                if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[3]/div/button"))){
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                    if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[3]/div/div/div[3]"))){
                        Thread.sleep(2000);
                        count++;
                    }
                }
            }
            if (count>=2){
                if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[4]/div[1]/div/button"))){
                    if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[4]/div[1]/div/div/div[3]"))){
                        Thread.sleep(2000);
                        count++;
                    }
                }
            }
            if (count>=3){
                if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[4]/div[2]/div"))){
                    if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[4]/div[2]/div/div/div[3]"))){
                        Thread.sleep(2000);
                        count++;
                    }
                }
            }
            if (count>=3){
                if (Events.inputTextField(driver,By.xpath("//*[@id=\"form_class\"]/div[5]/input"),diachiDuong)){
                        count++;
                }
            }
            if (count>=4){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }

    public boolean inputScreenStep3(WebDriver driver,  String tenTruong, String ngayBatdau, String ngayKetThuc){
        boolean result = false;
        try {
            int count = 0;
            if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[1]/div/button/div/div"))){
                if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[1]/div/div/div[4]"))){
                    Thread.sleep(2000);
                    count++;
                }
            }
            if (count>=1){
                if (Events.inputTextField(driver,By.xpath("//*[@id=\"form_class\"]/div[2]/div/div/input"),tenTruong)){
                    Thread.sleep(2000);
                    count++;
                }
            }
            if (count>=2){
                if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[3]/div/div/button"))){
                    if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[3]/div/div/div/div[3]"))){
                        Thread.sleep(2000);
                        count++;
                    }
                }
            }
            if (count>=3){
                if (Events.selectComboboxByValue(driver,By.xpath("//*[@id=\"form_class\"]/div[4]/div[1]/div/div[1]/div/select"),ngayBatdau)){
                    if (Events.selectComboboxByValue(driver,By.xpath("//*[@id=\"form_class\"]/div[4]/div[2]/div/div[1]/div/select"),ngayKetThuc)){
                        count++;
                    }
                }
            }
            if (count>=4){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
    // click tieeps tucj 2 laanf
    public boolean inputScreenStep3(WebDriver driver, String trinhDo){
        boolean result = false;
        try{
            int count = 0;
            if (Events.clickButton(driver, By.xpath("//*[@id=\"form-edit-container\"]/div/form/div[1]/div/div[1]/div/div/div/button"))){
                if (Events.clickButton(driver, By.xpath("//*[@id=\"form-edit-container\"]/div/form/div[1]/div/div[1]/div/div/div/div/button[1]"))){
                    count++;
                }
            }
            if (count >=1){
                if (Events.selectComboboxByValue(driver, By.xpath("//*[@id=\"form-edit-container\"]/div/form/div[1]/div/div[2]/div/div/select"),trinhDo)){
                    result = true;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
    public boolean inputScreenStep4(WebDriver driver, String trinhDo){
        boolean result = false;
        try{
            int count = 0;
            if (Events.clickButton(driver, By.xpath("//*[@id=\"form_class\"]/div[1]/div/div[1]/div/div/div/button/div/div"))){
                if (Events.clickButton(driver, By.xpath("//*[@id=\"form_class\"]/div[1]/div/div[1]/div/div/div/div/div[1]"))){
                    count++;
                }
            }
            if (count >=1){
                if (Events.selectComboboxByValue(driver, By.xpath("//*[@id=\"form_class\"]/div[1]/div/div[2]/div/div/select"),trinhDo)){
                    result = true;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }

    public boolean inputScreenStep5(WebDriver driver, String tongSoNamKinhNghiem, String tenCongTy, String chucNang, String ngayBatDau, String ngayKetThuc, String mota){
        boolean result = false;
        try{
            int count = 0;
            if (Events.selectComboboxByValue(driver,By.xpath("//*[@id=\"form-edit-container\"]/div/form/div[1]/div/div[1]/select"),tongSoNamKinhNghiem)){
                if (Events.inputTextField(driver,By.xpath("//*[@id=\"form-edit-container\"]/div/form/div[2]/div[1]/input"),tenCongTy)){
                    if (Events.inputTextField(driver,By.xpath("//*[@id=\"form-edit-container\"]/div/form/div[2]/div[2]/input"),chucNang)){
                        count++;
                    }
                }
            }
            if (count>=1){
                if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[3]/div/button"))){
                    if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[3]/div/div/div[1]"))){
                        count++;
                    }
                }
            }
            if (count>=2) {
                if (Events.selectComboboxByValue(driver, By.xpath("//*[@id=\"form_class\"]/div[4]/div/div[1]/div/select"), ngayBatDau)) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                    if (Events.clickButton(driver, By.xpath("//*[@id=\"form_class\"]/div[4]/div/div[2]/div/select"))) {
                        if (Events.clickButton(driver, By.xpath("//*[@id=\"form_class\"]/div[4]/div/div[2]/div/select/option[3]"))) {
                            if (Events.selectComboboxByValue(driver, By.xpath("//*[@id=\"form_class\"]/div[5]/div/div[1]/div/div[1]/div/select"), ngayKetThuc)) {
                                if (Events.clickButton(driver, By.xpath("//*[@id=\"form_class\"]/div[5]/div/div[1]/div/div[2]/div/select"))) {
                                    if (Events.clickButton(driver, By.xpath("//*[@id=\"form_class\"]/div[5]/div/div[1]/div/div[2]/div/select/option[3]"))) {
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (count>=3){
                if(Events.inputTextField(driver,By.xpath("//*[@id=\"form_class\"]/div[6]/textarea"),mota)){
                    result = true;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
    // click tiếp tục 2 lần
    // bước 6 bỏ qua
    public boolean inputScreenStep7(WebDriver driver, String kyNang){
        boolean result = false;
        try{
            if (Events.inputTextField(driver, By.xpath("//*[@id=\"form_class\"]/div[1]/div[2]/input"),kyNang)){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }

    public boolean inputScreenStep8(WebDriver driver, String viTriMongMuon, String mucLuongMongMuon, String loaiCongViec, String capBacMongMuon, String mucTieuNgheNghiep){
        boolean result = false;
        try{
            int count = 0;
            if (Events.inputTextField(driver, By.xpath("//*[@id=\"form_class\"]/div[1]/div/input"),viTriMongMuon)){
                if (Events.selectComboboxByValue(driver,By.xpath("//*[@id=\"form_class\"]/div[3]/div/div/div/div[1]/select"),mucLuongMongMuon)){
                    count++;
                }
            }
            if (count>=1){
                if (Events.selectComboboxByValue(driver, By.xpath("//*[@id=\"form_class\"]/div[4]/div/div/select"),loaiCongViec)){
                    if (Events.selectComboboxByValue(driver,By.xpath("//*[@id=\"form_class\"]/div[5]/div/div/select"),capBacMongMuon)){
                        count++;
                    }
                }
            }
            if (count>=2){
                if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[6]/div/div[2]/div[1]"))){
                    if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[6]/div/div[2]/div[2]/div[1]"))){
                        count++;
                    }
                }
            }
            if (count>=3){
                if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[7]/div/div/div/div[1]/div/button"))){
                    if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[7]/div/div/div/div[1]/div/div/div[1]"))){
                        count++;
                    }
                }
            }

            if (count>=4){
                if (Events.inputTextField(driver,By.xpath("//*[@id=\"form_class\"]/div[8]/div/textarea"),mucTieuNgheNghiep)){
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    //Locating element by link text and store in variable "Element"
                    WebElement Element = driver.findElement(By.xpath("//*[@id=\"form_class\"]/div[10]/div/div/label[2]/div"));
                    // Scrolling down the page till the element is found
                    js.executeScript("arguments[0].scrollIntoView();", Element);
                    if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[9]/div/div/label[2]/div"))){
                        if (Events.clickButton(driver,By.xpath("//*[@id=\"form_class\"]/div[10]/div/div/label[2]/div"))){
                            count++;
                        }
                    }
                }
            }
            if (count>=5){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Constans.errorLog.concat(e.getMessage());
        }
        return result;
    }
    // bước 9 ko cần thực hiện ấn tiếp tục luôn

}
