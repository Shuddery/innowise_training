package web.helpers.amazon;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import web.helpers.AbstractHelper;
import web.pages.amazon.AmazonProductsPage;

public class AmazonProductsHelper extends AbstractHelper {

    public AmazonProductsHelper(WebDriver driver) {
        super(driver);
    }

    @Step("Get text of the first product")
    public String getFirstProductText() {
        log.info("Get text of the first product");
        return AmazonProductsPage.getFirstProduct(driver).getText();
    }

    @Step("Click on the first product")
    public AmazonProductsHelper clickFirstProduct() {
        log.info("Click on the first product");
        AmazonProductsPage.getFirstProduct(driver).click();
        return this;
    }

    @Step("Click add to cart button")
    public AmazonProductsHelper clickAddToCartButton() {
        log.info("Click add to cart button");
        AmazonProductsPage.getAddToCartButton(driver).click();
        return this;
    }

    @Step("Check if green icon is displayed")
    public boolean isGreenIconDisplayed() {
        log.info("Check if green icon is displayed");
        return AmazonProductsPage.getGreenIcon(driver).isDisplayed();
    }

    @Step("Check if picture of product is displayed")
    public boolean isPictureOfProductDisplayed() {
        log.info("Check if picture of product is displayed");
        return AmazonProductsPage.getPictureOfProduct(driver).isDisplayed();
    }

    @Step("Get text of add to cart message")
    public String getAddToCartMessageText() {
        log.info("Get text of add to cart message");
        return AmazonProductsPage.getAddToCartMessage(driver).getText();
    }

    public AmazonProductsHelper clickDeliverField() {
        log.info("Click on deliver field");
        AmazonProductsPage.getDeliverField(driver).click();
        return this;
    }

    @Step("Click on countries dropdown menu")
    public AmazonProductsHelper clickCountriesDropdownMenu() {
        log.info("Click on countries dropdown menu");
        AmazonProductsPage.getCountriesDropdownMenu(driver).click();
        return this;
    }

    @Step("Click on available delivery country")
    public AmazonProductsHelper clickAvailableDeliveryCountry() {
        log.info("Click on available delivery country");
        AmazonProductsPage.getAvailableDeliveryCountry(driver).click();
        return this;
    }

    @Step("Click on done button")
    public AmazonProductsHelper clickDoneButton() {
        log.info("Click on done button");
        AmazonProductsPage.getDoneButton(driver).click();
        return this;
    }

    @Step("Click on cart button")
    public AmazonShoppingCartHelper clickCartButton() {
        log.info("Click on cart button");
        AmazonProductsPage.getCartButton(driver).click();
        return new AmazonShoppingCartHelper(driver);
    }
}