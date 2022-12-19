package api;

import io.restassured.response.Response;

public class AbstractService {

    public static final String USERS_ENDPOINT = "users";
    public static final String RESOURCE_ENDPOINT = "unknown";
    public static final String REGISTER_ENDPOINT = "register";
    public static final String LOGIN_ENDPOINT = "login";
    public static final String QUERY_PARAM_PAGE = "page";
    public static final String QUERY_PARAM_DELAY = "delay";
    protected static final AppClient client = new AppClient();

    public static <T> T getModel(Response response, Class<T> tClass) {
        return response.as(tClass);
    }
}