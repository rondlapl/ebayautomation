package PageObjects;

import env.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchPage {

    @FindBy (id = "")
    public WebElement searchBar;

    public static WebDriver driver = DriverUtil.getDefaultDriver();


    public static void navigateToUrl(String weburl) {
        driver.get(weburl);
        driver.quit();
    }


}
