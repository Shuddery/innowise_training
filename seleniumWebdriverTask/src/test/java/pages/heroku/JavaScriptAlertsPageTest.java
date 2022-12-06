package pages.heroku;

import helpers.heroku.JavaScriptAlertsHelper;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CommonConditions;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class JavaScriptAlertsPageTest extends CommonConditions {

    JavaScriptAlertsHelper jsAlertsHelper;
    @BeforeClass(alwaysRun = true)
    public void navigateToJavaScriptAlertsPageTest() {
        jsAlertsHelper = new JavaScriptAlertsHelper(driver);
        jsAlertsHelper.openPage();
    }

    @Test
    public void isExpectedMessageEqualsActualAfterOkButtonTest() {
        String actualMessageAfterOkButton = jsAlertsHelper.clickAlertButton()
                .acceptAlert()
            .getMessageAfterClosingAlert();
        assertThat(actualMessageAfterOkButton,
            Matchers.equalTo(IConstants.messageAfterClickOkButtonInAlert));
    }

    @Test
    public void isExpectedMessageEqualsActualAfterCancelButtonTest() {
        String actualMessageAfterCancelButton = jsAlertsHelper.clickConfirmButton()
            .cancelAlert()
            .getMessageAfterClosingAlert();
        assertThat(actualMessageAfterCancelButton,
            Matchers.equalTo(IConstants.messageAfterClickCancelButtonInAlert));
    }

    @Test
    public void isActualMessageAfterClosingPromptContainInputDataTest() {
        String messageAfterClosingPromptWithInputData = jsAlertsHelper.clickPromptButton()
            .inputDataToAlert(IConstants.randomText)
            .acceptAlert()
            .getMessageAfterClosingAlert();
        Assert.assertTrue(messageAfterClosingPromptWithInputData.contains(IConstants.randomText));
    }
}