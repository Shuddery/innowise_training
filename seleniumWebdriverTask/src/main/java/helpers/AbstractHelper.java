package helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import utils.TestProperties;

public abstract class AbstractHelper {

    protected WebDriver driver;
    public static final String herokuUrl = TestProperties.getHerokuAppUrl();
    public static final String onlinerUrl = TestProperties.getOnlinerUrl();

    public AbstractHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openHerokuPage(String endpoint) {
        driver.get(herokuUrl + endpoint);
    }

    public void openOnlinerPage() {
        driver.get(onlinerUrl);
    }

    public static Alert switchToAlert(WebDriver driver) {
        return driver.switchTo().alert();
    }
    public static void switchToFrameByName(WebDriver driver, String name) {
        driver.switchTo().frame(name);
    }

    public static void acceptAlert(WebDriver driver) {
        switchToAlert(driver).accept();
    }
    public static void dismissAlert(WebDriver driver) {
        switchToAlert(driver).dismiss();
    }
}
