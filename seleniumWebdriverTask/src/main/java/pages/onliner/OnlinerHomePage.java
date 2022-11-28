package pages.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.EnvironmentConfig;
import waits.Waits;

public class OnlinerHomePage {

    protected WebDriver driver;
    private static final String URL = "https://www.onliner.by/";
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
        driver.findElement(searchFieldLocator).sendKeys(criteria);
        return this;
    }

    public OnlinerHomePage switchToProductsFrame() {
        driver.switchTo().frame(driver.findElement(iFrameLocator));
        return this;
    }

    public String getFirstProductName() {
        return Waits.waitVisibilityOfElementLocated(driver, firstProductNameLocator).getText();
    }

    public OnlinerHomePage clearSearchFieldInFrame() {
        driver.findElement(searchFieldInFrameLocator).clear();
        return this;
    }

    public OnlinerHomePage fillSearchFieldInFrame(String criteria) {
        driver.findElement(searchFieldInFrameLocator).sendKeys(criteria);
        return this;
    }

    public void clickOnFirstProduct() {
        driver.findElement(firstProductNameLocator).click();
    }

    public String getCaptionOfFirstProduct() {
        return driver.findElement(captionOfProductLocator).getText();
    }

    public OnlinerHomePage scrollToEndOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Waits.waitVisibilityOfElementLocated(driver, footerLogoLocator));
        return this;
    }
 }