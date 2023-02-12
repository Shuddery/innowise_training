package api.tests;

import api.AbstractService;
import api.models.IpCreationModel;
import api.models.LoginModel;
import api.models.TermsModel;
import api.services.IntelyCareService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import utils.EmailGenerator;
import utils.IConstants;

public class CheckSuccessOfAcceptTermsTest {

    @Test
    public void checkSuccessOfAcceptTermsTest() {
        Response ipCreationResponse = IntelyCareService.registerNewIp(IpCreationModel.generate(EmailGenerator.generateEmail()
            , IConstants.apiPassword))
            .then()
            .extract().response();
        Response logInResponse = IntelyCareService.logIn(LoginModel.generate(IConstants.email, IConstants.password))
            .then()
            .extract().response();
        TermsModel termsModel = TermsModel.generate(AbstractService.getValue(ipCreationResponse, IConstants.pathToUid));
        Response termsOfServiceResponse = IntelyCareService.acceptTermsOfService(termsModel
                , AbstractService.getValue(logInResponse, IConstants.pathToAccessToken))
            .then()
            .extract().response();
        Assertions.assertEquals(
            AbstractService.getValue(termsOfServiceResponse, "message")
            , "Successfully accepted terms of service");
        Assertions.assertEquals(termsOfServiceResponse.statusCode(), HttpStatus.SC_OK);
    }
}