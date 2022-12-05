package pages.heroku;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CommonConditions;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class JavaScriptAlertsPageTest extends CommonConditions {

    JavaScriptAlertsPage jsAlertsPage;
    @BeforeClass(alwaysRun = true)
    public void navigateToJavaScriptAlertsPageTest() {
        jsAlertsPage = new JavaScriptAlertsPage(driver);
        jsAlertsPage.openPage();
    }

    @Test
    public void isExpectedMessageEqualsActualAfterOkButtonTest() {
        String actualMessageAfterOkButton = jsAlertsPage.clickAlertButton()
                .acceptAlert()
            .getMessageAfterClosingAlert();
        assertThat(actualMessageAfterOkButton,
            Matchers.equalTo(IConstants.MessageAfterClickOkButtonInAlert));
    }

    @Test
    public void isExpectedMessageEqualsActualAfterCancelButtonTest() {
        String actualMessageAfterCancelButton = jsAlertsPage.clickConfirmButton()
            .cancelAlert()
            .getMessageAfterClosingAlert();
        assertThat(actualMessageAfterCancelButton,
            Matchers.equalTo(IConstants.MessageAfterClickCancelButtonInAlert));
    }

    @Test
    public void isActualMessageAfterClosingPromptContainInputDataTest() {
        String messageAfterClosingPromptWithInputData = jsAlertsPage.clickPromptButton()
            .inputDataToAlert(IConstants.randomText)
            .acceptAlert()
            .getMessageAfterClosingAlert();
        Assert.assertTrue(messageAfterClosingPromptWithInputData.contains(IConstants.randomText));
    }
}