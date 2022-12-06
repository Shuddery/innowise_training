package helpers.heroku;

import helpers.AbstractHelper;
import org.openqa.selenium.WebDriver;
import pages.heroku.JavaScriptAlertsPage;
import utils.IConstants;

public class JavaScriptAlertsHelper extends AbstractHelper {

    public JavaScriptAlertsHelper(WebDriver driver) {
        super(driver);
    }

    public JavaScriptAlertsHelper openPage() {
        openHerokuPage(IConstants.javascriptAlertsEndpoint);
        return this;
    }

    public String getMessageAfterClosingAlert() {
        return JavaScriptAlertsPage.getMessageAfterClosingAlert(driver).getText();
    }

    public JavaScriptAlertsHelper clickAlertButton() {
        JavaScriptAlertsPage.getAlertButton(driver).click();
        return this;
    }

    public JavaScriptAlertsHelper clickConfirmButton() {
        JavaScriptAlertsPage.getConfirmButton(driver).click();
        return this;
    }

    public JavaScriptAlertsHelper clickPromptButton() {
        JavaScriptAlertsPage.getPromptButton(driver).click();
        return this;
    }

    public JavaScriptAlertsHelper acceptAlert() {
        acceptAlert(driver);
        return this;
    }

    public JavaScriptAlertsHelper cancelAlert() {
        dismissAlert(driver);
        return this;
    }

    public JavaScriptAlertsHelper inputDataToAlert(String text) {
        switchToAlert(driver).sendKeys(text);
        return this;
    }
}