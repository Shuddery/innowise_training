package helpers.heroku;

import helpers.AbstractHelper;
import org.openqa.selenium.WebDriver;
import pages.heroku.FramesPage;
import utils.IConstants;

public class FramesHelper extends AbstractHelper {

    public FramesHelper(WebDriver driver) {
        super(driver);
    }

    public FramesHelper openPage() {
        openHerokuPage(IConstants.framesEndpoint);
        return this;
    }

    public FramesHelper clickIFrameLink() {
        FramesPage.getIFrameLink(driver).click();
        return this;
    }

    public FramesHelper switchToFrame() {
        switchToFrameByName(driver, IConstants.frameName);
        return this;
    }

    public FramesHelper inputDataIntoFrame(String text) {
        FramesPage.getInputFieldText(driver).sendKeys(text);
        return this;
    }

    public void clickAlignCenterButton() {
        FramesPage.getAlignCenterButton(driver).click();
    }

    public FramesHelper switchToDefaultFrame() {
        driver.switchTo().defaultContent();
        return this;
    }

    public boolean isAlignCenterButtonEnabled() {
        return FramesPage.getAlignCenterButton(driver).isEnabled();
    }
}