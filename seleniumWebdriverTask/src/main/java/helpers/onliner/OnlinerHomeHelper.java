package helpers.onliner;

import helpers.AbstractHelper;
import helpers.heroku.FileUploadHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.onliner.OnlinerHomePage;
import utils.IConstants;

public class OnlinerHomeHelper extends AbstractHelper {

    public OnlinerHomeHelper(WebDriver driver) {
        super(driver);
    }

    public OnlinerHomeHelper openPage() {
        openOnlinerPage();
        return this;
    }

    public OnlinerHomeHelper fillSearchField(String criteria) {
        OnlinerHomePage.getSearchField(driver).sendKeys(criteria);
        return this;
    }

    public OnlinerHomeHelper switchToProductsFrame() {
        driver.switchTo().frame(OnlinerHomePage.getIFrame(driver));
        return this;
    }

    public String getFirstProductName() {
        return OnlinerHomePage.getFirstProductName(driver).getText();
    }

    public OnlinerHomeHelper clearSearchFieldInFrame() {
        OnlinerHomePage.getSearchFieldInFrame(driver).clear();
        return this;
    }

    public OnlinerHomeHelper fillSearchFieldInFrame(String criteria) {
        OnlinerHomePage.getSearchFieldInFrame(driver).sendKeys(criteria);
        return this;
    }

    public void clickOnFirstProduct() {
        OnlinerHomePage.getFirstProductName(driver).click();
    }

    public String getCaptionOfFirstProduct() {
        return OnlinerHomePage.getCaptionOfProduct(driver).getText();
    }

    public OnlinerHomeHelper scrollToEndOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", OnlinerHomePage.getFooterLogo(driver));
        return this;
    }
}