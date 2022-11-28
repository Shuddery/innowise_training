package pages.onliner;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import pages.CommonConditions;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class OnlinerHomePageTest extends CommonConditions {

    @Test
    public void isCaptionOfProductEqualsProductNameInSearchFieldTest() {
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage(driver);
        String firstProductName = onlinerHomePage.openPage()
            .fillSearchField(IConstants.productName)
            .switchToProductsFrame()
            .getFirstProductName();
        onlinerHomePage.clearSearchFieldInFrame()
            .fillSearchFieldInFrame(firstProductName)
            .clickOnFirstProduct();
        assertThat(firstProductName, Matchers.equalTo(onlinerHomePage.getCaptionOfFirstProduct()));
    }
}