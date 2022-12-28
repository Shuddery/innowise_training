package helpers;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginHelper extends AbstractHelper {
    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public LoginHelper fillLoginField(String login) {
        LoginPage.getLoginField(driver).sendKeys(login);
        return this;
    }

    public LoginHelper clearLoginField() {
        LoginPage.getLoginField(driver).clear();
        return this;
    }

    public LoginHelper fillPasswordField(String password) {
        LoginPage.getPasswordField(driver).sendKeys(password);
        return this;
    }

    public LoginHelper clickLoginButton() {
        LoginPage.getLoginButton(driver).click();
        return this;
    }

    public LoginHelper clickLogoutButton() {
        LoginPage.getLogoutButton(driver).click();
        return this;
    }

    public String getMessageAfterCLickLoginButton() {
        return LoginPage.getMessageAfterClickLoginButton(driver).getText().replaceAll("\n.?", "");
    }
}