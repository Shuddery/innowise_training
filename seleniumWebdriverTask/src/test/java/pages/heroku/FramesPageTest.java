package pages.heroku;

import helpers.heroku.FramesHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonConditions;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class FramesPageTest extends CommonConditions {

    @Test
    public void isAlignCenterButtonEnabledTest() {
        FramesHelper framesHelper = new FramesHelper(driver);
        framesHelper.openPage()
            .clickIFrameLink()
            .switchToFrame()
            .inputDataIntoFrame(IConstants.randomText)
            .switchToDefaultFrame()
            .clickAlignCenterButton();
        Assert.assertTrue(framesHelper.isAlignCenterButtonEnabled());
    }
}