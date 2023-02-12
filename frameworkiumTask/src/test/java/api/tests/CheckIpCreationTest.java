package api.tests;

import api.AbstractService;
import api.models.IpCreationModel;
import api.services.IntelyCareService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import utils.EmailGenerator;
import utils.IConstants;

public class CheckIpCreationTest extends BaseApiTest {

    @Test
    public void checkIpCreationTest() {
        Response response = IntelyCareService.registerNewIp(IpCreationModel.generate(EmailGenerator.generateEmail()
                , IConstants.apiPassword))
            .then()
            .extract().response();
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assertions.assertEquals(AbstractService.getValue(response, "code"), "200");
    }
}