package steps;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class BaseSteps {

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getChromeBrowser());
    }

    @After
    public void closeBrowser() {
        DriverFactory.closeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}