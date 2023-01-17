package web.pages.relax;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.AbstractPage;
import web.waits.Waits;

public class RelaxHomePage extends AbstractPage {
    private static final By searchField = By.xpath("//input[@id='search_open']");
    private static final By searchedResult = By.xpath("//div[text()='Рестобар']");
    private static final By addressOfSearchedResult = By.xpath("//button[contains(@class, 'PersonalContacts__address')]//span");
    private static final By phoneNumberOfSearchedResult = By.xpath("//a[@class='PhoneLink']/descendant::span[@class='Button__phone']");
    private static final By workTimeButton = By.xpath("//button[contains(@class, 'PersonalContacts__worktime')]");
    private static final By workingHours = By.xpath("//div[@class='ContactsPopupOpening__subMain']");
    private static final By foodLink = By.xpath("//div[contains(@class, 'Categories') and text()='Еда']");
    private static final By restaurantsLink = By.xpath("//a[text()='Рестораны']");
    private static final By filterButton = By.xpath("//div[contains(@class, 'FilterToolbar__allFiltersButton')]");
    private static final By afishaLink = By.xpath("//a[contains(@class, 'Categories') and @title='Афиша, кино']");

    public static WebElement getSearchField(WebDriver driver) {
        return getWebElement(driver, searchField);
    }

    public static WebElement getSearchedResult(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, searchedResult);
    }

    public static WebElement getAddressOfSearchedResult(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, addressOfSearchedResult);
    }

    public static WebElement getPhoneNumberOfSearchedResult(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, phoneNumberOfSearchedResult);
    }

    public static WebElement getWorkTimeButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, workTimeButton);
    }

    public static List<WebElement> getListOfWorkingHours(WebDriver driver) {
        return Waits.waitPresenceOfAllElementsLocated(driver, workingHours);
    }

    public static WebElement getFoodLink(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, foodLink);
    }

    public static WebElement getRestaurantsLink(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, restaurantsLink);
    }

    public static WebElement getFilterButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, filterButton);
    }

    public static WebElement getAfishaLink(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, afishaLink);
    }
}