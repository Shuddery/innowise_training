package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {}

    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            switch (browserName) {
                case "firefox" : {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    maximizeWindow();
                }
                case "opera" : {
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    maximizeWindow();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    maximizeWindow();
                }
            }
        }
        return driver;
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}