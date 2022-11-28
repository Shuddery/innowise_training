package pages.heroku;

import org.hamcrest.Matchers;
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
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        actualMessageAfterRemoveButton = dynamicControlsPage.openPage()
            .clickOnCheckbox()
            .clickRemoveButton()
            .getTextOfMessageAfterClickRemoveButton();
        isCheckboxDisplayed = dynamicControlsPage.isCheckboxDisplayed();
        isInputFieldEnabledBeforeClickEnableButton = dynamicControlsPage.isInputFieldEnabled();
        actualMessageAfterEnableButton = dynamicControlsPage.clickEnableButton()
            .getTextOfMessageAfterClickEnableButton();
        isInputFieldEnabledAfterClickEnableButton = dynamicControlsPage.isInputFieldEnabled();
    }

    @Test
    public void isMessageAppearAfterClickRemoveButtonTest() {
        assertThat(actualMessageAfterRemoveButton,
            Matchers.equalTo(IConstants.messageAfterClickOnRemoveButton));
    }

    @Test
    public void isCheckboxNotDisplayedAfterClickRemoveButtonTest() {
        assertThat(isCheckboxDisplayed, Matchers.equalTo(false));
    }

    @Test
    public void isInputFieldNotEnabledBeforeClickEnableButtonTest() {
        assertThat(isInputFieldEnabledBeforeClickEnableButton, Matchers.equalTo(false));
    }

    @Test
    public void isMessageAppearAfterClickEnableButtonTest() {
        assertThat(actualMessageAfterEnableButton,
            Matchers.equalTo(IConstants.messageAfterClickOnEnableButton));
    }

    @Test
    public void isInputFieldEnabledAfterClickEnableButtonTest() {
        assertThat("Input field isn`t enabled after click on enable button",
            isInputFieldEnabledAfterClickEnableButton);
    }
}