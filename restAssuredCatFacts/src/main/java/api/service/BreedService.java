package api.service;

import api.AbstractService;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BreedService extends AbstractService {

    public static Response getBreeds() {
        RequestSpecification requestSpecification = given()
            .basePath("breeds");
        return client.factsResponse(Method.GET, requestSpecification);
    }

    public static Response getBreedsWithQueryLimitParameter(int limit) {
        RequestSpecification requestSpecification = given()
            .basePath("breeds")
            .queryParam("limit", limit);
        return client.factsResponse(Method.GET, requestSpecification);
    }
}