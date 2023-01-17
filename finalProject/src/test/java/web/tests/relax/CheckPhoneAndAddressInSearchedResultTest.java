package web.tests.relax;

import listener.TestListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.IConstants;
import utils.PropertyReader;
import web.helpers.relax.RelaxHomeHelper;
import web.tests.CommonConditions;

@ExtendWith(TestListener.class)
public class CheckPhoneAndAddressInSearchedResultTest extends CommonConditions {

    private static RelaxHomeHelper relaxHomeHelper;

    @BeforeAll
    public static void navigateToSearchedResult() {
        relaxHomeHelper = new RelaxHomeHelper(driver);
        relaxHomeHelper.openPage(PropertyReader.getRelaxUrl());
        relaxHomeHelper.fillSearchField(IConstants.placeName)
            .clickSearchedResult();
    }

    @Test
    public void isPhoneNumberInSearchedResultCorrectTest() {
        Assertions.assertEquals(relaxHomeHelper.getPhoneNumberOfSearchedResult(), IConstants.phoneNumberOfSearchedResult);
    }

    @Test
    public void isAddressInSearchedResultCorrectTest() {
        Assertions.assertEquals(relaxHomeHelper.getAddressOfSearchedResult(), IConstants.addressOfSearchedResult);
    }
}