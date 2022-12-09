package helpers;

import builder.Credentials;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import waits.IConstants;

public class LoginHelper extends AbstractHelper {

    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    @Step("Open heroku login page")
    public LoginHelper openPage() {
        openHerokuPage(IConstants.loginEndpoint);
        return this;
    }

    @Step("Fill login field with username")
    public LoginHelper fillLoginField(Credentials credentials) {
        log.info("Fill login field");
        LoginPage.getLoginField(driver).sendKeys(credentials.getLogin());
        return this;
    }

    @Step("Clear login field")
    public LoginHelper clearLoginField() {
        log.info("Clear login field");
        LoginPage.getLoginField(driver).clear();
        return this;
    }

    @Step("Fill password field")
    public LoginHelper fillPasswordField(Credentials credentials) {
        log.info("Fill password field");
        LoginPage.getPasswordField(driver).sendKeys(credentials.getPassword());
        return this;
    }

    @Step("Click on login button")
    public LoginHelper clickLoginButton() {
        log.info("Click login button");
        LoginPage.getLoginButton(driver).click();
        return this;
    }

    @Step("Get message after click on login button")
    public String getMessageAfterCLickLoginButton() {
        log.info("Get message after click on login button");
        return LoginPage.getMessageAfterClickLoginButton(driver).getText().replaceAll("\n.?", "");
    }
}