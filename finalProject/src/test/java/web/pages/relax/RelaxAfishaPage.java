package web.pages.relax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.AbstractPage;
import web.waits.Waits;

public class RelaxAfishaPage extends AbstractPage {

    private static final By cinemaCategoryLink = By.xpath("(//div[@class='b-cityes_item_block'])[2]/a");
    private static final By secondCardLink = By.xpath("(//a[contains(@class, 'btn')])[2]/preceding-sibling::a");
    private static final By categoryOfSecondCard = By.xpath("//div[@id='schedule']/preceding-sibling::a");
    private static final By feedbackSection = By.xpath("//div[@class='send-feedback']");

    public static WebElement getCinemaCategoryLink(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, cinemaCategoryLink);
    }

    public static WebElement getSecondCardLink(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, secondCardLink);
    }

    public static WebElement getCategoryOfSecondCard(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, categoryOfSecondCard);
    }

    public static WebElement getFeedbackSection(WebDriver driver) {
        return getWebElement(driver, feedbackSection);
    }
}