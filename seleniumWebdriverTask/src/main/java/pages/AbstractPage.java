package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage {
    public static WebElement getWebElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }
}