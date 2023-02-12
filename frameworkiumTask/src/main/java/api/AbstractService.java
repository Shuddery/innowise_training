package api;

import io.restassured.response.Response;

public class AbstractService {

    protected static final AppClient client = new AppClient();

    public static <T> T getModel(Response response, Class<T> tClass) {
        return response.as(tClass);
    }

    public static String getValue(Response response, String path) {
        return response.jsonPath().getString(path);
    }
}