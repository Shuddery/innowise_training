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

    String messageWithEmptyPassword;
    String messageWithCorrectData;

    @BeforeClass(alwaysRun = true)
    public void navigateToLoginPageTest() {
        LoginHelper loginHelper = new LoginHelper(driver);
        Credentials credentials = new Credentials.Builder().setLogin(IConstants.correctUsername)
            .setPassword(IConstants.correctPassword)
            .build();
        messageWithEmptyPassword = loginHelper.openPage()
            .fillLoginField(credentials)
            .clickLoginButton()
            .getMessageAfterCLickLoginButton();
        messageWithCorrectData = loginHelper.clearLoginField()
            .fillLoginField(credentials)
            .fillPasswordField(credentials)
            .clickLoginButton()
            .getMessageAfterCLickLoginButton();
    }

    @Test
    @Owner("Galynin Vladislav")
    @Description("Checking error message text with empty password field")
    public void checkErrorMessageWithEmptyPasswordFieldTest() {
        assertThat(messageWithEmptyPassword, Matchers.equalTo(IConstants.unsuccessfulLoginMessage));
    }

    @Test
    @Owner("Galynin Vladislav")
    @Description("Checking successful message text with correct credentials")
    public void checkMessageWithCorrectDataTest() {
        assertThat(messageWithCorrectData, Matchers.equalTo(IConstants.successfulLoginMessage));
    }
}