package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import waits.Waits;

public class BookingHomePage extends AbstractPage {

    private static final By searchFieldLocator = By.xpath("//input[@name='ss']");
    private static final By hotelInSearchListLocator = By.xpath("(//div[@role='button'])[1]");
    private static final By searchButtonLocator = By.xpath("//button[@type='submit']");
    private static final By firstFoundHotelLocator = By.xpath("(//div[@data-testid='title'])[1]");
    private static final By starsAmountOfFirstFoundHotelLocator = By.xpath("(//div[@data-testid='rating-stars'])[1]/span");

    public BookingHomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void fillSearchField(String hotelName) {
        driver.findElement(searchFieldLocator).sendKeys(hotelName);
    }

    public void chooseHotelInSearchListField() {
        Waits.waitElementToBeClickable(driver, hotelInSearchListLocator).click();
    }

    public void clickSearchButton() {
        Waits.waitElementToBeClickable(driver, searchButtonLocator).click();
    }

    public String getFirstFoundHotelName() {
        return Waits.waitVisibilityOfElementLocated(driver, firstFoundHotelLocator).getText();
    }

    public int getStarsAmountOfFirstFoundHotel() {
        return driver.findElements(starsAmountOfFirstFoundHotelLocator).size();
    }
}