package web.helpers.onliner;

import com.beust.ah.A;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import web.helpers.AbstractHelper;
import web.pages.onliner.OnlinerProductsPage;

public class OnlinerProductsHelper extends AbstractHelper {

    public OnlinerProductsHelper(WebDriver driver) {
        super(driver);
    }

    @Step("Get header text of the product")
    public String getProductHeaderText() {
        log.info("Get header text of the product");
        return OnlinerProductsPage.getProductHeader(driver).getText();
    }

    @Step("Hover on the first product with min price")
    public OnlinerProductsHelper hoverOnFirstProductWithMinPrice() {
        log.info("Hover on the first product with min price");
        hoverOnWebElement(OnlinerProductsPage.getFirstOfferWithMinPrice(driver));
        return this;
    }

    @Step("Click on add to cart button")
    public OnlinerProductsHelper clickAddToCartButton() {
        log.info("Click on add to cart button");
        OnlinerProductsPage.getAddToCartButton(driver).click();
        return this;
    }

    @Step("Get text of added to cart message")
    public String getAddedToCartMessageText() {
        log.info("Get text of added to cart message");
        return OnlinerProductsPage.getAddedToCartMessage(driver).getText();
    }

    @Step("Check if continue button is displayed")
    public boolean isContinueButtonDisplayed() {
        log.info("Check if continue button is displayed");
        return OnlinerProductsPage.getContinueButton(driver).isDisplayed();
    }

    @Step("Check if go to cart button is displayed")
    public boolean isGoToCartButtonDisplayed() {
        log.info("Check if go to cart button is displayed");
        return OnlinerProductsPage.getGoToCartButton(driver).isDisplayed();
    }

    @Step("Click on close button")
    public OnlinerProductsHelper clickCloseButton() {
        log.info("Click on close button");
        OnlinerProductsPage.getCloseButton(driver).click();
        return this;
    }

    @Step("Get amount of products in shopping cart")
    public String getAmountOfProductsInShoppingCart() {
        log.info("Get amount of products in shopping cart");
        return OnlinerProductsPage.getValueOfProductsInShoppingCart(driver).getText();
    }

    @Step("Click on shopping cart icon")
    public OnlinerShoppingCartHelper clickShoppingCartIcon() {
        log.info("Click on shopping cart icon");
        OnlinerProductsPage.getShoppingCartIcon(driver).click();
        return new OnlinerShoppingCartHelper(driver);
    }
}