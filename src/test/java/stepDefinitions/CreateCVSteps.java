package stepDefinitions;

import Model.CVInformations;
import com.google.gson.Gson;
import io.cucumber.java.en.*;
import pageobjects.CreateCVPage;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.text.ParseException;

public class CreateCVSteps {
    CreateCVPage createCVPage;
    CVInformations cvInfo;
    public CreateCVSteps() throws IOException {
        createCVPage=new CreateCVPage(Hooks.driver);
        //read data from UserInformation.json to CVInformation object
        Path resourceDirectory = Paths.get("src", "test", "resources", "data", "UserInformation.json");
        String dataPath = resourceDirectory.toFile().getAbsolutePath();
        //ClassLoader classLoader=getClass().getClassLoader();
        //String dataPath=classLoader.getResource("data/UserInformation.json").getPath();

        Gson gson =new Gson();
        Reader reader= Files.newBufferedReader(Paths.get(dataPath));
        this.cvInfo=gson.fromJson(reader, CVInformations.class);
    }

    @Given("^The Create CV is showed$")
    public void the_create_cv_is_showed(){
        createCVPage.OpenCreateCVPage();
    }

    @When("^The User attempt to create CV with their information stored from Json file$")
    public void the_user_attempt_to_create_cv_with_their_information_stored_from_json_file() throws ParseException {
        createCVPage.CreateCV(cvInfo);
    }

    @Then("^The Create CV will be showed in the CV List$")
    public void the_create_cv_will_be_showed_in_the_cv_list() throws ParseException {
        createCVPage.AssertTitle(cvInfo);
    }

}
