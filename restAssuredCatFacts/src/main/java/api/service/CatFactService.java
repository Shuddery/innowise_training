package api.service;

import api.AbstractService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CatFactService extends AbstractService {

   @Step("Get request to /" + FACT_ENDPOINT)
    public static Response getFact() {
        log.info("Get request to /" + FACT_ENDPOINT);
        RequestSpecification requestSpecification = given()
            .basePath(FACT_ENDPOINT);
        return client.factsResponse(Method.GET, requestSpecification);
    }

    @Step("Get request with query max_length parameter to /" + FACT_ENDPOINT)
    public static Response getFactWithQueryLengthParameter(int max_length) {
        log.info("Get request with query max_length parameter to /" + FACT_ENDPOINT);
        RequestSpecification requestSpecification = given()
            .basePath(FACT_ENDPOINT)
            .queryParam(QUERY_PARAM_LENGTH, max_length);
        return client.factsResponse(Method.GET, requestSpecification);
    }

    @Step("Get request to /" + FACTS_ENDPOINT)
    public static Response getFacts() {
        log.info("Get request to /" + FACTS_ENDPOINT);
        RequestSpecification requestSpecification = given()
            .basePath(FACTS_ENDPOINT);
        return client.factsResponse(Method.GET, requestSpecification);
    }

    @Step("Get request with query max_length parameter to /" + FACTS_ENDPOINT)
    public static Response getFactsWithQueryLengthParameter(int max_length) {
        log.info("Get request with query max_length parameter to /" + FACTS_ENDPOINT);
        RequestSpecification requestSpecification = given()
            .basePath(FACTS_ENDPOINT)
            .queryParam(QUERY_PARAM_LENGTH, max_length);
        return client.factsResponse(Method.GET, requestSpecification);
    }

    @Step("Get request with query limit parameter to /" + FACTS_ENDPOINT)
    public static Response getFactsWithQueryLimitParameter(int limit) {
        log.info("Get request with query limit parameter to /" + FACTS_ENDPOINT);
        RequestSpecification requestSpecification = given()
            .basePath(FACTS_ENDPOINT)
            .queryParam(QUERY_PARAM_LIMIT, limit);
        return client.factsResponse(Method.GET, requestSpecification);
    }
}