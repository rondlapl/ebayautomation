package baseTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;

    // TestBase class constructor is used to initialize the properties object to
    // fetch config variables from config.properties file.
    public void TestBase() {

        try {
            File src = new File(".\\src\\main\\java\\com\\config\\config.properties");
            FileInputStream fs = new FileInputStream(src);
            prop = new Properties();
            prop.load(fs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initialization() throws InterruptedException {
        String browserName = prop.getProperty("Browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriverFilePath"));
            driver = new ChromeDriver();
        } else {
            System.out.println("Oops! Exception has Caught");
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL"));
    }
}