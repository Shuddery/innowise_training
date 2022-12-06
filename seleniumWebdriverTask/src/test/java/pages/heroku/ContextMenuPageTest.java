package pages.heroku;

import helpers.heroku.ContextMenuHelper;
import javax.swing.Icon;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import pages.CommonConditions;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContextMenuPageTest extends CommonConditions {

    @Test
    public void isAlertAppearAfterRightClickOnBoxTest() {
        ContextMenuHelper contextMenuHelper = new ContextMenuHelper(driver);
        String actualAlertText = contextMenuHelper.openPage()
            .rightClickOnBoxElement()
            .getTextOfAlert();
        contextMenuHelper.closeAlert();
        assertThat(actualAlertText, Matchers.equalTo(IConstants.alertTextInContextMenu));
    }
}