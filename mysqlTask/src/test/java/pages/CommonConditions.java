package pages;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertyReader;

public class CommonConditions {
    protected WebDriver driver;

    @BeforeClass()
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        DriverFactory.closeDriver();
    }
}