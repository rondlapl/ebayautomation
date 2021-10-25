package pages;

import env.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class searchPage {

    public static WebDriver driver = DriverUtil.getDefaultDriver();
    public static WebDriverWait wait = new WebDriverWait(driver, 15);

    public static void navigateToUrl(String weburl) {
        driver.get(weburl);
        wait.until(ExpectedConditions.presenceOfElementLocated (By.id("gh-la")));
    }

    public static void searchItem(String searchItem) {
        driver.findElement(By.id("gh-ac")).sendKeys(searchItem);
        driver.findElement(By.id("gh-btn")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated (By.cssSelector("h1.srp-controls__count-heading")));
    }

    public static void selectAndAddSearchItem() {
        driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a/h3")).click();
    }

    public static void validateSelectedItem() {
        String itemName = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a/h3")).getText();
        System.out.println(itemName);
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (!winHandle.equals(winHandleBefore)) {
                driver.switchTo().window(winHandle);
                AddItemToCart();
                validateCartItem(itemName);
                driver.quit();
            }
        }
    }

    public static void AddItemToCart() {
        Select size = new Select(driver.findElement(By.name("Size")));
        size.selectByIndex(1);
        Select colour = new Select(driver.findElement(By.id("msku-sel-2")));
        colour.selectByIndex(1);
        driver.findElement(By.xpath("//a[contains(text(), 'Add to cart')]")).click();

    }

    public static void validateCartItem(String itemName) {
        driver.findElement(By.xpath("//button[contains(text(),'No thanks')]")).click();
        String checkOutItem = driver.findElement(By.cssSelector(".BOLD")).getText();
        System.out.println(checkOutItem);
        assertTrue(checkOutItem.contains(itemName));
    }

    public static void clickOnMyeBay() {
        driver.findElement(By.partialLinkText("My eBay")).click();
    }

    public static void enterCredentials(String userName) {
        driver.findElement(By.id("userid")).sendKeys(userName);
        driver.findElement(By.id("signin-continue-btn")).click();
    }

    public static void validateSignInErrorDetails() {
        String ErrorMessage = driver.findElement(By.id("errormsg")).getText();
        assertTrue(ErrorMessage,true );
        quitDriver();
    }
    public static void quitDriver(){
        driver.quit();

    }
}
