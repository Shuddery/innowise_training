package pages.onliner;

import helpers.onliner.OnlinerHomeHelper;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import pages.CommonConditions;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class OnlinerHomePageTest extends CommonConditions {

    @Test
    public void isCaptionOfProductEqualsProductNameInSearchFieldTest() {
        OnlinerHomeHelper onlinerHomeHelper = new OnlinerHomeHelper(driver);
        String firstProductName = onlinerHomeHelper.openPage()
            .fillSearchField(IConstants.productName)
            .switchToProductsFrame()
            .getFirstProductName();
        onlinerHomeHelper.clearSearchFieldInFrame()
            .fillSearchFieldInFrame(firstProductName)
            .clickOnFirstProduct();
        assertThat(firstProductName, Matchers.equalTo(onlinerHomeHelper.getCaptionOfFirstProduct()));
    }
}