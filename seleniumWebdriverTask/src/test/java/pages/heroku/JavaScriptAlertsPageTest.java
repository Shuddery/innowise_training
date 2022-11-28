package pages.heroku;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CommonConditions;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class JavaScriptAlertsPageTest extends CommonConditions {

    String actualMessageAfterOkButton;
    String actualMessageAfterCancelButton;
    String messageAfterClosingPromptWithInputData;

    @BeforeClass(alwaysRun = true)
    public void navigateToJavaScriptAlertsPageTest() {
        JavaScriptAlertsPage jsAlertsPage = new JavaScriptAlertsPage(driver);
        actualMessageAfterOkButton = jsAlertsPage.openPage()
            .clickAlertButton()
            .acceptAlert()
            .getMessageAfterClosingAlert();
        actualMessageAfterCancelButton = jsAlertsPage.clickConfirmButton()
            .cancelAlert()
            .getMessageAfterClosingAlert();
        messageAfterClosingPromptWithInputData = jsAlertsPage.clickPromptButton()
            .inputDataToAlert(IConstants.randomText)
            .acceptAlert()
            .getMessageAfterClosingAlert();
    }

    @Test
    public void isExpectedMessageEqualsActualAfterOkButtonTest() {
        assertThat(actualMessageAfterOkButton,
            Matchers.equalTo(IConstants.MessageAfterClickOkButtonInAlert));
    }

    @Test
    public void isExpectedMessageEqualsActualAfterCancelButtonTest() {
        assertThat(actualMessageAfterCancelButton,
            Matchers.equalTo(IConstants.MessageAfterClickCancelButtonInAlert));
    }

    @Test
    public void isActualMessageAfterClosingPromptContainInputDataTest() {
        assertThat("Actual message doesn`t contain input data",
            messageAfterClosingPromptWithInputData.contains(IConstants.randomText));
    }
}