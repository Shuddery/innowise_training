package web.tests.relax;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import listener.TestListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebElement;
import utils.IConstants;
import utils.PropertyReader;
import web.helpers.relax.RelaxHomeHelper;
import web.tests.CommonConditions;

@ExtendWith(TestListener.class)
public class CheckWorkingHoursInSearchedResultTest extends CommonConditions {

    private static RelaxHomeHelper relaxHomeHelper;

    @BeforeAll()
    public static void navigateToSearchedResultAndClickWorkTimeButton() {
        relaxHomeHelper = new RelaxHomeHelper(driver);
        relaxHomeHelper.openPage(PropertyReader.getRelaxUrl());
        relaxHomeHelper.fillSearchField(IConstants.placeName)
            .clickSearchedResult()
            .clickWorkTimeButton();
    }

    @ParameterizedTest
    @MethodSource("workingHoursProvider")
    public void isWorkingTimeScheduleCorrectTest(List<String> expectedWorkingHours) {
        List<WebElement> listOfWorkingHours = relaxHomeHelper.getWorkingHours();
        List<String> actualWorkingHours = listOfWorkingHours.stream().map(WebElement::getText).collect(
            Collectors.toList());
        Assertions.assertEquals(expectedWorkingHours, actualWorkingHours);
    }

    private static Stream<Arguments> workingHoursProvider() {
        return Stream.of(
            Arguments.arguments(List.of(
                "12:00—00:00",
                "12:00—00:00",
                "12:00—00:00",
                "12:00—00:00",
                "12:00—02:00",
                "14:00—02:00",
                "14:00—00:00"))
        );
    }
}