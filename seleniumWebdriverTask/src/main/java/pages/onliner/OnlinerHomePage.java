package pages.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;
import utils.TestProperties;
import waits.Waits;

public class OnlinerHomePage extends AbstractPage {

    protected WebDriver driver;
    private static final String URL = TestProperties.getOnlinerUrl();
    private static final By searchFieldLocator = By.xpath("//input[contains(@class, 'fast-search')]");
    private static final By iFrameLocator = By.xpath("//iframe[@class='modal-iframe']");
    private static final By firstProductNameLocator = By.xpath("(//div[contains(@class, 'product__title')]/a)[1]");
    private static final By searchFieldInFrameLocator = By.xpath("//div[@class='search__bar-wrapper']/input");
    private static final By captionOfProductLocator = By.xpath("//h1[contains(@class, 'catalog')]");
    private static final By footerLogoLocator = By.xpath("//div[@class='footer-style__logo']");

    public OnlinerHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public OnlinerHomePage openPage() {
        driver.get(URL);
        return this;
    }

    public OnlinerHomePage fillSearchField(String criteria) {
        getWebElement(driver, searchFieldLocator).sendKeys(criteria);
        return this;
    }

    public OnlinerHomePage switchToProductsFrame() {
        driver.switchTo().frame(getWebElement(driver, iFrameLocator));
        return this;
    }

    public String getFirstProductName() {
        return Waits.waitVisibilityOfElementLocated(driver, firstProductNameLocator).getText();
    }

    public OnlinerHomePage clearSearchFieldInFrame() {
        getWebElement(driver, searchFieldInFrameLocator).clear();
        return this;
    }

    public OnlinerHomePage fillSearchFieldInFrame(String criteria) {
        getWebElement(driver, searchFieldInFrameLocator).sendKeys(criteria);
        return this;
    }

    public void clickOnFirstProduct() {
        getWebElement(driver, firstProductNameLocator).click();
    }

    public String getCaptionOfFirstProduct() {
         return getWebElement(driver, captionOfProductLocator).getText();
    }

    public OnlinerHomePage scrollToEndOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Waits.waitVisibilityOfElementLocated(driver, footerLogoLocator));
        return this;
    }
 }