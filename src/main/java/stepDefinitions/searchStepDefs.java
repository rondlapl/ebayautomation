package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import env.DriverUtil;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import pages.searchPage;


public class searchStepDefs {

    @Given("I am on ebay page \"([^\"]*)\"$")
    public void iAmOnEbayPage(String weburl) {
        searchPage.navigateToUrl(weburl);
    }
    @Given("I search for \"([^\"]*)\"$")
    public void searchItem(String searchItem) {
        searchPage.searchItem(searchItem);
    }
    @When("I select the search item and add to cart")
    public void selectAndAddSearchItem(){
        searchPage.selectAndAddSearchItem();

    }
    @Then("validate the selected item")
    public void validateSelectedItem(){
        searchPage.validateSelectedItem();
    }


}
