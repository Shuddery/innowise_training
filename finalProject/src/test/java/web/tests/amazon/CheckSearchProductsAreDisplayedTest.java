package web.tests.amazon;

import listener.TestListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.IConstants;
import utils.PropertyReader;
import web.helpers.amazon.AmazonHomeHelper;
import web.helpers.amazon.AmazonProductsHelper;
import web.tests.CommonConditions;

@ExtendWith(TestListener.class)
public class CheckSearchProductsAreDisplayedTest extends CommonConditions {

    @Test
    public void isSearchProductDisplayedTest() {
        AmazonHomeHelper homeHelper = new AmazonHomeHelper(driver);
        homeHelper.openPage(PropertyReader.getAmazonUrl());
        AmazonProductsHelper productsHelper = homeHelper.fillSearchField(IConstants.productNameForAmazon)
            .clickSearchButton();
        Assertions.assertTrue(productsHelper.getFirstProductText().contains(IConstants.productNameForAmazon));
    }
}