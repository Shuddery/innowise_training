package ui.tests;

import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ui.pages.IntelyCareDocumentsPage;
import ui.pages.IntelyCareLoginPage;
import utils.IConstants;
import utils.PropertyReader;

public class CheckStateBackgroundVerificationTest extends BaseTest {

    @Test
    public void checkStateBackgroundVerificationTest() throws InterruptedException {
        File file = new File(IConstants.pathToFile);
        IntelyCareLoginPage page = new IntelyCareLoginPage();
        page.open();
        IntelyCareDocumentsPage documentsPage = page.fillEmail(PropertyReader.getEmail())
            .fillPassword(PropertyReader.getPassword())
            .clickLoginButton()
            .clickIntelyProTab()
            .fillPidField(IConstants.pid)
            .clickSearchButton()
            .clickSearchedResult()
            .clickDocumentsTab()
            .clickStateBackgroundCheckButton()
            .clickUploadNewDocumentButton()
            .clickExpirationDateButton()
            .selectExpirationDay()
            .clickStateSelect()
            .selectFirstState()
            .clickStatusSelect()
            .selectFirstStatus()
            .addFile(file.getAbsolutePath());
        boolean isFormatOfFileCorrect = documentsPage.isFormatOfFileIsCorrect(IConstants.correctFormat);
        documentsPage.clickUploadButton();
        String resultExpirationDate = documentsPage.getResultExpirationDate();
        String resultState = documentsPage.getResultState();
        String resultStatus = documentsPage.getResultStatus();
        documentsPage.clickEditWindowCloseButton();
        String statusOfStateBackgroundCheck = documentsPage.getStateBackgroundCheckStatus();
        Assertions.assertTrue(isFormatOfFileCorrect);
        Assertions.assertTrue(resultExpirationDate.contains(IConstants.expirationDay));
        Assertions.assertEquals(resultState, IConstants.firstState);
        Assertions.assertEquals(resultStatus, IConstants.firstStatus);
        Assertions.assertEquals(statusOfStateBackgroundCheck, IConstants.reviewStatus);
    }
}