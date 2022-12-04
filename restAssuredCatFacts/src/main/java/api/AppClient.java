package api;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppClient {

    public Response factsResponse(Method method, RequestSpecification requestSpec) {
        requestSpec.baseUri("https://catfact.ninja/")
            .contentType(ContentType.JSON);
        return requestSpec.request(method);
    }

    public Response breedsResponse(Method method, RequestSpecification requestSpec) {
        requestSpec.baseUri("https://catfact.ninja/breeds")
            .contentType(ContentType.JSON);
        return requestSpec.request(method);
    }
}