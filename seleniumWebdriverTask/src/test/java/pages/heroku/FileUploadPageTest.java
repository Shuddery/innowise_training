package pages.heroku;

import helpers.heroku.FileUploadHelper;
import java.net.URISyntaxException;
import org.testng.annotations.Test;
import pages.CommonConditions;
import org.hamcrest.Matchers;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class FileUploadPageTest extends CommonConditions {

    @Test
    public void isFileUploadedAfterClickUploadButtonTest() throws URISyntaxException {
        FileUploadHelper fileUploadHelper = new FileUploadHelper(driver);
        fileUploadHelper.openPage()
            .chooseFileToUpload(IConstants.fileName)
            .clickUploadButton();
        assertThat(fileUploadHelper.getUploadedFileName(), Matchers.equalTo(IConstants.fileName));
    }
}