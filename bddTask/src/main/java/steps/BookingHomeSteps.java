package steps;

import driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BookingHomePage;
import utils.TestProperties;

public class BookingHomeSteps {

    protected WebDriver driver = DriverSingleton.getDriver(TestProperties.getChromeBrowser());

    BookingHomePage bookingHomePage = new BookingHomePage(driver);

    @Given("user opens {string} using Chrome")
    public void openBookingHomepage(String url) {
        bookingHomePage.openPage(url);
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

    @After
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}