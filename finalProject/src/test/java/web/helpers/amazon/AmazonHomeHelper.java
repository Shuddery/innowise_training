package web.helpers.amazon;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import web.helpers.AbstractHelper;
import web.pages.amazon.AmazonHomePage;

public class AmazonHomeHelper extends AbstractHelper {

    public AmazonHomeHelper(WebDriver driver) {
        super(driver);
    }

    @Step("Fill search field with product name")
    public AmazonHomeHelper fillSearchField(String productName) {
        log.info("Fill search field with product name - " + productName);
        AmazonHomePage.getSearchField(driver).sendKeys(productName);
        return this;
    }

    @Step("Click search button")
    public AmazonProductsHelper clickSearchButton() {
        log.info("Click search button");
        AmazonHomePage.getSearchButton(driver).click();
        return new AmazonProductsHelper(driver);
    }
}