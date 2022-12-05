package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage {

    public abstract AbstractPage openPage();
    public static WebElement getWebElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    public static Alert switchToAlert(WebDriver driver) {
        return driver.switchTo().alert();
    }
}