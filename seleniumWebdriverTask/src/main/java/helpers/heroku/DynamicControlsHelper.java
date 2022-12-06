package helpers.heroku;

import helpers.AbstractHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.heroku.DynamicControlsPage;
import utils.IConstants;

public class DynamicControlsHelper extends AbstractHelper {

    public DynamicControlsHelper(WebDriver driver) {
        super(driver);
    }

    public DynamicControlsHelper openPage() {
        openHerokuPage(IConstants.dynamicControlsEndpoint);
        return this;
    }

    public DynamicControlsHelper clickOnCheckbox() {
        DynamicControlsPage.getCheckbox(driver).click();
        return this;
    }

    public DynamicControlsHelper clickRemoveButton() {
        DynamicControlsPage.getRemoveButton(driver).click();
        return this;
    }

    public String getTextOfMessageAfterClickRemoveButton() {
        return DynamicControlsPage.getMessageAfterClickOnRemoveButtonLocator(driver).getText();
    }

    public boolean isCheckboxDisplayed() {
        try {
            return DynamicControlsPage.getCheckbox(driver).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isInputFieldEnabled() {
        return DynamicControlsPage.getInputField(driver).isEnabled();
    }

    public DynamicControlsHelper clickEnableButton() {
        DynamicControlsPage.getEnableButton(driver).click();
        return this;
    }

    public String getTextOfMessageAfterClickEnableButton() {
        return DynamicControlsPage.getMessageAfterClickOnEnableButtonLocator(driver).getText();
    }
}