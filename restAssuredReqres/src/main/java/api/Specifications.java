package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.asynchttpclient.RequestBuilder;

public class Specifications {
    public static RequestSpecification requestSpec(String url){
        return new RequestSpecBuilder()
            .setBaseUri(url)
            .setContentType(ContentType.JSON)
            .build();
    }

    public static ResponseSpecification responseSpec(int statusCode){
        return new ResponseSpecBuilder()
            .expectStatusCode(statusCode)
            .build();
    }

    public static void installSpecifications(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
