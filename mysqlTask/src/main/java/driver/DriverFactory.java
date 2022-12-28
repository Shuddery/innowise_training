package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    driver = new ChromeDriver(chromeOptions);
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