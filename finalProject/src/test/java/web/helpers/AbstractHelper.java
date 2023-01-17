package web.helpers;

import com.beust.ah.A;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AbstractHelper {
    protected static final Logger log = Logger.getLogger(AbstractHelper.class);
    protected WebDriver driver;

    public AbstractHelper(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open page")
    public void openPage(String url) {
        log.info("Open page with url - " + url);
        driver.get(url);
    }

    public void hoverOnWebElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}