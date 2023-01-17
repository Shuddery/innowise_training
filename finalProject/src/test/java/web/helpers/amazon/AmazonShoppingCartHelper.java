package web.helpers.amazon;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import web.helpers.AbstractHelper;
import web.pages.amazon.AmazonProductsPage;
import web.pages.amazon.AmazonShoppingCartPage;

public class AmazonShoppingCartHelper extends AbstractHelper {

    public AmazonShoppingCartHelper(WebDriver driver) {
        super(driver);
    }

    @Step("Get text of the cart header")
    public String getCartHeaderText() {
        log.info("Get text of the cart header");
        return AmazonShoppingCartPage.getCartHeader(driver).getText();
    }

    @Step("Get text of added product")
    public String getAddedProductText() {
        log.info("Get text of added product");
        return AmazonShoppingCartPage.getAddedProduct(driver).getText();
    }

    @Step("Get amount of products in shopping cart")
    public String getAmountOfProductsInShoppingCart() {
        log.info("Get amount of products in shopping cart");
        return AmazonShoppingCartPage.getValueOfProductsInShoppingCart(driver).getText();
    }
}