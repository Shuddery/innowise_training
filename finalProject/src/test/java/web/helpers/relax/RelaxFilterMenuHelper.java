package web.helpers.relax;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import web.helpers.AbstractHelper;
import web.pages.relax.RelaxFilterMenu;

public class RelaxFilterMenuHelper extends AbstractHelper {

    public RelaxFilterMenuHelper(WebDriver driver) {
        super(driver);
    }

    @Step("Click district dropdown filter")
    public RelaxFilterMenuHelper clickDistrictDropdownFilter() {
        RelaxFilterMenu.getDistrictDropdownFilter(driver).click();
        return this;
    }

    @Step("Select district name option")
    public RelaxFilterMenuHelper selectDistrictNameOption(String label) {
        log.info("Select district name option - " + label);
        RelaxFilterMenu.getDistrictNameOption(driver, label).click();;
        return this;
    }

    @Step("Get text of selected district")
    public String getTextOfSelectedDistrict() {
        log.info("Get text of selected district");
        return RelaxFilterMenu.getSelectedDistrict(driver).getText();
    }

    @Step("Click on takeaway food filter")
    public RelaxFilterMenuHelper clickTakeawayFoodFilter() {
        log.info("Click on takeaway food filter");
        RelaxFilterMenu.getTakeawayFoodFilter(driver).click();
        return this;
    }

    @Step("Check if takeaway food checkbox selected")
    public boolean isTakeawayFoodCheckboxSelected() {
        log.info("Check if takeaway food checkbox selected");
        return RelaxFilterMenu.getTakeawayFoodCheckbox(driver).isSelected();
    }

    @Step("Click kitchen button")
    public RelaxFilterMenuHelper clickKitchenButton() {
        log.info("Click kitchen button");
        RelaxFilterMenu.getKitchenButton(driver).click();
        return this;
    }

    @Step("Select kitchen name option")
    public RelaxFilterMenuHelper selectKitchenNameOption(String label) {
        log.info("Select kitchen name option - " + label);
        RelaxFilterMenu.getKitchenNameOption(driver, label).click();;
        return this;
    }

    @Step("Check if kitchen name option checkbox selected")
    public boolean isKitchenNameOptionSelected(String label) {
        log.info("Check if kitchen name option checkbox selected");
        return RelaxFilterMenu.getKitchenNameOptionCheckbox(driver, label).isSelected();
    }

    @Step("Select confirm option in takeaway menu")
    public RelaxFilterMenuHelper selectConfirmOptionInTakeawayMenu() {
        log.info("Select confirm option in takeaway menu");
        RelaxFilterMenu.getConfirmOptionInTakeawayMenu(driver).click();
        return this;
    }

    @Step("Check if confirm option checkbox in takeaway menu is selected")
    public boolean isConfirmOptionInTakeawayMenuSelected() {
        log.info("Check if confirm option checkbox in takeaway menu is selected");
        return RelaxFilterMenu.getConfirmOptionCheckboxInTakeawayMenu(driver).isSelected();
    }
}