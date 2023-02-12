package ui.pages;

import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IntelyCareMainPage extends BasePage<IntelyCareMainPage> {

    private static final By intelyProTab = By.xpath("//div[@automation-id='click-intelypros-view']");
    private static final By pidField = By.xpath("//input[@name='pid']");
    private static final By searchButton = By.xpath("//button[@automation-id='button-intelypro-finder-search']");
    private static final By searchedResult = By.xpath("//div[@class='full-width']//mat-row");
    private static final By documentsTab = By.xpath("//div[@id='mat-tab-label-0-3']");

    @Step("Click intely pro tab")
    public IntelyCareMainPage clickIntelyProTab() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(intelyProTab))).click();
        return this;
    }

    @Step("Fill pid field with {0}")
    public IntelyCareMainPage fillPidField(String pid) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(pidField))).sendKeys(pid);
        return this;
    }

    @Step("Click search button")
    public IntelyCareMainPage clickSearchButton() throws InterruptedException {
        driver.findElement(searchButton).click();
        Thread.sleep(1000);
        return this;
    }

    @Step("Click searched result")
    public IntelyCareMainPage clickSearchedResult() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchedResult))).click();
        return this;
    }

    @Step("Click documents tab")
    public IntelyCareDocumentsPage clickDocumentsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(documentsTab))).click();
        return new IntelyCareDocumentsPage();
    }
}