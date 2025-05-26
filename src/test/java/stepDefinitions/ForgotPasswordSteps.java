package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ForgotpasswordPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ForgotPasswordSteps {
    ForgotpasswordPage forgotPwdPage;
    public ForgotPasswordSteps()
    {
        this.forgotPwdPage = new ForgotpasswordPage(Hooks.driver);
    }

    @Given("^The forgot password page is showed$")
    public void the_forgot_password_page_is_showed() {
        this.forgotPwdPage.Open();
    }

    @When("^The user attempt to reset password with Email \"([^\"]*)\"$")
    public void the_user_attempt_to_reset_password_with_email_something(String email) {
        this.forgotPwdPage.enterEmail(email);
        this.forgotPwdPage.submitEmail();
    }

    @Then("^The type of email should be email and require for input$")
    public void the_type_of_email_should_be_email_and_require_for_input() {
        assertThat(
                this.forgotPwdPage.typeOfEmailField(), is("email")
        );
    }

//    @Then("^The email not exist message \"([^\"]*)\" should be showed$")
//    public void the_error_message_should_be_showed(String errorMsg) {
//        assertThat(this.forgotPwdPage.getErrorMessage(), is(errorMsg));
//    }

    @Then("^The success message \"([^\"]*)\" will be showed$")
    public void the_success_message_something_will_be_showed(String successMsg) {
    }

}
