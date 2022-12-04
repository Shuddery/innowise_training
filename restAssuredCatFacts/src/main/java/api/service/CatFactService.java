package api.service;

import api.AbstractService;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CatFactService extends AbstractService {

    public static Response getFact() {
        RequestSpecification requestSpecification = given()
            .basePath("fact");
        return client.factsResponse(Method.GET, requestSpecification);
    }

    public static Response getFactWithQueryLengthParameter(int max_length) {
        RequestSpecification requestSpecification = given()
            .basePath("fact")
            .queryParam("max_length", max_length);
        return client.factsResponse(Method.GET, requestSpecification);
    }

    public static Response getFacts() {
        RequestSpecification requestSpecification = given()
            .basePath("facts");
        return client.factsResponse(Method.GET, requestSpecification);
    }

    public static Response getFactsWithQueryLengthParameter(int max_length) {
        RequestSpecification requestSpecification = given()
            .basePath("facts")
            .queryParam("max_length", max_length);
        return client.factsResponse(Method.GET, requestSpecification);
    }

    public static Response getFactsWithQueryLimitParameter(int limit) {
        RequestSpecification requestSpecification = given()
            .basePath("facts")
            .queryParam("limit", limit);
        return client.factsResponse(Method.GET, requestSpecification);
    }
}