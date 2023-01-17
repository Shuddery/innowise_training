package web.waits;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

public class Waits {
    public static WebElement waitElementToBeClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(PropertyReader.getTimeoutSeconds()))
            .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitVisibilityOfElementLocated(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(PropertyReader.getTimeoutSeconds()))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static List<WebElement> waitPresenceOfAllElementsLocated(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(PropertyReader.getTimeoutSeconds()))
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}