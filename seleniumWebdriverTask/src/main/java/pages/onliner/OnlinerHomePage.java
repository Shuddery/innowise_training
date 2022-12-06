package pages.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import waits.Waits;

public class OnlinerHomePage extends AbstractPage {

    private static final By searchFieldLocator = By.xpath("//input[contains(@class, 'fast-search')]");
    private static final By iFrameLocator = By.xpath("//iframe[@class='modal-iframe']");
    private static final By firstProductNameLocator = By.xpath("(//div[contains(@class, 'product__title')]/a)[1]");
    private static final By searchFieldInFrameLocator = By.xpath("//div[@class='search__bar-wrapper']/input");
    private static final By captionOfProductLocator = By.xpath("//h1[contains(@class, 'catalog')]");
    private static final By footerLogoLocator = By.xpath("//div[@class='footer-style__logo']");

    public static WebElement getSearchField(WebDriver driver) {
        return getWebElement(driver, searchFieldLocator);
    }

    public static WebElement getIFrame(WebDriver driver) {
        return getWebElement(driver, iFrameLocator);
    }

    public static WebElement getFirstProductName(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, firstProductNameLocator);
    }

    public static WebElement getCaptionOfProduct(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, captionOfProductLocator);
    }

    public static WebElement getSearchFieldInFrame(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, searchFieldInFrameLocator);
    }

    public static WebElement getFooterLogo(WebDriver driver) {
        return Waits.waitPresenceOfElementLocated(driver, footerLogoLocator);
    }
 }