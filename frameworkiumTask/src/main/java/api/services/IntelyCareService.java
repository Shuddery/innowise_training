package api.services;

import api.AbstractService;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.GsonUtils;

import static io.restassured.RestAssured.given;

public class IntelyCareService extends AbstractService {

    public static Response registerNewIp(Object model) {
        RequestSpecification requestSpecification = given()
            .basePath("/isystem/apply/register.php")
            .body(GsonUtils.toJson(model));
        return client.intelyCareResponse(Method.POST, requestSpecification);
    }

    public static Response logIn(Object model) {
        RequestSpecification requestSpecification = given()
            .basePath("/jwt/user/logon")
            .body(GsonUtils.toJson(model));
        return client.intelyCareResponse(Method.POST, requestSpecification);
    }

    public static Response getTypesOfUsersQualifications(String accessToken) {
        RequestSpecification requestSpecification = given()
            .basePath("/shift/management/qualificationtypes")
            .header("authorization", accessToken);
        return client.intelyCareResponse(Method.GET, requestSpecification);
    }

    public static Response registerNewApiWithParameters(Object model, String accessToken) {
        RequestSpecification requestSpecification = given()
            .basePath("/isystem/apply/register.php")
            .header("authorization", accessToken)
            .body(GsonUtils.toJson(model));
        return client.intelyCareResponse(Method.POST, requestSpecification);
    }

    public static Response acceptTermsOfService(Object model, String accessToken) {
        RequestSpecification requestSpecification = given()
            .basePath("/isystem/manage/acceptTermsOfService.php")
            .header("authorization", accessToken)
            .body(GsonUtils.toJson(model));
        return client.intelyCareResponse(Method.POST, requestSpecification);
    }

    public static Response acceptSms(String uid, String accessToken) {
        RequestSpecification requestSpecification = given()
            .basePath("/isystem/apply/get6DigitPIN.php")
            .queryParam("uid", uid)
            .header("authorization", accessToken);
        return client.intelyCareResponse(Method.GET, requestSpecification);
    }

    public static Response validateWithSms(Object model, String accessToken) {
        RequestSpecification requestSpecification = given()
            .basePath("/isystem/apply/register.php")
            .header("authorization", accessToken)
            .body(GsonUtils.toJson(model));
        return client.intelyCareResponse(Method.POST, requestSpecification);
    }

    public static Response setInterviewQuestions(Object model, String accessToken, String pid) {
        RequestSpecification requestSpecification = given()
            .basePath("/onboarding/interview/questions/" + pid)
            .header("authorization", accessToken)
            .body(GsonUtils.toJson(model));
        return client.intelyCareResponse(Method.POST, requestSpecification);
    }
}