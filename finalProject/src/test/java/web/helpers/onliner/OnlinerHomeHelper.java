package web.helpers.onliner;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import web.helpers.AbstractHelper;
import web.pages.onliner.OnlinerHomePage;

public class OnlinerHomeHelper extends AbstractHelper {

    public OnlinerHomeHelper(WebDriver driver) {
        super(driver);
    }

    @Step("Fill search field with product name")
    public OnlinerHomeHelper fillSearchField(String productName) {
        log.info("Fill search field with product name - " + productName);
        OnlinerHomePage.getSearchField(driver).sendKeys(productName);
        return this;
    }

    public OnlinerProductsHelper clickFirstProduct() {
        log.info("Click on the first product");
        OnlinerHomePage.getFirstProduct(driver).click();
        return new OnlinerProductsHelper(driver);
    }

    public OnlinerHomeHelper switchToProductsFrame() {
        log.info("Switch to the iframe");
        driver.switchTo().frame(OnlinerHomePage.getSearchedProductsIframe(driver));
        return this;
    }
}