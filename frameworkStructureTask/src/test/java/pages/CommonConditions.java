package pages;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.TestProperties;

public class CommonConditions {

    protected WebDriver driver;

    @BeforeClass()
    public void setUp() {
        driver = DriverFactory.getDriver(TestProperties.getChromeBrowser());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        DriverFactory.closeDriver();
    }
}
