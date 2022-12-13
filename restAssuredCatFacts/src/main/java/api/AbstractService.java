package api;

import io.restassured.response.Response;
import org.apache.log4j.Logger;

public class AbstractService {

    protected static final Logger log = Logger.getLogger(AbstractService.class);
    public static final String FACT_ENDPOINT = "fact";
    public static final String FACTS_ENDPOINT = "facts";
    public static final String BREEDS_ENDPOINT = "breeds";
    public static final String QUERY_PARAM_LENGTH = "max_length";
    public static final String QUERY_PARAM_LIMIT = "limit";
    protected static final AppClient client = new AppClient();

    public static <T> T getModel(Response response, Class<T> tClass) {
        return response.as(tClass);
    }
}