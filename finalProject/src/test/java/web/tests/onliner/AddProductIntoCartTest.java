package web.tests.onliner;

import listener.TestListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.IConstants;
import utils.PropertyReader;
import web.helpers.onliner.OnlinerHomeHelper;
import web.helpers.onliner.OnlinerProductsHelper;
import web.tests.CommonConditions;

@ExtendWith(TestListener.class)
public class AddProductIntoCartTest extends CommonConditions {

    private static String addedToCartMessageText;
    private static boolean isContinueButtonDisplayed;
    private static boolean isGoToCartButtonDisplayed;
    private static OnlinerProductsHelper productsHelper;

    @BeforeAll()
    public static void navigateToProductsPageAndClickAddToCartButton() {
        OnlinerHomeHelper homeHelper = new OnlinerHomeHelper(driver);
        homeHelper.openPage(PropertyReader.getOnlinerUrl());
        productsHelper = homeHelper.fillSearchField(IConstants.productNameForOnliner)
            .switchToProductsFrame()
            .clickFirstProduct()
            .hoverOnFirstProductWithMinPrice()
            .clickAddToCartButton();

        addedToCartMessageText = productsHelper.getAddedToCartMessageText();
        isContinueButtonDisplayed = productsHelper.isContinueButtonDisplayed();
        isGoToCartButtonDisplayed = productsHelper.isGoToCartButtonDisplayed();
    }

    @Test
    public void isAddedToCartMessageDisplayedTest() {
        Assertions.assertEquals(addedToCartMessageText, IConstants.onlinerAddedToCartMessage);
    }

    @Test
    public void isContinueButtonDisplayedTest() {
        Assertions.assertTrue(isContinueButtonDisplayed);
    }

    @Test
    public void isGoToCartButtonDisplayed() {
        Assertions.assertTrue(isGoToCartButtonDisplayed);
    }

    @Test
    public void isValueOfProductsChangedInShoppingCartTest() {
        productsHelper.clickCloseButton();
        Assertions.assertEquals(productsHelper.getAmountOfProductsInShoppingCart(), IConstants.valueAfterAddProductToCart);
    }
}