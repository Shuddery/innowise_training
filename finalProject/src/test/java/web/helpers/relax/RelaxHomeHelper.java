package web.helpers.relax;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.helpers.AbstractHelper;
import web.pages.relax.RelaxHomePage;

public class RelaxHomeHelper extends AbstractHelper {

    public RelaxHomeHelper(WebDriver driver) {
        super(driver);
    }

    @Step("Fill search field with place name")
    public RelaxHomeHelper fillSearchField(String placeName) {
        log.info("Fill search field with place name - " + placeName);
        RelaxHomePage.getSearchField(driver).sendKeys(placeName);
        return this;
    }

    @Step("Click searched result")
    public RelaxHomeHelper clickSearchedResult() {
        log.info("Click searched result");
        RelaxHomePage.getSearchedResult(driver).click();
        return this;
    }

    @Step("Get address of the searched result")
    public String getAddressOfSearchedResult() {
        log.info("Get address of searched result");
        return RelaxHomePage.getAddressOfSearchedResult(driver).getText();
    }

    @Step("Get phone number of searched result")
    public String getPhoneNumberOfSearchedResult() {
        log.info("Get phone number of searched result");
        return RelaxHomePage.getPhoneNumberOfSearchedResult(driver).getText();
    }

    @Step("Click work time button")
    public RelaxHomeHelper clickWorkTimeButton() {
        log.info("Click work time button");
        RelaxHomePage.getWorkTimeButton(driver).click();
        return this;
    }

    @Step("Get list of working hours")
    public List<WebElement> getWorkingHours() {
        log.info("Get list of working hours");
        return RelaxHomePage.getListOfWorkingHours(driver);
    }

    @Step("Click food link")
    public RelaxHomeHelper clickFoodLink() {
        log.info("Click food link");
        RelaxHomePage.getFoodLink(driver).click();
        return this;
    }

    @Step("Click restaurants link")
    public RelaxHomeHelper clickRestaurantsLink() {
        log.info("Click restaurants link");
        RelaxHomePage.getRestaurantsLink(driver).click();
        return this;
    }

    @Step("Click filter button")
    public RelaxFilterMenuHelper clickFilterButton() {
        log.info("Click filter button");
        RelaxHomePage.getFilterButton(driver).click();
        return new RelaxFilterMenuHelper(driver);
    }

    public RelaxAfishaHelper clickAfishaLink() {
        RelaxHomePage.getAfishaLink(driver).click();
        return new RelaxAfishaHelper(driver);
    }
}