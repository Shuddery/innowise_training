package api;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

public class AppClient {

    private static final String BASE_URI = PropertyReader.getIntelyCareApiUrl();

    public Response intelyCareResponse(Method method, RequestSpecification requestSpec) {
        requestSpec.baseUri(BASE_URI)
            .contentType(ContentType.JSON);
        return requestSpec.request(method);
    }
}