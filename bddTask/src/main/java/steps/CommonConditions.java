package steps;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class CommonConditions {

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
    }

    @After
    public void closeBrowser() {
        DriverFactory.closeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}