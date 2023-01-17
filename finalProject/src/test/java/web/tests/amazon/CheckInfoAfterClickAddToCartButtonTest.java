package web.tests.amazon;

import listener.TestListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.IConstants;
import utils.PropertyReader;
import web.helpers.amazon.AmazonHomeHelper;
import web.helpers.amazon.AmazonProductsHelper;
import web.tests.CommonConditions;

@ExtendWith(TestListener.class)
public class CheckInfoAfterClickAddToCartButtonTest extends CommonConditions {

    private static AmazonProductsHelper productsHelper;

    @BeforeAll
    public static void selectFirstProductAndClickAddToCartButton() {
        AmazonHomeHelper homeHelper = new AmazonHomeHelper(driver);
        homeHelper.openPage(PropertyReader.getAmazonUrl());
        productsHelper = homeHelper.fillSearchField(IConstants.productNameForAmazon)
            .clickSearchButton()
            .clickFirstProduct()
            .clickDeliverField()
            .clickCountriesDropdownMenu()
            .clickAvailableDeliveryCountry()
            .clickDoneButton()
            .clickAddToCartButton();
    }

    @Test
    public void isGreenIconDisplayedTest() {
        Assertions.assertTrue(productsHelper.isGreenIconDisplayed());
    }

    @Test
    public void isAddedToCartMessageDisplayedTest() {
        Assertions.assertEquals(productsHelper.getAddToCartMessageText(), IConstants.amazonAddedToCartMessage);
    }

    @Test
    public void isPictureOfProductDisplayedTest() {
        Assertions.assertTrue(productsHelper.isPictureOfProductDisplayed());
    }
}