package web.tests.onliner;

import listener.TestListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.IConstants;
import utils.PropertyReader;
import web.helpers.onliner.OnlinerHomeHelper;
import web.helpers.onliner.OnlinerProductsHelper;
import web.tests.CommonConditions;

@ExtendWith(TestListener.class)
public class CheckIfSearchedProductDisplayedTest extends CommonConditions {

    @Test
    public void isSearchedProductDisplayedTest() {
        OnlinerHomeHelper homeHelper = new OnlinerHomeHelper(driver);
        homeHelper.openPage(PropertyReader.getOnlinerUrl());
        OnlinerProductsHelper productsHelper = homeHelper.fillSearchField(IConstants.productNameForOnliner)
            .switchToProductsFrame()
            .clickFirstProduct();
        Assertions.assertEquals(productsHelper.getProductHeaderText(), IConstants.productNameForOnliner);
    }
}