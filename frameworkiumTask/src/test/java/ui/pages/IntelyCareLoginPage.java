package ui.pages;

import com.frameworkium.core.ui.UITestLifecycle;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import utils.PropertyReader;

public class IntelyCareLoginPage extends BasePage<IntelyCareLoginPage> {

    @Name("Password field")
    @Visible
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @Name("Login button")
    @Visible
    @FindBy(xpath = "//ic-root//button")
    private WebElement loginButton;

    private static final By emailField = By.xpath("//input[@type='email']");

    @Step("Open Intely care login page")
    public void open() {
        driver.get(PropertyReader.getIntelyCareUrl());
        UITestLifecycle.get().getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step("Fill email field with {0}")
    public IntelyCareLoginPage fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return PageFactory.newInstance(IntelyCareLoginPage.class);
    }

    @Step("Fill password field with {0}")
    public IntelyCareLoginPage fillPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Click login button")
    public IntelyCareMainPage clickLoginButton()  {
        loginButton.click();
        return new IntelyCareMainPage();
    }
}