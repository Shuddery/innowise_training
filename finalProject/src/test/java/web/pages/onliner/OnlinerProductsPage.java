package web.pages.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.AbstractPage;
import web.waits.Waits;

public class OnlinerProductsPage extends AbstractPage {
    private static final By productHeader = By.xpath("//div[@class='catalog-masthead']/h1");
    private static final By firstOfferWithMinPrice = By.xpath("(//div[contains(@class, 'product-aside__offers-item')])[2]");
    private static final By addToCartButton = By.xpath("//a[@data-shop-id='707' and text()='В корзину']");
    private static final By addedToCartMessage = By.xpath("(//div[@class='product-recommended__subheader'])[1]");
    private static final By continueButton = By.xpath("(//div[contains(@class, 'product-recommended__control')]/a)[1]");
    private static final By goToCartButton = By.xpath("(//div[contains(@class, 'product-recommended__control')]/a)[2]");
    private static final By closeButton = By.xpath("//div[@class='product-recommended__sidebar-close']");
    private static final By valueOfProductsInShoppingCart = By.xpath("//div[@class='auth-bar__counter']");
    private static final By shoppingCartIcon = By.xpath("//div[@id='userbar']//a");

    public static WebElement getProductHeader(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, productHeader);
    }

    public static WebElement getFirstOfferWithMinPrice(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, firstOfferWithMinPrice);
    }

    public static WebElement getAddToCartButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, addToCartButton);
    }

    public static WebElement getAddedToCartMessage(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, addedToCartMessage);
    }

    public static WebElement getContinueButton(WebDriver driver) {
        return getWebElement(driver, continueButton);
    }

    public static WebElement getGoToCartButton(WebDriver driver) {
        return getWebElement(driver, goToCartButton);
    }

    public static WebElement getCloseButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, closeButton);
    }

    public static WebElement getValueOfProductsInShoppingCart(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, valueOfProductsInShoppingCart);
    }

    public static WebElement getShoppingCartIcon(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, shoppingCartIcon);
    }
}