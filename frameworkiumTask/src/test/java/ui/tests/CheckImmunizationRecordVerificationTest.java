package ui.tests;

import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ui.pages.IntelyCareDocumentsPage;
import ui.pages.IntelyCareLoginPage;
import utils.IConstants;
import utils.PropertyReader;

public class CheckImmunizationRecordVerificationTest extends BaseTest {

    @Test
    public void checkImmunizationRecordVerificationTest() throws InterruptedException {
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
            .clickCertainDocumentButton(IConstants.immunizationRecord)
            .clickUploadNewDocumentButton()
            .addFile(file.getAbsolutePath());
        boolean isFormatOfFileCorrect = documentsPage.isFormatOfFileIsCorrect(IConstants.correctFormat);
        documentsPage.clickUploadButton();
        boolean isUploadedFileDisplayed = documentsPage.isUploadedImageDisplayed();
        documentsPage.clickEditWindowCloseButton();
        String statusOfImmunizationRecord = documentsPage.getStatusOfCertainDocument(IConstants.immunizationRecord);
        Assertions.assertTrue(isFormatOfFileCorrect);
        Assertions.assertTrue(isUploadedFileDisplayed);
        Assertions.assertEquals(statusOfImmunizationRecord, IConstants.reviewStatus);
    }
}