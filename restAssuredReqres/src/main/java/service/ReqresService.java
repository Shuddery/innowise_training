package service;

import static io.restassured.RestAssured.given;

import api.AbstractService;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.GsonUtils;

public class ReqresService extends AbstractService {

    public static Response getListOfUsersWithQueryParameterPage(int page) {
        RequestSpecification requestSpecification = given()
            .basePath(USERS_ENDPOINT)
            .queryParam(QUERY_PARAM_PAGE, page);
        return client.reqresResponse(Method.GET, requestSpecification);
    }

    public static Response getSingleUserById(int id) {
        RequestSpecification requestSpecification = given()
            .basePath(USERS_ENDPOINT + "/" + id);
        return client.reqresResponse(Method.GET, requestSpecification);
    }

    public static Response getNonExistentSingleUser() {
        RequestSpecification requestSpecification = given()
            .basePath(USERS_ENDPOINT + "/23");
        return client.reqresResponse(Method.GET, requestSpecification);
    }

    public static Response getListOfResources() {
        RequestSpecification requestSpecification = given()
            .basePath(RESOURCE_ENDPOINT);
        return client.reqresResponse(Method.GET, requestSpecification);
    }

    public static Response getSingleResourceById(int id) {
        RequestSpecification requestSpecification = given()
            .basePath(RESOURCE_ENDPOINT + "/" + id);
        return client.reqresResponse(Method.GET, requestSpecification);
    }

    public static Response getNonExistentResource() {
        RequestSpecification requestSpecification = given()
            .basePath(RESOURCE_ENDPOINT + "/23");
        return client.reqresResponse(Method.GET, requestSpecification);
    }

    public static Response createUser(Object model) {
        RequestSpecification requestSpecification = given()
            .basePath(USERS_ENDPOINT)
            .body(GsonUtils.toJson(model));
        return client.reqresResponse(Method.POST, requestSpecification);
    }

    public static Response updateUserWithPutMethod(Object model) {
        RequestSpecification requestSpecification = given()
            .basePath(USERS_ENDPOINT + "/2")
            .body(GsonUtils.toJson(model));
        return client.reqresResponse(Method.PUT, requestSpecification);
    }

    public static Response updateUserWithPatchMethod(Object model) {
        RequestSpecification requestSpecification = given()
            .basePath(USERS_ENDPOINT + "/2")
            .body(GsonUtils.toJson(model));
        return client.reqresResponse(Method.PATCH, requestSpecification);
    }

    public static Response deleteUser() {
        RequestSpecification requestSpecification = given()
            .basePath(USERS_ENDPOINT + "/2");
        return client.reqresResponse(Method.DELETE, requestSpecification);
    }

    public static Response registerUser(Object model) {
        RequestSpecification requestSpecification = given()
            .basePath(REGISTER_ENDPOINT)
            .body(GsonUtils.toJson(model));
        return client.reqresResponse(Method.POST, requestSpecification);
    }

    public static Response loginInUser(Object model) {
        RequestSpecification requestSpecification = given()
            .basePath(LOGIN_ENDPOINT)
            .body(GsonUtils.toJson(model));
        return client.reqresResponse(Method.POST, requestSpecification);
    }

    public static Response getListOfUsersWithQueryParameterDelay(int delay) {
        RequestSpecification requestSpecification = given()
            .basePath(USERS_ENDPOINT)
            .queryParam(QUERY_PARAM_DELAY, delay);
        return client.reqresResponse(Method.GET, requestSpecification);
    }
}