package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import waits.Waits;

public class FileUploadPage extends AbstractPage {

    private static final By uploadFileInputLocator = By.xpath("//input[@id='file-upload']");
    private static final By uploadButtonLocator = By.xpath("//input[@id='file-submit']");
    private static final By uploadedFileLocator = By.xpath("//div[@id='uploaded-files']");

    public static WebElement getUploadFileInput(WebDriver driver) {
        return getWebElement(driver, uploadFileInputLocator);
    }

    public static WebElement getUploadButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, uploadButtonLocator);
    }

    public static WebElement getUploadedFile(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, uploadedFileLocator);
    }
}