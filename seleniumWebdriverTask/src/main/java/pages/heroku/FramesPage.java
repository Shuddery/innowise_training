package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import waits.Waits;

public class FramesPage extends AbstractPage {

    private static final By iFrameLinkLocator = By.xpath("//a[text()='iFrame']");
    private static final By inputTextFieldLocator = By.xpath("//body[@id='tinymce']/p");
    private static final By alignCenterButtonLocator = By.xpath("//button[@title='Align center']");

    public static WebElement getIFrameLink(WebDriver driver) {
        return getWebElement(driver, iFrameLinkLocator);
    }

    public static WebElement getInputFieldText(WebDriver driver) {
        return getWebElement(driver, inputTextFieldLocator);
    }

    public static WebElement getAlignCenterButton(WebDriver driver) {
        return Waits.waitPresenceOfElementLocated(driver, alignCenterButtonLocator);
    }
}