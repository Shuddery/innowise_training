package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;
import utils.TestProperties;
import waits.Waits;

public class FramesPage extends AbstractPage {

    protected WebDriver driver;
    private static final String URL = TestProperties.getHerokuAppUrl() + "frames";
    private static final String FRAME_NAME = "mce_0_ifr";
    private static final By iFrameLinkLocator = By.xpath("//a[text()='iFrame']");
    private static final By inputTextLocator = By.xpath("//body[@id='tinymce']/p");
    private static final By alignCenterButtonLocator = By.xpath("//button[@title='Align center']");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public FramesPage openPage() {
        driver.get(URL);
        return this;
    }

    public FramesPage clickIFrameLink() {
        getWebElement(driver, iFrameLinkLocator).click();
        return this;
    }

    public FramesPage switchToFrame() {
        driver.switchTo().frame(FRAME_NAME);
        return this;
    }

    public FramesPage inputDataIntoFrame(String text) {
        getWebElement(driver, inputTextLocator).sendKeys(text);
        return this;
    }

    public void clickAlignCenterButton() {
        getWebElement(driver, alignCenterButtonLocator).click();
    }

    public FramesPage switchToDefaultFrame() {
        driver.switchTo().defaultContent();
        return this;
    }

    public boolean isAlignCenterButtonEnabled() {
        return Waits.waitPresenceOfElementLocated(driver, alignCenterButtonLocator).isEnabled();
    }
}