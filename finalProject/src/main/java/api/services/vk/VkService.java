package api.services.vk;

import api.AbstractService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class VkService extends AbstractService {

    public static RequestSpecification addAuthQueryParameters() {
        return given()
            .queryParam(QUERY_PARAM_OWNER_ID, PropertyReader.getOwnerId())
            .queryParam(QUERY_PARAM_API_VERSION, PropertyReader.getApiVersion())
            .queryParam(QUERY_PARAM_ACCESS_TOKEN, PropertyReader.getAccessToken());
    }

    @Step("Create post on wall")
    public static Response createPostOnWall(String postMessage) {
        RequestSpecification requestSpecification = addAuthQueryParameters()
            .basePath(CREATE_POST_ENDPOINT)
            .queryParam(QUERY_PARAM_MESSAGE, postMessage);
        return client.vkResponse(Method.POST, requestSpecification);
    }

    @Step("Add like to created post")
    public static Response addLikeToPost(String postId) {
        RequestSpecification requestSpecification = addAuthQueryParameters()
            .basePath(LIKE_POST_ENDPOINT)
            .queryParam(QUERY_PARAM_POST_ID, postId);
        return client.vkResponse(Method.POST, requestSpecification);
    }

    @Step("Add comment to created post")
    public static Response addCommentToPost(String postId, String comment) {
        RequestSpecification requestSpecification = addAuthQueryParameters()
            .basePath(CREATE_POST_COMMENT_ENDPOINT)
            .queryParam(QUERY_PARAM_POST_ID, postId)
            .queryParam(QUERY_PARAM_MESSAGE, comment);
        return client.vkResponse(Method.POST, requestSpecification);
    }

    @Step("Get comment under created post")
    public static Response getCommentUnderPost(String commentId) {
        RequestSpecification requestSpecification = addAuthQueryParameters()
            .basePath(GET_COMMENT_ENDPOINT)
            .queryParam(QUERY_PARAM_COMMENT_ID, commentId);
        return client.vkResponse(Method.GET, requestSpecification);
    }

    @Step("Delete created post")
    public static Response deletePost(String postId) {
        RequestSpecification requestSpecification = addAuthQueryParameters()
            .basePath(DELETE_POST_ENDPOINT)
            .queryParam(QUERY_PARAM_POST_ID, postId);
        return client.vkResponse(Method.POST, requestSpecification);
    }
}