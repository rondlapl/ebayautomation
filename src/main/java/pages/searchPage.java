package pages;

import baseTests.BaseTest;
import env.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class searchPage {

    public static WebDriver driver = DriverUtil.getDefaultDriver();
    public static WebDriverWait wait = new WebDriverWait(driver, 15);

    public static void navigateToUrl(String weburl) {
        driver.get(weburl);
    }

    public static void searchItem(String searchItem) {
        driver.findElement(By.id("gh-ac")).sendKeys(searchItem);
        driver.findElement(By.id("gh-btn")).click();
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
                Select size = new Select(driver.findElement(By.name("Size")));
                size.selectByIndex(1);
                Select colour = new Select(driver.findElement(By.id("msku-sel-2")));
                colour.selectByIndex(1);
                driver.findElement(By.xpath("//a[contains(text(), 'Add to cart')]")).click();
                driver.findElement(By.xpath("//button[contains(text(),'No thanks')]")).click();
                String checkOutItem = driver.findElement(By.cssSelector(".BOLD")).getText();
                System.out.println(checkOutItem);
                assertTrue(checkOutItem.contains(itemName));
                driver.quit();
            }

        }

    }
}
