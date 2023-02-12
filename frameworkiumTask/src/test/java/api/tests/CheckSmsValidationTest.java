package api.tests;

import api.AbstractService;
import api.models.IpCreationModel;
import api.models.LoginModel;
import api.models.SmsValidationModel;
import api.services.IntelyCareService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import utils.EmailGenerator;
import utils.IConstants;

public class CheckSmsValidationTest extends BaseApiTest {

    @Test
    public void checkSmsValidationTest() {
        String email = EmailGenerator.generateEmail();
        Response newApiResponse = IntelyCareService.registerNewIp(
                IpCreationModel.generate(email, IConstants.apiPassword))
            .then()
            .extract().response();
        String uid = AbstractService.getValue(newApiResponse, IConstants.pathToUid);
        System.out.println(uid);

        Response logInResponse = IntelyCareService.logIn(LoginModel.generate(email, IConstants.apiPassword))
            .then()
            .extract().response();
        String accessToken = AbstractService.getValue(logInResponse, IConstants.pathToAccessToken);

        Response smsRequestResponse = IntelyCareService.acceptSms(uid, accessToken)
            .then()
            .extract().response();
        String smsCode = AbstractService.getValue(smsRequestResponse, IConstants.pathToSmsCode);

        Response smsValidationResponse = IntelyCareService.validateWithSms(
                SmsValidationModel.generate(uid, smsCode), accessToken)
            .then()
            .extract().response();
        Assertions.assertEquals(smsValidationResponse.statusCode(), HttpStatus.SC_OK);
    }
}