package helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class AbstractHelper {

    protected static final Logger log = Logger.getLogger(AbstractHelper.class);
    private static final String herokuUrl = PropertyReader.getHerokuAppUrl();
    protected WebDriver driver;

    public AbstractHelper(WebDriver driver) {
        this.driver = driver;
    }

    public AbstractHelper openHerokuPage(String endPoint) {
        log.info("Open heroku page");
        driver.get(herokuUrl + endPoint);
        return this;
    }
}