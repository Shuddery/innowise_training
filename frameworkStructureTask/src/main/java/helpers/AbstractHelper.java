package helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.TestProperties;

public class AbstractHelper {

    protected static final Logger log = Logger.getLogger(AbstractHelper.class);
    private static final String herokuUrl = TestProperties.getHerokuAppUrl();
    protected WebDriver driver;

    public AbstractHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openHerokuPage(String endPoint) {
        log.info("Open heroku page");
        driver.get(herokuUrl + endPoint);
    }
}