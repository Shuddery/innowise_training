package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;
import utils.TestProperties;
import waits.Waits;

public class JavaScriptAlertsPage extends AbstractPage {

    protected WebDriver driver;
    private static final String URL = TestProperties.getHerokuAppUrl() + "javascript_alerts";
    private static final By alertButtonLocator = By.xpath("//button[text()='Click for JS Alert']");
    private static final By confirmButtonLocator = By.xpath("//button[text()='Click for JS Confirm']");
    private static final By promptButtonLocator = By.xpath("//button[text()='Click for JS Prompt']");
    private static final By messageAfterClosingAlertLocator = By.xpath("//p[@id='result']");

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public JavaScriptAlertsPage openPage() {
        driver.get(URL);
        return this;
    }

    public String getMessageAfterClosingAlert() {
        return Waits.waitVisibilityOfElementLocated(driver, messageAfterClosingAlertLocator).getText();
    }

    public JavaScriptAlertsPage clickAlertButton() {
        getWebElement(driver, alertButtonLocator).click();
        return this;
    }

    public JavaScriptAlertsPage clickConfirmButton() {
        getWebElement(driver, confirmButtonLocator).click();
        return this;
    }

    public JavaScriptAlertsPage clickPromptButton() {
        getWebElement(driver, promptButtonLocator).click();
        return this;
    }

    public JavaScriptAlertsPage acceptAlert() {
        switchToAlert(driver).accept();
        return this;
    }

    public JavaScriptAlertsPage cancelAlert() {
        switchToAlert(driver).dismiss();
        return this;
    }

    public JavaScriptAlertsPage inputDataToAlert(String text) {
        switchToAlert(driver).sendKeys(text);
        return this;
    }
}