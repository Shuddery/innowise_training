package web.tests.relax;

import listener.TestListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.PropertyReader;
import web.helpers.relax.RelaxAfishaHelper;
import web.helpers.relax.RelaxHomeHelper;
import web.tests.CommonConditions;

@ExtendWith(TestListener.class)
public class CheckSecondCardInfoTest extends CommonConditions {

    private static RelaxAfishaHelper relaxAfishaHelper;

    @BeforeAll()
    public static void navigateToSecondCardInAfishaPage() {
        RelaxHomeHelper homeHelper = new RelaxHomeHelper(driver);
        homeHelper.openPage(PropertyReader.getRelaxUrl());
        relaxAfishaHelper = homeHelper.clickAfishaLink()
            .clickCinemaCategoryLink()
            .clickSecondCardLink();
    }

    @Test
    public void isAdvertisementCategoryCorrectTest() {
        Assertions.assertTrue(
            relaxAfishaHelper.getCinemaCategory().equalsIgnoreCase(relaxAfishaHelper.getCategoryOfSecondCard()));
    }

    @Test
    public void isFeedbackSectionPresentedTest() {
        Assertions.assertTrue(relaxAfishaHelper.isFeedbackSectionPresented());
    }
}