package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BookingHomePage;

public class BookingHomeSteps extends BaseSteps {
    public BookingHomeSteps(CommonConditions commonConditions) {
        super(commonConditions);
    }

    BookingHomePage bookingHomePage = new BookingHomePage(driver);

    @Given("user opens Booking page")
    public void openBookingHomepage() {
        bookingHomePage.openPage();
    }

    @When("user fills search with {string}")
    public void fillSearchWith(String hotel) {
        bookingHomePage.fillSearchField(hotel);
    }

    @And("user chooses hotel in search list")
    public void chooseHotelInSearchList() {
        bookingHomePage.chooseHotelInSearchListField();
    }

    @And("user clicks search button")
    public void clickSearchButton() {
        bookingHomePage.clickSearchButton();
    }

    @Then("{string} displayed in results page")
    public void checkThatTurinPalaceHotelDisplayedInResultsPage(String expected) {
        Assert.assertEquals(bookingHomePage.getFirstFoundHotelName(),  expected);
    }

    @And("amount of hotel stars equals {int}")
    public void amountOfStarsEquals(int expected) {
        Assert.assertEquals(bookingHomePage.getStarsAmountOfFirstFoundHotel(), expected);
    }
}