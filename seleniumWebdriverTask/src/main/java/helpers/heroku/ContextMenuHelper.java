package helpers.heroku;

import helpers.AbstractHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.heroku.ContextMenuPage;
import utils.IConstants;

public class ContextMenuHelper extends AbstractHelper {

    public ContextMenuHelper(WebDriver driver) {
        super(driver);
    }

    public ContextMenuHelper openPage() {
        openHerokuPage(IConstants.contextMenuEndpoint);
        return this;
    }

    public ContextMenuHelper rightClickOnBoxElement() {
        Actions actions = new Actions(driver);
        actions.contextClick(ContextMenuPage.getBoxElement(driver)).perform();
        return this;
    }

    public String getTextOfAlert() {
        return switchToAlert(driver).getText();
    }

    public void closeAlert() {
        switchToAlert(driver).dismiss();
    }
}