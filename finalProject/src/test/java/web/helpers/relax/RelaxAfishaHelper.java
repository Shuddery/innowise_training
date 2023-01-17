package web.helpers.relax;

import org.openqa.selenium.WebDriver;
import web.helpers.AbstractHelper;
import web.pages.relax.RelaxAfishaPage;

public class RelaxAfishaHelper extends AbstractHelper {

    public RelaxAfishaHelper(WebDriver driver) {
        super(driver);
    }

    public RelaxAfishaHelper clickCinemaCategoryLink() {
        RelaxAfishaPage.getCinemaCategoryLink(driver).click();
        return this;
    }

    public RelaxAfishaHelper clickSecondCardLink() {
        RelaxAfishaPage.getSecondCardLink(driver).click();
        return this;
    }

    public String getCinemaCategory() {
        return RelaxAfishaPage.getCinemaCategoryLink(driver).getText();
    }

    public String getCategoryOfSecondCard() {
        return RelaxAfishaPage.getCategoryOfSecondCard(driver).getText();
    }

    public boolean isFeedbackSectionPresented() {
        return RelaxAfishaPage.getFeedbackSection(driver).isDisplayed();
    }
}