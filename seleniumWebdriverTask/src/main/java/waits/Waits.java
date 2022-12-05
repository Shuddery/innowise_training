package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestProperties;

public class Waits {

    public static WebElement waitElementToBeClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TestProperties.getTimeoutSeconds())
            .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitPresenceOfElementLocated(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TestProperties.getTimeoutSeconds())
            .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitVisibilityOfElementLocated(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TestProperties.getTimeoutSeconds())
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}