package pages.heroku;

import java.net.URISyntaxException;
import org.testng.annotations.Test;
import pages.CommonConditions;
import org.hamcrest.Matchers;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class FileUploadPageTest extends CommonConditions {

    @Test
    public void isFileUploadedAfterClickUploadButtonTest() throws URISyntaxException {
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.openPage()
            .chooseFileToUpload(IConstants.fileName)
            .clickUploadButton();
        assertThat(fileUploadPage.getUploadedFileName(), Matchers.equalTo(IConstants.fileName));
    }
}