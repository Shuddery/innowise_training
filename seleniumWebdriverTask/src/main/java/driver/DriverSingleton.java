package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverSingleton {

    private static WebDriver driver;

    public DriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
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