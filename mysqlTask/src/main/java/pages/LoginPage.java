package pages;

import static pages.AbstractPage.getWebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import waits.Waits;

public class LoginPage {
    private static final By loginFieldLocator = By.cssSelector("#username");
    private static final By passwordFieldLocator = By.cssSelector("#password");
    private static final By loginButtonLocator = By.cssSelector(".radius");
    private static final By logoutButtonLocator = By.cssSelector(".button.radius");
    private static final By messageAfterClickLoginButtonLocator = By.cssSelector("#flash");


    public static WebElement getLoginField(WebDriver driver) {
        return getWebElement(driver, loginFieldLocator);
    }

    public static WebElement getPasswordField(WebDriver driver) {
        return getWebElement(driver, passwordFieldLocator);
    }

    public static WebElement getLoginButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, loginButtonLocator);
    }

    public static WebElement getLogoutButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, logoutButtonLocator);
    }

    public static WebElement getMessageAfterClickLoginButton(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, messageAfterClickLoginButtonLocator);
    }
}