package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import waits.Waits;

public class JavaScriptAlertsPage extends AbstractPage {

    private static final By alertButtonLocator = By.xpath("//button[text()='Click for JS Alert']");
    private static final By confirmButtonLocator = By.xpath("//button[text()='Click for JS Confirm']");
    private static final By promptButtonLocator = By.xpath("//button[text()='Click for JS Prompt']");
    private static final By messageAfterClosingAlertLocator = By.xpath("//p[@id='result']");

    public static WebElement getAlertButton(WebDriver driver) {
        return getWebElement(driver, alertButtonLocator);
    }

    public static WebElement getConfirmButton(WebDriver driver) {
        return getWebElement(driver, confirmButtonLocator);
    }

    public static WebElement getPromptButton(WebDriver driver) {
        return getWebElement(driver, promptButtonLocator);
    }

    public static WebElement getMessageAfterClosingAlert(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, messageAfterClosingAlertLocator);
    }
}