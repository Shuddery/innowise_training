package ui.pages;

import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IntelyCareDocumentsPage extends BasePage<IntelyCareDocumentsPage> {

    private static final By uploadWindow = By.xpath("//div[@automation-id='click-upload-app-file']/input[@type='file']");
    private static final By fileName = By.xpath("//img[@class='preview']/following-sibling::p");
    private static final By uploadedFile = By.xpath("//section[@class='main-image']/img");
    private static final By ssnTypeOption = By.xpath("//div[@id='mat-select-value-57']");
    private static final By firstSsnType = By.xpath("//mat-option[@id='mat-option-509']");
    private static final By socialSecurityNumber = By.xpath("//input[@name='input_1']");
    private static final By uploadButton = By.xpath("//button[@automation-id='btn-submit-new-document']");
    private static final By uploadNewDocumentButton = By.xpath("//button[@automation-id='btn-edit-document-to-upload-new']");
    private static final By editWindowCloseButton = By.xpath("//mat-icon[@type='button']");
    private static final By expirationDateButton = By.xpath("(//mat-datepicker-toggle/button)[1]");
    private static final By expirationDay = By.xpath("//div[text()=' 25 ']/parent::button");
    private static final By stateSelect = By.xpath("//mat-select[@role='combobox']");
    private static final By firstState = By.xpath("//span[text()='Alabama']/..");
    private static final By issueDateButton = By.xpath("(//mat-datepicker-toggle/button)[2]");
    private static final By issueDay = By.xpath("//div[text()=' 27 ']/parent::button");
    private static final By selectedExpirationDate = By.xpath("//input[@name='input_0']");
    private static final By selectedState = By.xpath("//span[contains(@class, 'mat-select-min')]");
    private static final By selectedStatus = By.xpath("//mat-select[contains(@automation-id, 'input-2')]//span[contains(@class, 'mat-select-min')]");
    private static final By selectedIssueDate = By.xpath("//input[@name='input_2']");
    private static final By canvas = By.xpath("//canvas");
    private static final By saveSignatureButton = By.xpath("//button[@automation-id='btn-save-signature']");
    private static final By statusSelect = By.xpath("//mat-select[@automation-id='select-new-document-input-2']");
    private static final By firstStatus = By.xpath("//span[contains(@class, 'mat-option') and text()='Clear']");
    private static final By stateBackgroundCheckButton = By.xpath("//span[text()=' - AL']/parent::span[text()=' State Background Check']/..");
    private static final By statusOfStateBackground = By.xpath("(//span[text()=' - AL']/parent::span[text()=' State Background Check']/../../following-sibling::mat-cell)[1]");

    private static final String certainDocumentButton = "//span[text()='%s']/parent::button";
    private static final String statusOfCertainDocument = "(//span[text()='%s']/../../following-sibling::mat-cell)[1]";

    @Step("Add file with path {0}")
    public IntelyCareDocumentsPage addFile(String pathToFile) {
        WebElement webElement = driver.findElement(uploadWindow);
        String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
        ((JavascriptExecutor) driver).executeScript(js, webElement);
        webElement.sendKeys(pathToFile);
        return this;
    }

    @Step("Check if format of file is correct - {0}")
    public boolean isFormatOfFileIsCorrect(String format) {
        return findElement(fileName).getText().endsWith(format);
    }

    @Step("Click on certain document - {0}")
    public IntelyCareDocumentsPage clickCertainDocumentButton(String documentName) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(By.xpath(String.format(certainDocumentButton, documentName)))).click().perform();
        return this;
    }

    @Step("Click upload new document button")
    public IntelyCareDocumentsPage clickUploadNewDocumentButton() {
        wait.until(ExpectedConditions.elementToBeClickable(findElement(uploadNewDocumentButton))).click();
        return this;
    }

    @Step("Click upload button")
    public IntelyCareDocumentsPage clickUploadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(findElement(uploadButton))).click();
        return this;
    }

    @Step("Check if uploaded image is displayed")
    public boolean isUploadedImageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(findElement(uploadedFile))).isDisplayed();
    }

    @Step("Click close button in window edit")
    public IntelyCareDocumentsPage clickEditWindowCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(findElement(editWindowCloseButton))).click();
        return this;
    }

    @Step("Get status of certain document - {0}")
    public String getStatusOfCertainDocument(String documentName) {
        return wait.until(ExpectedConditions.visibilityOf
            (findElement(By.xpath(String.format(statusOfCertainDocument, documentName))))).getText().trim();
    }

    @Step("Draw signature")
    public IntelyCareDocumentsPage drawSignature() {
        Actions builder = new Actions(driver);
        builder.clickAndHold(findElement(canvas)).moveByOffset(10, 50).
            moveByOffset(50,10).
            moveByOffset(-10,-50).
            moveByOffset(-50,-10).release().perform();
        return this;
    }

    @Step("Click save signature button")
    public IntelyCareDocumentsPage clickSaveSignatureButton() {
        waitElementToBeClickable(findElement(saveSignatureButton)).click();
        return this;
    }

    @Step("Click expiration date button")
    public IntelyCareDocumentsPage clickExpirationDateButton() {
        waitElementToBeClickable(findElement(expirationDateButton)).click();
        return this;
    }

    @Step("Select expiration day")
    public IntelyCareDocumentsPage selectExpirationDay() {
        waitElementToBeClickable(findElement(expirationDay)).click();
        return this;
    }

    @Step("Click state select")
    public IntelyCareDocumentsPage clickStateSelect() {
        waitElementToBeClickable(findElement(stateSelect)).click();
        return this;
    }

    @Step("Select first state")
    public IntelyCareDocumentsPage selectFirstState() {
        waitElementToBeClickable(findElement(firstState)).click();
        return this;
    }

    @Step("Click issue date button")
    public IntelyCareDocumentsPage clickIssueDateButton() {
        waitElementToBeClickable(findElement(issueDateButton)).click();
        return this;
    }

    @Step("Select issue day")
    public IntelyCareDocumentsPage selectIssueDay() {
        waitElementToBeClickable(findElement(issueDay)).click();
        return this;
    }

    @Step("Get result of expiration date")
    public String getResultExpirationDate() {
        return waitVisibilityOfElement(findElement(selectedExpirationDate)).getAttribute("ng-reflect-model");
    }

    @Step("Get result of state")
    public String getResultState() {
        return waitVisibilityOfElement(findElement(selectedState)).getText();
    }

    @Step("Get result of issue date")
    public String getResultIssueDate() {
        return waitVisibilityOfElement(findElement(selectedIssueDate)).getAttribute("ng-reflect-model");
    }

    @Step("Click state background check button")
    public IntelyCareDocumentsPage clickStateBackgroundCheckButton() {
        waitElementToBeClickable(findElement(stateBackgroundCheckButton)).click();
        return this;
    }

    @Step("Click status select")
    public IntelyCareDocumentsPage clickStatusSelect() {
        waitElementToBeClickable(findElement(statusSelect)).click();
        return this;
    }

    @Step("Select first status")
    public IntelyCareDocumentsPage selectFirstStatus() {
        waitElementToBeClickable(findElement(firstStatus)).click();
        return this;
    }

    @Step("Get status of state background check")
    public String getStateBackgroundCheckStatus() {
        return waitVisibilityOfElement(findElement(statusOfStateBackground)).getText();
    }

    @Step("Get result of status")
    public String getResultStatus() {
        return waitVisibilityOfElement(findElement(selectedStatus)).getText();
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public WebElement waitElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitVisibilityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}