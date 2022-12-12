package pages;

import builder.Credentials;
import helpers.LoginHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import listener.TestListener;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import waits.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

@Listeners(TestListener.class)
public class LoginPageTest extends CommonConditions {

    Credentials credentials = new Credentials.Builder().setLogin(IConstants.correctUsername)
        .setPassword(IConstants.correctPassword)
        .build();
    LoginHelper loginHelper;

    @BeforeClass(alwaysRun = true)
    public void navigateToLoginPageTest() {
        loginHelper = new LoginHelper(driver);
        loginHelper.openHerokuPage(IConstants.loginEndpoint);
    }

    @Test
    @Owner("Galynin Vladislav")
    @Description("Checking error message text with empty password field")
    public void checkErrorMessageWithEmptyPasswordFieldTest() {
        String messageWithEmptyPassword = loginHelper.fillLoginField(credentials)
            .clickLoginButton()
            .getMessageAfterCLickLoginButton();
        assertThat(messageWithEmptyPassword, Matchers.equalTo(IConstants.unsuccessfulLoginMessage));
    }

    @Test
    @Owner("Galynin Vladislav")
    @Description("Checking successful message text with correct credentials")
    public void checkMessageWithCorrectDataTest() {
        String messageWithCorrectData = loginHelper.clearLoginField()
            .fillLoginField(credentials)
            .fillPasswordField(credentials)
            .clickLoginButton()
            .getMessageAfterCLickLoginButton();
        loginHelper.clickLogoutButton();
        assertThat(messageWithCorrectData, Matchers.equalTo(IConstants.successfulLoginMessage));
    }
}