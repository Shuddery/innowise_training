package ui.tests;

import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ui.pages.IntelyCareDocumentsPage;
import ui.pages.IntelyCareLoginPage;
import utils.IConstants;
import utils.PropertyReader;

public class CheckFingerprintCardVerificationTest extends BaseTest {

    @Test()
    public void checkFingerprintCardVerificationTest() throws InterruptedException {
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
            .clickCertainDocumentButton(IConstants.fingerprintCard)
            .clickUploadNewDocumentButton()
            .clickExpirationDateButton()
            .selectExpirationDay()
            .clickStateSelect()
            .selectFirstState()
            .clickIssueDateButton()
            .selectIssueDay()
            .addFile(file.getAbsolutePath());
        boolean isFormatOfFileCorrect = documentsPage.isFormatOfFileIsCorrect(IConstants.correctFormat);
        documentsPage.clickUploadButton();
        String resultExpirationDate = documentsPage.getResultExpirationDate();
        String resultState = documentsPage.getResultState();
        String resultIssueDate = documentsPage.getResultIssueDate();
        documentsPage.clickEditWindowCloseButton();
        String statusOfFingerprintCard = documentsPage.getStatusOfCertainDocument(IConstants.fingerprintCard);
        Assertions.assertTrue(isFormatOfFileCorrect);
        Assertions.assertTrue(resultExpirationDate.contains(IConstants.expirationDay));
        Assertions.assertEquals(resultState, IConstants.firstState);
        Assertions.assertTrue(resultIssueDate.contains(IConstants.issueDay));
        Assertions.assertEquals(statusOfFingerprintCard, IConstants.reviewStatus);
    }
}