//package stepDefinitions;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pageobjects.HomePage;
//import pageobjects.RegisterPage;
//import java.util.UUID;
//import java.text.ParseException;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//public class RegisterSteps {
//    RegisterPage registerPage;
//
//    public RegisterSteps() {
//        this.registerPage = new RegisterPage(Hooks.driver);
//    }
//
//    @Given("^The registration page is showed$")
//    public void the_registration_page_is_showed() {
//        this.registerPage.open();
//    }
//
//    @Given("^The user already registered with all valid information$")
//    public void the_user_already_registered_with_all_valid_information() {
//        this.registerPage.open();
//        this.registerPage.enterFullName("Le Thi Phuong");
//        this.registerPage.enterEmail("phuonglt130120@gmail.com");
//        this.registerPage.enterPassword("Lethiphuong1901");
//        this.registerPage.enterConfirmPassword("Lethiphuong1901");
//        this.registerPage.submitRegister();
//    }
//
//    @When("^The user attempt to register with email is in used$")
//    public void the_user_attempt_to_register_with_email_is_in_used() {
//        this.registerPage.enterEmail("phuonglethi1901@gmail.com");
//    }
//
//    @When("^The user attempt to register with different password and confirm password$")
//    public void the_user_attempt_to_register_with_different_password_and_confirm_password() {
//        this.registerPage.enterPassword("abc123456");
//        this.registerPage.enterConfirmPassword("abc1234567");
//    }
//
//    @When("^The user enter password and confirm password then select Show Password option$")
//    public void the_user_enter_password_and_confirm_password_then_select_show_password_option() {
//        this.registerPage.enterPassword("abc123456");
//        this.registerPage.enterConfirmPassword("abc123456");
//        this.registerPage.selectShowPassword();
//    }
//
//
//    @When("^The User attempt to register with all valid information with Email \"([^\"]*)\"$")
//    public void the_user_attempt_to_register_with_all_valid_information_with_email(String email) {
//
//
//        String uuid = UUID.randomUUID().toString();
//        this.registerPage.enterFullName("Le Thi Phuong");
//        this.registerPage.enterEmail(email + uuid);
//        this.registerPage.enterPassword("Lethiphuong1901");
//        this.registerPage.enterConfirmPassword("Lethiphuong1901");
//        this.registerPage.submitRegister();
//    }
//
//    @When("^The user entered email does not exist$")
//    public void the_user_entered_email_does_not_exist(String email) {
//        this.registerPage.enterEmail("hhhhhhhhh");
//    }
//
////    @When("^The user open the activation link from email$")
////    public void the_user_open_the_activation_link_from_email() {
////        String activeLink = Utility.getActivationLink("txk2601@gmail.com", "@2Phuong");
////        Hooks.driver.navigate().to(activeLink);
////    }
//
//    @Then("^The Message \"([^\"]*)\" will be showed below email field$")
//    public void the_message_something_will_be_showed_below_email_field(String emailMsg) {
//        //Compare the actual message with expected message defined on feature file
//        assertThat(
//                this.registerPage.getEmailTakenMessage(), equalTo(emailMsg)
//        );
//    }
//
//    @Then("^The Message \"([^\"]*)\" will be showed below password field$")
//    public void the_message_something_will_be_showed_below_password_field(String pwdNotmatched) {
//        // Compare message
//        assertThat(
//                this.registerPage.getPasswordConfirmMessage(), equalTo(pwdNotmatched)
//        );
//    }
//
//
//    @Then("^The password value will be showed in clear text$")
//    public void the_password_value_will_be_showed_in_clear_text() {
//        assertThat(
//                this.registerPage.getTypeOfPasswordField(), equalTo("text")
//        );
//    }
//
//    @Then("^The dashboard will be showed with fullname is showed on profile menu header$")
//    public void the_dashboard_will_be_showed_with_fullname_is_showed_on_profile_menu_header() {
//        HomePage homePage = new HomePage(Hooks.driver);
//        assertThat(
//                homePage.ProfileName.getText().trim(), equalTo("Phuong")
//        );
//    }
//
//    @Then("^The message Check result singup$")
//    public void assert_Signup_Create() throws ParseException {
//        assertThat(
//                this.registerPage.checkSignupSuccess(), equalTo("Kiểm tra email của bạn")
//        );
//    }
//    @And("^The Email error message is hidden after input valid email not in used$")
//    public void the_email_error_message_is_hidden_after_input_valid_email_not_in_used() throws ParseException {
//        assertThat(
//                this.registerPage.checkEmailTakenMessageShow(), equalTo("Email này đã được đăng ký. Vui lòng nhập email khác")
//        );
//    }
//
//
//}
