package pages.heroku;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import pages.CommonConditions;
import utils.IConstants;
import utils.TestProperties;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContextMenuPageTest extends CommonConditions {

    @Test
    public void isAlertAppearAfterRightClickOnBoxTest() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        String actualAlertText = contextMenuPage.openPage()
            .rightClickOnBoxElement()
            .getTextOfAlert();
        contextMenuPage.closeAlert();
        assertThat(actualAlertText, Matchers.equalTo(IConstants.alertTextInContextMenu));
    }
}