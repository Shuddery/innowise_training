package ui.tests;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ui.pages.IntelyCareDocumentsPage;
import ui.pages.IntelyCareLoginPage;
import utils.IConstants;
import utils.PropertyReader;

public class CheckI9SignatureVerificationTest extends BaseTest {

    @Test
    public void checkI9SignatureVerificationTest() throws InterruptedException {
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
            .clickCertainDocumentButton(IConstants.i9Signature)
            .clickUploadNewDocumentButton()
            .drawSignature()
            .clickSaveSignatureButton();
        boolean isSignatureDisplayed = documentsPage.isUploadedImageDisplayed();
        documentsPage.clickEditWindowCloseButton();
        String statusOfI9Signature = documentsPage.getStatusOfCertainDocument(IConstants.i9Signature);
        Assertions.assertTrue(isSignatureDisplayed);
        Assertions.assertEquals(statusOfI9Signature, IConstants.reviewStatus);
    }
}