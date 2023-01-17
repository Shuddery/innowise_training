package web.pages.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.AbstractPage;
import web.waits.Waits;

public class OnlinerShoppingCartPage extends AbstractPage {
    private static final By cartHeader = By.xpath("//div[contains(@class, 'cart-form__title')]");
    private static final By addedToCartProduct = By.xpath("(//div[contains(@class, 'cart-form__desc')]/a)[2]");
    private static final By deleteIcon = By.xpath("(//div[@class='cart-form__control']/a)[1]");
    private static final By closeButton = By.xpath("//a[text()='Закрыть']");
    private static final By emptyShoppingCartMessage = By.xpath("//div[contains(@class, 'cart-message__title')]");

    public static WebElement getCartHeader(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, cartHeader);
    }

    public static WebElement getAddedToCartProduct(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, addedToCartProduct);
    }

    public static WebElement getDeleteIcon(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, deleteIcon);
    }

    public static WebElement getCloseButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, closeButton);
    }

    public static WebElement getEmptyShoppingCartMessage(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, emptyShoppingCartMessage);
    }
}