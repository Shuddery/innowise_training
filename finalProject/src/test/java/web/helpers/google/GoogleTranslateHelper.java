package web.helpers.google;

import org.openqa.selenium.WebDriver;
import web.helpers.AbstractHelper;
import web.pages.google.GoogleTranslatePage;

public class GoogleTranslateHelper extends AbstractHelper {

    public GoogleTranslateHelper(WebDriver driver) {
        super(driver);
    }

    public GoogleTranslateHelper chooseEnglishForTheLeftSide() {
        GoogleTranslatePage.getEnglishLanguageInTheLeftSide(driver).click();
        return this;
    }

    public GoogleTranslateHelper chooseRussianForTheRightSide() {
        GoogleTranslatePage.getRussianLanguageInTheRightSide(driver).click();
        return this;
    }

    public GoogleTranslateHelper fillTextField(String text) {
        GoogleTranslatePage.getTextField(driver).sendKeys(text);
        return this;
    }
}