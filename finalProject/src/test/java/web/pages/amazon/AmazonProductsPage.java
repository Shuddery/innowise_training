package web.pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.AbstractPage;
import web.waits.Waits;

public class AmazonProductsPage extends AbstractPage {
    private static final By firstProduct = By.xpath("(//a[contains(@class, 'a-link')]/span[contains(@class, 'a-size')])[1]");
    private static final By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");
    private static final By greenIcon = By.xpath("//div[@id='attach-added-to-cart-message']//i");
    private static final By pictureOfProduct = By.xpath("//div[@class='huc-image-wrapper']//img");
    private static final By addToCartMessage = By.xpath("//div[@id='attachDisplayAddBaseAlert']//h4");
    private static final By deliverField = By.xpath("//div[@id='cipInsideDeliveryBlock_feature_div']");
    private static final By countriesDropdownMenu = By.xpath("//div[@class=' a-declarative']");
    private static final By availableDeliveryCountry = By.xpath("//a[text()='Belgium']");
    private static final By doneButton = By.xpath("//button[@name='glowDoneButton']");
    private static final By cartButton = By.xpath("//span[@id='attach-sidesheet-view-cart-button']//input");

    public static WebElement getFirstProduct(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, firstProduct);
    }

    public static WebElement getAddToCartButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, addToCartButton);
    }

    public static WebElement getGreenIcon(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, greenIcon);
    }

    public static WebElement getPictureOfProduct(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, pictureOfProduct);
    }

    public static WebElement getAddToCartMessage(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, addToCartMessage);
    }

    public static WebElement getDeliverField(WebDriver driver) {
        return getWebElement(driver, deliverField);
    }

    public static WebElement getCountriesDropdownMenu(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, countriesDropdownMenu);
    }

    public static WebElement getAvailableDeliveryCountry(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, availableDeliveryCountry);
    }

    public static WebElement getDoneButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, doneButton);
    }

    public static WebElement getCartButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, cartButton);
    }
}