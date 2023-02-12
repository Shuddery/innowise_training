package api.tests;

import api.AbstractService;
import api.models.interview.InterviewQuestionRoot;
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
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import utils.EmailGenerator;
import utils.IConstants;

public class CheckInterviewQuestionsTest extends BaseApiTest {

    @Test
    public void checkInterviewQuestionsTest() {
        String email = EmailGenerator.generateEmail();
        Response newApiResponse = IntelyCareService.registerNewIp(
                IpCreationModel.generate(email, IConstants.apiPassword))
            .then()
            .extract().response();
        String uid = AbstractService.getValue(newApiResponse, IConstants.pathToUid);

        Response logInResponse = IntelyCareService.logIn(LoginModel.generate(email, IConstants.apiPassword))
            .then()
            .extract().response();
        String accessToken = AbstractService.getValue(logInResponse, IConstants.pathToAccessToken);

        Response response = IntelyCareService.getTypesOfUsersQualifications(accessToken);
        QualificationsResponseModel responseModel = AbstractService.getModel(response, QualificationsResponseModel.class);
        QualificationTypesResponse qualificationTypesResponse = responseModel.getData().get(IConstants.indexOfRN);
        LicType licType = new LicType();
        licType.setQualificationTypeId(qualificationTypesResponse.getQualificationTypeId());
        licType.setQualificationTypeKey(qualificationTypesResponse.getQualificationTypeKey());
        licType.setQualificationTypeLabel(qualificationTypesResponse.getQualificationTypeLabel());
        licType.setQualificationTypeName(qualificationTypesResponse.getQualificationTypeName());
        List<LicType> licTypes = new ArrayList<>();
        licTypes.add(licType);
        Response registerWithQualificationResponse = IntelyCareService.registerNewApiWithParameters(UserRootModel.generate(licTypes, uid), accessToken)
                .then()
                .extract().response();
        String pid = AbstractService.getValue(registerWithQualificationResponse, IConstants.pathToPid);
        Response lastResponse = IntelyCareService.setInterviewQuestions(
            InterviewQuestionRoot.generate(IConstants.state),
            accessToken,
            pid);
        Assertions.assertEquals(AbstractService.getValue(lastResponse, "message"), "Success");
    }
}