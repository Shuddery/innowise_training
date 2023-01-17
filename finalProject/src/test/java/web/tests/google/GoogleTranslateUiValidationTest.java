package web.tests.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import utils.PropertyReader;
import utils.ScreenshotComparisonHelper;
import web.helpers.google.GoogleTranslateHelper;
import web.tests.CommonConditions;

public class GoogleTranslateUiValidationTest extends CommonConditions {

    @Test
    public void checkUiValidationTest() throws InterruptedException {
        GoogleTranslateHelper googleTranslateHelper = new GoogleTranslateHelper(driver);
        googleTranslateHelper.openPage(PropertyReader.getGoogleTranslateUrl());
        googleTranslateHelper.chooseEnglishForTheLeftSide()
            .chooseRussianForTheRightSide()
            .fillTextField("Test");

        Thread.sleep(2000);

        Screenshot actualImage = new ScreenshotComparisonHelper()
            .takeActualScreenshot();

        Screenshot expectedImage = new ScreenshotComparisonHelper()
            .getExpectedScreenshot();

        ImageDiff diff = new ScreenshotComparisonHelper().compareScreenshots(
            actualImage,
            expectedImage,
            10);
        Assertions.assertFalse(diff.hasDiff());
    }
}