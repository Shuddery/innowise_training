package api.vk;

import api.AbstractService;
import api.BaseApiTest;
import api.models.vk.CommentRootResponseModel;
import api.models.vk.LikeResponseModel;
import api.services.vk.VkService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.IConstants;

public class VkApiTest extends BaseApiTest {

    private static Response postResponse;
    private static String postId;

    @BeforeAll()
    public static void createPostOnWall() {
        postResponse = VkService.createPostOnWall(IConstants.commentText);
        postId = postResponse.jsonPath().getString(IConstants.postIdPath);
    }

    @Test
    public void checkStatusCodeOfPostCreationTest() {
        Assertions.assertEquals(postResponse.statusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void isLikeAddedToPostTest() {
        Response likesResponse = VkService.addLikeToPost(postId)
            .then()
            .extract().response();
        LikeResponseModel likeResponseModel = AbstractService.getModel(likesResponse, LikeResponseModel.class);
        Assertions.assertEquals(likeResponseModel.getResponse().getLikes(), IConstants.likesAmount);
    }

    @Test
    public void isCommentCreatedUnderPostTest() {
        String commentId = VkService.addCommentToPost(postId, IConstants.commentText)
            .jsonPath().getString(IConstants.commentIdPath);
        Response commentResponse = VkService.getCommentUnderPost(commentId)
            .then()
            .extract().response();
        CommentRootResponseModel rootResponse = AbstractService.getModel(commentResponse, CommentRootResponseModel.class);
        Assertions.assertEquals(rootResponse.getResponse().getItems().get(0).getText(), IConstants.commentText);
    }

    @AfterAll()
    public static void deletePost() {
        VkService.deletePost(postId);
    }
}