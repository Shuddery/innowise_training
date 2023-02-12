package api.tests;

import api.AbstractService;
import api.models.IpCreationModel;
import api.models.user.LicType;
import api.models.LoginModel;
import api.models.qualification.QualificationTypesResponse;
import api.models.qualification.QualificationsResponseModel;
import api.models.user.UserRootModel;
import api.services.IntelyCareService;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import utils.EmailGenerator;
import utils.IConstants;

public class CheckIpRegisterWithParametersTest extends BaseApiTest {

    @Test
    public void checkIpRegisterWithParametersTest() {
        Response ipCreationResponse = IntelyCareService.registerNewIp(IpCreationModel.generate(EmailGenerator.generateEmail()
            , IConstants.apiPassword))
            .then()
            .extract().response();
        Response logInResponse = IntelyCareService.logIn(LoginModel.generate(IConstants.email, IConstants.password))
            .then()
            .extract().response();
        Response qualificationsResponse = IntelyCareService.getTypesOfUsersQualifications(
            AbstractService.getValue(logInResponse, IConstants.pathToAccessToken));
        QualificationsResponseModel qualificationsResponseModel = AbstractService.getModel(qualificationsResponse, QualificationsResponseModel.class);
        QualificationTypesResponse qualificationTypesResponse = qualificationsResponseModel.getData().get(IConstants.indexOfRN);
        LicType licType = new LicType();
        licType.setQualificationTypeId(qualificationTypesResponse.getQualificationTypeId());
        licType.setQualificationTypeKey(qualificationTypesResponse.getQualificationTypeKey());
        licType.setQualificationTypeLabel(qualificationTypesResponse.getQualificationTypeLabel());
        licType.setQualificationTypeName(qualificationTypesResponse.getQualificationTypeName());
        List<LicType> licTypes = new ArrayList<>();
        licTypes.add(licType);
        Response lastResponse = IntelyCareService.registerNewApiWithParameters(
            UserRootModel.generate(licTypes, AbstractService.getValue(ipCreationResponse, IConstants.pathToUid)),
            AbstractService.getValue(logInResponse, IConstants.pathToAccessToken));
        Assertions.assertEquals(AbstractService.getValue(lastResponse, "group.message"), "Success");
        Assertions.assertEquals(lastResponse.statusCode(), HttpStatus.SC_OK);
    }
}