package api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class Services {
    public static Response getRequest(String endpoint){
        return given()
            .when()
            .get(endpoint);
    }

    public static Response postRequest(String endpoint, Object model) {
        return given()
            .body(model)
            .when()
            .post(endpoint);
    }

    public static Response putRequest(String endpoint, Object model) {
        return given()
            .body(model)
            .when()
            .put(endpoint);
    }

    public static Response patchRequest(String endpoint, Object model) {
        return given()
            .body(model)
            .when()
            .patch(endpoint);
    }

    public static Response deleteRequest(String endpoint){
        return given()
            .when()
            .delete(endpoint);
    }

}