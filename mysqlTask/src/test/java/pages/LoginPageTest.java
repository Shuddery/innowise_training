package pages;

import database.MySQLClient;
import helpers.LoginHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.IConstants;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPageTest extends CommonConditions {

    private LoginHelper loginHelper;
    private String username;
    private String password;

    {
        String queryToCorrectCredentials = "select * from user where first_name='tom'";
        ResultSet correctResultWithCredentials = MySQLClient.getResultSet(queryToCorrectCredentials);
        try {
            while (correctResultWithCredentials.next()) {
                username = correctResultWithCredentials.getString("first_name")
                    + correctResultWithCredentials.getString("last_name");
                password = correctResultWithCredentials.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeClass(alwaysRun = true)
    public void navigateToLoginPageTest() {
        loginHelper = new LoginHelper(driver);
        loginHelper.openHerokuPage(IConstants.loginEndpoint);
    }

    @Test
    public void checkErrorMessageWithEmptyPasswordFieldTest() {
        String messageWithEmptyPassword = loginHelper.fillLoginField(username)
            .clickLoginButton()
            .getMessageAfterCLickLoginButton();
        assertThat(messageWithEmptyPassword, Matchers.equalTo(IConstants.unsuccessfulLoginMessage));
    }

    @Test
    public void checkMessageWithCorrectDataTest() {
        String messageWithCorrectData = loginHelper.clearLoginField()
            .fillLoginField(username)
            .fillPasswordField(password)
            .clickLoginButton()
            .getMessageAfterCLickLoginButton();
        loginHelper.clickLogoutButton();
        assertThat(messageWithCorrectData, Matchers.equalTo(IConstants.successfulLoginMessage));
    }
}