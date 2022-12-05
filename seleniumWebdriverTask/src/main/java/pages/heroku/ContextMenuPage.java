package pages.heroku;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AbstractPage;
import utils.TestProperties;

public class ContextMenuPage extends AbstractPage {

    protected WebDriver driver;
    private static final String URL = TestProperties.getHerokuAppUrl() + "context_menu";
    private static final By boxLocator = By.xpath("//div[@id='hot-spot']");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public ContextMenuPage openPage() {
        driver.get(URL);
        return this;
    }

    public ContextMenuPage rightClickOnBoxElement() {
        Actions actions = new Actions(driver);
        actions.contextClick(getWebElement(driver, boxLocator)).perform();
        return this;
    }

    public String getTextOfAlert() {
        return switchToAlert(driver).getText();
    }

    public void closeAlert() {
        switchToAlert(driver).dismiss();
    }
}