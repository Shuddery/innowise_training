package web.pages.relax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.AbstractPage;
import web.waits.Waits;

public class RelaxFilterMenu extends AbstractPage {

    private static final By districtDropdownFilter = By.xpath("//div[text()='Район']/following-sibling::div");
    private static final String districtNameOption = "//span[text()='%s']";
    private static final By selectedDistrict = By.xpath("//div[text()='Район']/following-sibling::div/span");
    private static final By takeawayFoodFilter = By.xpath("//span[text()='Еда навынос']");
    private static final By takeawayFoodCheckbox = By.xpath("//span[text()='Еда навынос']/preceding::input[@type='checkbox']");
    private static final By kitchenButton = By.xpath("//div[text()='Кухня']/following-sibling::div/div");
    private static final String kitchenNameOption = "//span[text()='%s']";
    private static final String kitchenNameOptionCheckbox = "//span[text()='%s']/preceding-sibling::input";
    private static final String confirmOption = "//div[text()='Меню навынос']/following-sibling::div//span[text()='Да']";
    private static final By confirmOptionInTakeawayMenu = By.xpath(confirmOption);
    private static final By confirmOptionCheckboxInTakeawayMenu = By.xpath(confirmOption + "/preceding-sibling::input");

    public static WebElement getDistrictDropdownFilter(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, districtDropdownFilter);
    }

    public static WebElement getDistrictNameOption(WebDriver driver, String label) {
        return Waits.waitVisibilityOfElementLocated(driver, By.xpath(String.format(districtNameOption, label)));
    }

    public static WebElement getSelectedDistrict(WebDriver driver) {
        return Waits.waitVisibilityOfElementLocated(driver, selectedDistrict);
    }

    public static WebElement getTakeawayFoodFilter(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, takeawayFoodFilter);
    }

    public static WebElement getTakeawayFoodCheckbox(WebDriver driver) {
        return getWebElement(driver, takeawayFoodCheckbox);
    }

    public static WebElement getKitchenButton(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, kitchenButton);
    }

    public static WebElement getKitchenNameOption(WebDriver driver, String label) {
        return Waits.waitElementToBeClickable(driver, By.xpath(String.format(kitchenNameOption, label)));
    }

    public static WebElement getKitchenNameOptionCheckbox(WebDriver driver, String label) {
        return getWebElement(driver, By.xpath(String.format(kitchenNameOptionCheckbox, label)));
    }

    public static WebElement getConfirmOptionInTakeawayMenu(WebDriver driver) {
        return Waits.waitElementToBeClickable(driver, confirmOptionInTakeawayMenu);
    }

    public static WebElement getConfirmOptionCheckboxInTakeawayMenu(WebDriver driver) {
        return getWebElement(driver, confirmOptionCheckboxInTakeawayMenu);
    }
}