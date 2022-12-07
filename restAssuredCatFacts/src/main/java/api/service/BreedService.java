package api.service;

import api.AbstractService;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BreedService extends AbstractService {

    public static Response getBreeds() {
        RequestSpecification requestSpecification = given()
            .basePath(BREEDS_ENDPOINT);
        return client.breedsResponse(Method.GET, requestSpecification);
    }

    public static Response getBreedsWithQueryLimitParameter(int limit) {
        RequestSpecification requestSpecification = given()
            .basePath(BREEDS_ENDPOINT)
            .queryParam(QUERY_PARAM_LIMIT, limit);
        return client.breedsResponse(Method.GET, requestSpecification);
    }
}