package api.service;

import api.AbstractService;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CatFactService extends AbstractService {

    public static Response getFact() {
        RequestSpecification requestSpecification = given()
            .basePath(FACT_ENDPOINT);
        return client.factsResponse(Method.GET, requestSpecification);
    }

    public static Response getFactWithQueryLengthParameter(int max_length) {
        RequestSpecification requestSpecification = given()
            .basePath(FACT_ENDPOINT)
            .queryParam(QUERY_PARAM_LENGTH, max_length);
        return client.factsResponse(Method.GET, requestSpecification);
    }

    public static Response getFacts() {
        RequestSpecification requestSpecification = given()
            .basePath(FACTS_ENDPOINT);
        return client.factsResponse(Method.GET, requestSpecification);
    }

    public static Response getFactsWithQueryLengthParameter(int max_length) {
        RequestSpecification requestSpecification = given()
            .basePath(FACTS_ENDPOINT)
            .queryParam(QUERY_PARAM_LENGTH, max_length);
        return client.factsResponse(Method.GET, requestSpecification);
    }

    public static Response getFactsWithQueryLimitParameter(int limit) {
        RequestSpecification requestSpecification = given()
            .basePath(FACTS_ENDPOINT)
            .queryParam(QUERY_PARAM_LIMIT, limit);
        return client.factsResponse(Method.GET, requestSpecification);
    }
}