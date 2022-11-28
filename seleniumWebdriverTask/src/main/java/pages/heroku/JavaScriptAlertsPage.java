package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.EnvironmentConfig;
import waits.Waits;

public class JavaScriptAlertsPage {

    protected WebDriver driver;
    private static final String URL = EnvironmentConfig.herokuAppUrl + "javascript_alerts";
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
        driver.findElement(alertButtonLocator).click();
        return this;
    }

    public JavaScriptAlertsPage clickConfirmButton() {
        driver.findElement(confirmButtonLocator).click();
        return this;
    }

    public JavaScriptAlertsPage clickPromptButton() {
        driver.findElement(promptButtonLocator).click();
        return this;
    }

    public JavaScriptAlertsPage acceptAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public JavaScriptAlertsPage cancelAlert() {
        driver.switchTo().alert().dismiss();
        return this;
    }

    public JavaScriptAlertsPage inputDataToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
        return this;
    }
}