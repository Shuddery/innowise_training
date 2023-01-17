package api;

import io.restassured.response.Response;
import org.apache.log4j.Logger;

public class AbstractService {

    protected static final Logger log = Logger.getLogger(AbstractService.class);

    public static final String QUERY_PARAM_OWNER_ID = "owner.id";
    public static final String QUERY_PARAM_API_VERSION = "v";
    public static final String QUERY_PARAM_ACCESS_TOKEN = "access_token";
    public static final String QUERY_PARAM_MESSAGE = "message";
    public static final String QUERY_PARAM_POST_ID = "post_id";
    public static final String QUERY_PARAM_COMMENT_ID = "comment_id";
    public static final String CREATE_POST_ENDPOINT = "wall.post";
    public static final String LIKE_POST_ENDPOINT = "wall.addLike";
    public static final String CREATE_POST_COMMENT_ENDPOINT = "wall.createComment";
    public static final String GET_COMMENT_ENDPOINT = "wall.getComment";
    public static final String DELETE_POST_ENDPOINT = "wall.delete";
    protected static final AppClient client = new AppClient();

    public static <T> T getModel(Response response, Class<T> tClass) {
        return response.as(tClass);
    }
}