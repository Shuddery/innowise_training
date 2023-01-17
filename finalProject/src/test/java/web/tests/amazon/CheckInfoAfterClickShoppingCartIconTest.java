package web.tests.amazon;

import listener.TestListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.IConstants;
import utils.PropertyReader;
import web.helpers.amazon.AmazonHomeHelper;
import web.helpers.amazon.AmazonShoppingCartHelper;
import web.tests.CommonConditions;

@ExtendWith(TestListener.class)
public class CheckInfoAfterClickShoppingCartIconTest extends CommonConditions {

    private static AmazonShoppingCartHelper shoppingCartHelper;

    @BeforeAll
    public static void addProductToCartAndClickShoppingCartIcon() {
        AmazonHomeHelper homeHelper = new AmazonHomeHelper(driver);
        homeHelper.openPage(PropertyReader.getAmazonUrl());
        shoppingCartHelper = homeHelper.fillSearchField(IConstants.productNameForAmazon)
            .clickSearchButton()
            .clickFirstProduct()
            .clickDeliverField()
            .clickCountriesDropdownMenu()
            .clickAvailableDeliveryCountry()
            .clickDoneButton()
            .clickAddToCartButton()
            .clickCartButton();
    }

    @Test
    public void isShoppingCartPageDisplayedTest() {
        Assertions.assertEquals(shoppingCartHelper.getCartHeaderText(), IConstants.amazonShoppingCartHeader);
    }

    @Test
    public void isAddedProductDisplayedTest() {
        Assertions.assertTrue(shoppingCartHelper.getAddedProductText().contains(IConstants.productNameForAmazon));
    }

    @Test
    public void isValueOfProductsChangedTest() {
        Assertions.assertEquals(shoppingCartHelper.getAmountOfProductsInShoppingCart(), IConstants.valueAfterAddProductToCart);
    }
}