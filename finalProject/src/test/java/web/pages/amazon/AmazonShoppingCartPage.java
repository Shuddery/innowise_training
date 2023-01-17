package web.pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.AbstractPage;
import web.waits.Waits;

public class AmazonShoppingCartPage extends AbstractPage {
    private static final By cartHeader = By.xpath("//div[@class='a-row']/h1");
    private static final By addedProduct = By.xpath("//div[contains(@class, 'sc-item')]//span[@class='a-truncate-cut']");
    private static final By valueOfProductsInShoppingCart = By.xpath("//span[@id='nav-cart-count']");

    public static WebElement getCartHeader(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, cartHeader);
    }

    public static WebElement getAddedProduct(WebDriver driver) {
        return getWebElement(driver, addedProduct);
    }

    public static WebElement getValueOfProductsInShoppingCart(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, valueOfProductsInShoppingCart);
    }
}