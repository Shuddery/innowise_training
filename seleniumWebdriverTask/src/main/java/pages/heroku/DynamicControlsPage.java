package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import utils.EnvironmentConfig;
import waits.Waits;

public class DynamicControlsPage {

    protected WebDriver driver;
    private static final String URL = EnvironmentConfig.herokuAppUrl + "dynamic_controls";
    private static final By checkboxLocator = By.xpath("//div[@id='checkbox']/input");
    private static final By removeButtonLocator = By.xpath("//button[text()='Remove']");
    private static final By messageAfterClickOnRemoveButtonLocator = By.xpath("//form[@id='checkbox-example']/p");
    private static final By inputFieldLocator = By.xpath("//form[@id='input-example']/input");
    private static final By enableButtonLocator = By.xpath("//button[text()='Enable']");
    private static final By messageAfterClickOnEnableButtonLocator = By.xpath("//form[@id='input-example']/p");


    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicControlsPage openPage() {
        driver.get(URL);
        return this;
    }

    public DynamicControlsPage clickOnCheckbox() {
        Waits.waitElementToBeClickable(driver, checkboxLocator).click();
        return this;
    }

    public DynamicControlsPage clickRemoveButton() {
        Waits.waitElementToBeClickable(driver, removeButtonLocator).click();
        return this;
    }

    public String getTextOfMessageAfterClickRemoveButton() {
        return Waits.waitVisibilityOfElementLocated(driver, messageAfterClickOnRemoveButtonLocator).getText();
    }

    public boolean isCheckboxDisplayed() {
        try {
            return driver.findElement(checkboxLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isInputFieldEnabled() {
        return driver.findElement(inputFieldLocator).isEnabled();
    }

    public DynamicControlsPage clickEnableButton() {
        driver.findElement(enableButtonLocator).click();
        return this;
    }

    public String getTextOfMessageAfterClickEnableButton() {
        return Waits.waitVisibilityOfElementLocated(driver, messageAfterClickOnEnableButtonLocator).getText();
    }
}