package helpers;

import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class AbstractHelper {
    private static final String herokuUrl = PropertyReader.getHerokuAppUrl();
    protected WebDriver driver;

    public AbstractHelper(WebDriver driver) {
        this.driver = driver;
    }

    public AbstractHelper openHerokuPage(String endPoint) {
        driver.get(herokuUrl + endPoint);
        return this;
    }
}