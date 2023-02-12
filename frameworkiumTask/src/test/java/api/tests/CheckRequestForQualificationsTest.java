package api.tests;

import api.AbstractService;
import api.models.LoginModel;
import api.services.IntelyCareService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import utils.IConstants;

public class CheckRequestForQualificationsTest extends BaseApiTest {

    @Test
    public void checkRequestForTypesOfQualificationsTest() {
        Response logInResponse = IntelyCareService.logIn(LoginModel.generate(IConstants.email, IConstants.password))
            .then()
            .extract().response();
        Response response = IntelyCareService.getTypesOfUsersQualifications(AbstractService.getValue(logInResponse
            , IConstants.pathToAccessToken));
        Assertions.assertEquals(AbstractService.getValue(response, "isSuccess"), "true");
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }
}