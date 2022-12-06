package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import waits.Waits;

public class DynamicControlsPage extends AbstractPage {

    private static final By checkboxLocator = By.xpath("//div[@id='checkbox']/input");
    private static final By removeButtonLocator = By.xpath("//button[text()='Remove']");
    private static final By messageAfterClickOnRemoveButtonLocator = By.xpath("//form[@id='checkbox-example']/p");
    private static final By inputFieldLocator = By.xpath("//form[@id='input-example']/input");
    private static final By enableButtonLocator = By.xpath("//button[text()='Enable']");
    private static final By messageAfterClickOnEnableButtonLocator = By.xpath("//form[@id='input-example']/p");

    public static WebElement getCheckbox(WebDriver driver){
        return getWebElement(driver, checkboxLocator);
    }

    public static WebElement getRemoveButton(WebDriver driver){
        return Waits.waitElementToBeClickable(driver, removeButtonLocator);
    }

    public static WebElement getMessageAfterClickOnRemoveButtonLocator(WebDriver driver){
        return Waits.waitVisibilityOfElementLocated(driver, messageAfterClickOnRemoveButtonLocator);
    }

    public static WebElement getEnableButton(WebDriver driver){
        return Waits.waitElementToBeClickable(driver, enableButtonLocator);
    }

    public static WebElement getMessageAfterClickOnEnableButtonLocator(WebDriver driver){
        return Waits.waitVisibilityOfElementLocated(driver, messageAfterClickOnEnableButtonLocator);
    }

    public static WebElement getInputField(WebDriver driver){
        return Waits.waitPresenceOfElementLocated(driver, inputFieldLocator);
    }
}