package web.tests.onliner;

import listener.TestListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.IConstants;
import utils.PropertyReader;
import web.helpers.onliner.OnlinerHomeHelper;
import web.helpers.onliner.OnlinerShoppingCartHelper;
import web.tests.CommonConditions;

@ExtendWith(TestListener.class)
public class CheckIfAddedProductIsDisplayedInShoppingCartTest extends CommonConditions {

    private static OnlinerShoppingCartHelper shoppingCartHelper;

    @BeforeAll()
    public static void navigateToShoppingCartPage() {
        OnlinerHomeHelper homeHelper = new OnlinerHomeHelper(driver);
        homeHelper.openPage(PropertyReader.getOnlinerUrl());
        shoppingCartHelper = homeHelper.fillSearchField(IConstants.productNameForOnliner)
            .switchToProductsFrame()
            .clickFirstProduct()
            .hoverOnFirstProductWithMinPrice()
            .clickAddToCartButton()
            .clickCloseButton()
            .clickShoppingCartIcon();
    }

    @Test
    public void isShoppingCartPageOpenedTest() {
        Assertions.assertEquals(shoppingCartHelper.getCartHeaderText(), IConstants.onlinerShoppingCartHeader);
    }

    @Test
    public void isAddedProductDisplayedTest() {
        Assertions.assertEquals(shoppingCartHelper.getAddedToCartProductName(), IConstants.productNameForOnliner);
    }
}