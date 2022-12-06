package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;

public class ContextMenuPage extends AbstractPage {

    private static final By boxLocator = By.xpath("//div[@id='hot-spot']");

    public static WebElement getBoxElement(WebDriver driver) {
        return getWebElement(driver, boxLocator);
    }
}