package web.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.AbstractPage;
import web.waits.Waits;

public class GoogleTranslatePage extends AbstractPage {

    private static final By englishLanguageInTheLeftSide = By.xpath("//button[@id='i8']");
    private static final By russianLanguageInTheRightSide = By.xpath("//button[@id='i11']");
    private static final By textField = By.xpath("//textarea[@class='er8xn']");

    public static WebElement getEnglishLanguageInTheLeftSide(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, englishLanguageInTheLeftSide);
    }

    public static WebElement getRussianLanguageInTheRightSide(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, russianLanguageInTheRightSide);
    }

    public static WebElement getTextField(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, textField);
    }
}