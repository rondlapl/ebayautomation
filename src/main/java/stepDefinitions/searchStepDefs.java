package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import env.DriverUtil;
import org.junit.After;
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
    @Given("I click on MyeBay")
    public void clickOnMyeBay(){
        searchPage.clickOnMyeBay();
    }
    @When("I select the search item and add to cart")
    public void selectAndAddSearchItem(){
        searchPage.selectAndAddSearchItem();
    }
    @When("I enter credentials \"([^\"]*)\"$")
    public void enterCredentials(String userName){
        searchPage.enterCredentials(userName);

    }
    @Then("validate the selected item")
    public void validateSelectedItem(){
        searchPage.validateSelectedItem();
    }
    @Then("validate the sign in error details")
    public void validateSignInErrorDetails(){
        searchPage.validateSignInErrorDetails();
    }
    @AfterClass
    public static void cleanUp(){
        searchPage.quitDriver();
    }

}
