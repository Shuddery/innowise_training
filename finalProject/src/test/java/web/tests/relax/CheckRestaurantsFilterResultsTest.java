package web.tests.relax;

import listener.TestListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.IConstants;
import utils.PropertyReader;
import web.helpers.relax.RelaxFilterMenuHelper;
import web.helpers.relax.RelaxHomeHelper;
import web.tests.CommonConditions;

@ExtendWith(TestListener.class)
public class CheckRestaurantsFilterResultsTest extends CommonConditions {

    private static RelaxFilterMenuHelper filterHelper;

    @BeforeAll()
    public static void navigateToRelaxFilterMenu() {
        RelaxHomeHelper relaxHomeHelper = new RelaxHomeHelper(driver);
        relaxHomeHelper.openPage(PropertyReader.getRelaxUrl());
        filterHelper = relaxHomeHelper.clickFoodLink()
            .clickRestaurantsLink()
            .clickFilterButton();
    }

    @Test
    public void isDistrictNameOptionDisplayedTest() {
        filterHelper.clickDistrictDropdownFilter()
            .selectDistrictNameOption(IConstants.districtName);
        Assertions.assertEquals(filterHelper.getTextOfSelectedDistrict(), IConstants.districtName);
    }

    @Test
    public void isTakeawayFoodSelectedTest() {
        filterHelper.clickTakeawayFoodFilter();
        Assertions.assertTrue(filterHelper.isTakeawayFoodCheckboxSelected());
    }

    @Test
    public void isKitchenNameOptionSelectedTest() {
        filterHelper.clickKitchenButton()
            .selectKitchenNameOption(IConstants.kitchenName);
        Assertions.assertTrue(filterHelper.isKitchenNameOptionSelected(IConstants.kitchenName));
    }

    @Test
    public void isBackgroundColorOfConfirmOptionInTakeawayMenuWhiteTest() {
        filterHelper.selectConfirmOptionInTakeawayMenu();
        Assertions.assertTrue(filterHelper.isConfirmOptionInTakeawayMenuSelected());
    }
}