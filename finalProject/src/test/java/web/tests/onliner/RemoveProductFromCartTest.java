package web.tests.onliner;

import listener.TestListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.IConstants;
import utils.PropertyReader;
import web.helpers.onliner.OnlinerHomeHelper;
import web.helpers.onliner.OnlinerShoppingCartHelper;
import web.tests.CommonConditions;

@ExtendWith(TestListener.class)
public class RemoveProductFromCartTest extends CommonConditions {

    @Test
    public void checkMessageAfterRemoveProductFromCartTest() {
        OnlinerHomeHelper homeHelper = new OnlinerHomeHelper(driver);
        homeHelper.openPage(PropertyReader.getOnlinerUrl());
        OnlinerShoppingCartHelper shoppingCartHelper = homeHelper.fillSearchField(IConstants.productNameForOnliner)
            .switchToProductsFrame()
            .clickFirstProduct()
            .hoverOnFirstProductWithMinPrice()
            .clickAddToCartButton()
            .clickCloseButton()
            .clickShoppingCartIcon()
            .hoverOnAddedToCartProduct()
            .clickDeleteIcon()
            .clickCloseButton();
        Assertions.assertEquals(shoppingCartHelper.getEmptyShoppingCartMessageText(), IConstants.emptyShoppingCartMessage);
    }
}