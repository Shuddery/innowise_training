package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.EnvironmentConfig;

public class ContextMenuPage {

    protected WebDriver driver;
    private static final String URL = EnvironmentConfig.herokuAppUrl + "context_menu";
    private static final By boxLocator = By.xpath("//div[@id='hot-spot']");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public ContextMenuPage openPage() {
        driver.get(URL);
        return this;
    }

    public ContextMenuPage rightClickOnBox() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(boxLocator)).perform();
        return this;
    }

    public String getTextOfAlert() {
        return driver.switchTo().alert().getText();
    }

    public void closeAlert() {
        driver.switchTo().alert().accept();
    }
}