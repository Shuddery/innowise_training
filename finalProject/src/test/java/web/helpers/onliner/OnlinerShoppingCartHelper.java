package web.helpers.onliner;

import org.openqa.selenium.WebDriver;
import web.helpers.AbstractHelper;
import web.pages.onliner.OnlinerShoppingCartPage;

public class OnlinerShoppingCartHelper extends AbstractHelper {

    public OnlinerShoppingCartHelper(WebDriver driver) {
        super(driver);
    }

    public String getCartHeaderText() {
        return OnlinerShoppingCartPage.getCartHeader(driver).getText();
    }

    public String getAddedToCartProductName() {
        return OnlinerShoppingCartPage.getAddedToCartProduct(driver).getText();
    }

    public OnlinerShoppingCartHelper hoverOnAddedToCartProduct() {
        hoverOnWebElement(OnlinerShoppingCartPage.getAddedToCartProduct(driver));
        return this;
    }

    public OnlinerShoppingCartHelper clickDeleteIcon() {
        OnlinerShoppingCartPage.getDeleteIcon(driver).click();
        return this;
    }

    public OnlinerShoppingCartHelper clickCloseButton() {
        OnlinerShoppingCartPage.getCloseButton(driver).click();
        return this;
    }

    public String getEmptyShoppingCartMessageText() {
        return OnlinerShoppingCartPage.getEmptyShoppingCartMessage(driver).getText();
    }
}