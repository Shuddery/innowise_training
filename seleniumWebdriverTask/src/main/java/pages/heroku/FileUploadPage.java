package pages.heroku;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;
import utils.TestProperties;
import waits.Waits;

public class FileUploadPage extends AbstractPage {

    protected WebDriver driver;
    private static final String URL = TestProperties.getHerokuAppUrl() + "upload";
    private static final By uploadFileInputLocator = By.xpath("//input[@id='file-upload']");
    private static final By uploadButtonLocator = By.xpath("//input[@id='file-submit']");
    private static final By uploadedFileLocator = By.xpath("//div[@id='uploaded-files']");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public FileUploadPage openPage() {
        driver.get(URL);
        return this;
    }

    private String getAbsolutePathOfFile(String fileName) throws URISyntaxException {
        URL url = getClass().getClassLoader().getResource(fileName);
        URI uri = url.toURI();
        File file = new File(uri);
        return file.getAbsolutePath();
    }

    public FileUploadPage chooseFileToUpload(String fileName) throws URISyntaxException {
        getWebElement(driver, uploadFileInputLocator).sendKeys(getAbsolutePathOfFile(fileName));
        return this;
    }

    public void clickUploadButton() {
        Waits.waitElementToBeClickable(driver, uploadButtonLocator).click();
    }

    public String getUploadedFileName() {
        return Waits.waitVisibilityOfElementLocated(driver, uploadedFileLocator).getText();
    }
}