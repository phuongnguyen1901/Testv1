//package stepDefinitions;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.bytebuddy.asm.Advice;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import pageobjects.ForgotpasswordPage;
//import pageobjects.HomePage;
//import pageobjects.LoginPage;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//public class Loginsteps {
//    LoginPage loginPage;
//    public Loginsteps()
//    {
//        this.loginPage = new LoginPage(Hooks.driver);
//    }
//
//    // Mở trang lên
////    @Given("^The login page is showed$")
////    public void the_login_page_is_showed() {
////        this.loginPage.Open();
////    }
//
//    //Nhập thông tin người dùng
//    @When("^The user enter their credential$")
//    public void the_user_enter_their_credential() {
//        this.loginPage.enterEmail("phuonglethi1901@gmail.com");
//        this.loginPage.enterPassword("Lethiphuong1901");
//    }
//    // người dùng cố gắng nhập tên, mật khẩu
//    @When("^The user attempt to login with username \"(.+)\" and password \"(.+)\"$")
//    public void the_user_attempt_to_login_with_username_and_password(String username, String password){
//        this.loginPage.enterEmail(username);
//        this.loginPage.enterPassword(password);
//        this.loginPage.submitLogin();
//    }
//    // kiểm tra khi người dùng chuyển đến màn hình quên mật khẩu
//    @When("The click button forgot password$")
//    public  void the_click_button_forgot_password(){
//        this.loginPage.clickforgotpassword();
//    }
//    // định dạng email, password
//    @Then("^The type of email should be email and type of password field should be password$")
//    public void the_type_of_email_should_be_email_and_type_of_password_field_should_be_password() {
//        assertThat(
//                this.loginPage.typeOfEmailField(), is("email")
//        );
//
//        assertThat(
//                this.loginPage.typeOfPasswordField(), is("password")
//        );
//    }
//    //Mật khẩu hiển thị văn bản rõ ràng
//    @Then("^The password should show in clear text$")
//    public void the_password_should_show_in_clear_text() {
//        assertThat(
//                this.loginPage.typeOfPasswordField(), is("text")
//        );
//    }
//
////    @Then("^The error message \"([^\"]*)\" should be showed$")
////    public void the_error_message_something_should_be_showed(String error) {
////        assertThat(
////                this.loginPage.errorMessage(), equalTo(error)
////        );
////    }
//
//    @Then("^The dashboard with user name \"([^\"]*)\" is showed on profile menu$")
//    public void the_dashboard_with_user_name_is_showed_on_profile_menu(String fullName) {
//        HomePage homePage = new HomePage(Hooks.driver);
//        assertThat(
//                homePage.ProfileName.getText().trim(), equalTo(fullName)
//        );
//    }
//    @Then("^Show forgot password page$")
//    public  void show_forgot_password_page(){
//    ForgotpasswordPage forgotpasswordPage = new ForgotpasswordPage(Hooks.driver);
//    }
//
//    @And("^The user select show password option$")
//    public void the_user_select_show_password_option() {
//        this.loginPage.selectShowPassword();
//    }
//}
