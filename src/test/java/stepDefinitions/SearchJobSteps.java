//package stepDefinitions;
//
//import Model.CVInformations;
//import Model.SearchJobKeyWords;
//import com.google.gson.Gson;
//import io.cucumber.java.en.*;
//import pageobjects.SearchJobPage;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//public class SearchJobSteps {
//    SearchJobPage searchJobPage;
//    SearchJobKeyWords searchJobKeyWords;
//    public SearchJobSteps() throws IOException {
//        searchJobPage =new SearchJobPage (Hooks.driver);
//        //read data from UserInformation.json to CVInformation object
//        Path resourceDirectory = Paths.get("src", "test", "resources", "data", "jobkeyword.json");
//        String dataPath = resourceDirectory.toFile().getAbsolutePath();
//
//        Gson gson =new Gson();
//        Reader reader= Files.newBufferedReader(Paths.get(dataPath));
//        this.searchJobKeyWords=gson.fromJson(reader, SearchJobKeyWords.class);
//    }
//
//    @Given("^The Homepage is showed$")
//    public void the_homepage_is_showed() {
//    }
//
//    @When("^The user attempts to search job from Json file$")
//    public void the_user_attempts_to_search_job_from_json_file(){
//        searchJobPage.SearchJob(searchJobKeyWords);
//        //this.searchJobPage.enterJob(job);
//        //this.searchJobPage.enterArea(area);
//        //this.searchJobPage.submitSearch();
//    }
//
//    @Then("^The Job search results is showed on the screen$")
//    public void the_job_search_results_is_showed_on_the_screen() {
//
//    }
//}
