package pages.heroku;

import org.testng.annotations.Test;
import pages.CommonConditions;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class FramesPageTest extends CommonConditions {

    @Test
    public void isAlignCenterButtonEnabledTest() {
        FramesPage framesPage = new FramesPage(driver);
        framesPage.openPage()
            .clickIFrameLink()
            .switchToFrame()
            .inputDataIntoFrame(IConstants.randomText)
            .switchToDefaultFrame()
            .clickAlignCenterButton();
        assertThat("Align center button isn`t enabled", framesPage.isAlignCenterButtonEnabled());
    }
}