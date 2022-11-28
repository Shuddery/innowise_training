package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.EnvironmentConfig;

public class FramesPage {

    protected WebDriver driver;
    private static final String URL = EnvironmentConfig.herokuAppUrl + "frames";
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
        driver.findElement(iFrameLinkLocator).click();
        return this;
    }

    public FramesPage switchToFrame() {
        driver.switchTo().frame(FRAME_NAME);
        return this;
    }

    public FramesPage inputDataIntoFrame(String text) {
        driver.findElement(inputTextLocator).sendKeys(text);
        return this;
    }

    public void clickAlignCenterButton() {
        driver.findElement(alignCenterButtonLocator).click();
    }

    public FramesPage switchToDefaultFrame() {
        driver.switchTo().defaultContent();
        return this;
    }

    public boolean isAlignCenterButtonEnabled() {
        return driver.findElement(alignCenterButtonLocator).isEnabled();
    }
}