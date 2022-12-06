package pages.heroku;

import helpers.heroku.DynamicControlsHelper;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CommonConditions;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class DynamicControlsPageTest extends CommonConditions {

    String actualMessageAfterRemoveButton;
    String actualMessageAfterEnableButton;
    private boolean isCheckboxDisplayed;
    private boolean isInputFieldEnabledBeforeClickEnableButton;
    private boolean isInputFieldEnabledAfterClickEnableButton;

    @BeforeClass(alwaysRun = true)
    public void navigateToDynamicControlsPageTest() {
        DynamicControlsHelper dynamicControlsHelper = new DynamicControlsHelper(driver);
        actualMessageAfterRemoveButton = dynamicControlsHelper.openPage()
            .clickOnCheckbox()
            .clickRemoveButton()
            .getTextOfMessageAfterClickRemoveButton();
        isCheckboxDisplayed = dynamicControlsHelper.isCheckboxDisplayed();
        isInputFieldEnabledBeforeClickEnableButton = dynamicControlsHelper.isInputFieldEnabled();
        actualMessageAfterEnableButton = dynamicControlsHelper.clickEnableButton()
            .getTextOfMessageAfterClickEnableButton();
        isInputFieldEnabledAfterClickEnableButton = dynamicControlsHelper.isInputFieldEnabled();
    }

    @Test
    public void isMessageAppearAfterClickRemoveButtonTest() {
        assertThat(actualMessageAfterRemoveButton,
            Matchers.equalTo(IConstants.messageAfterClickOnRemoveButton));
    }

    @Test
    public void isCheckboxNotDisplayedAfterClickRemoveButtonTest() {
        Assert.assertFalse(isCheckboxDisplayed);
    }

    @Test
    public void isInputFieldNotEnabledBeforeClickEnableButtonTest() {
        Assert.assertFalse(isInputFieldEnabledBeforeClickEnableButton);
    }

    @Test
    public void isMessageAppearAfterClickEnableButtonTest() {
        assertThat(actualMessageAfterEnableButton,
            Matchers.equalTo(IConstants.messageAfterClickOnEnableButton));
    }

    @Test
    public void isInputFieldEnabledAfterClickEnableButtonTest() {
        Assert.assertTrue(isInputFieldEnabledAfterClickEnableButton);
    }
}