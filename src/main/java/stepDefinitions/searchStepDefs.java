package stepDefinitions;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import env.DriverUtil;
import PageObjects.searchPage;


public class searchStepDefs {




    @Given("I am on ebay page \"([^\"]*)\"$")
    public void I_am_on_ebay_page(String weburl) {
        searchPage.navigateToUrl(weburl);


    }
}
