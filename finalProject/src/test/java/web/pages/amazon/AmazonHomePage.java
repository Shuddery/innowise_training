package web.pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.AbstractPage;
import web.waits.Waits;

public class AmazonHomePage extends AbstractPage {
    private static final By searchField = By.xpath("//input[@id='twotabsearchtextbox']");
    private static final By searchButton = By.xpath("//input[@id='nav-search-submit-button']");

    public static WebElement getSearchField(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, searchField);
    }

    public static WebElement getSearchButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, searchButton);
    }
}