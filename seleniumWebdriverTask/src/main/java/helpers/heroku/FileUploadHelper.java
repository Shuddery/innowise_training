package helpers.heroku;

import helpers.AbstractHelper;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.WebDriver;
import pages.heroku.FileUploadPage;
import utils.IConstants;

public class FileUploadHelper extends AbstractHelper {


    public FileUploadHelper(WebDriver driver) {
        super(driver);
    }

    public FileUploadHelper openPage() {
        openHerokuPage(IConstants.uploadEndpoint);
        return this;
    }

    private String getAbsolutePathOfFile(String fileName) throws URISyntaxException {
        java.net.URL url = getClass().getClassLoader().getResource(fileName);
        URI uri = url.toURI();
        File file = new File(uri);
        return file.getAbsolutePath();
    }

    public FileUploadHelper chooseFileToUpload(String fileName) throws URISyntaxException {
        FileUploadPage.getUploadFileInput(driver).sendKeys(getAbsolutePathOfFile(fileName));
        return this;
    }

    public void clickUploadButton() {
        FileUploadPage.getUploadButton(driver).click();
    }

    public String getUploadedFileName() {
        return FileUploadPage.getUploadedFile(driver).getText();
    }
}