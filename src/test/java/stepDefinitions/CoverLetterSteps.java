package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CoverLetterPage;


public class CoverLetterSteps {
    CoverLetterPage coverLetter;
    //CoverLetterKeyWord coverLetterKeyWord;
    public  CoverLetterSteps()
    {
        this.coverLetter = new CoverLetterPage(Hooks.driver);
       // coverLetter = new CoverLetterPage(Hooks.driver);
       // Path resourceDirectory = Paths.get("src","test","resources", "coverleter.json");
        //String dataPath = resourceDirectory.toFile().getAbsolutePath();
        //Gson gson =new Gson();
       // Reader reader= Files.newBufferedReader(Paths.get(dataPath));
        //this.coverLetterKeyWord =gson.fromJson(reader, CoverLetterKeyWord.class);

    }
    @Given("^The Cover Letter is showed$")
    public  void the_cover_letter_is_showed(){this.coverLetter.OpenCoverLetterPage();}
    @When("^The User attempt to cover letter$")
    public  void the_user_attempt_to_cover_letter() {
this.coverLetter.enterTieude("Khong co");
this.coverLetter.enterNoidung("khong co noi dung gi can cap nhat");
this.coverLetter.clickbuttonTao();
        //coverLetter.CoverLetter(coverLetterKeyWord);
    }
    @Then("^Create cover letter is showed$")
    public  void create_cove_letter_is_show(){

    }


}
