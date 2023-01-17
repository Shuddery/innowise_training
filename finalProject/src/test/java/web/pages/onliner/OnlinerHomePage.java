package web.pages.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.AbstractPage;
import web.waits.Waits;

public class OnlinerHomePage extends AbstractPage {
    private static final By searchField = By.xpath("//input[@class='fast-search__input']");
    private static final By firstProduct = By.xpath("//div[@class='product__title']/a");
    private static final By searchedProductsIframe = By.xpath("//iframe[@class='modal-iframe']");

    public static WebElement getSearchField(WebDriver driver) {
        return getWebElement(driver, searchField);
    }

    public static WebElement getFirstProduct(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, firstProduct);
    }

    public static WebElement getSearchedProductsIframe(WebDriver driver) {
        return getWebElement(driver, searchedProductsIframe);
    }
}