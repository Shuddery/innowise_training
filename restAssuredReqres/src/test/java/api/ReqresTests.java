package api;

import io.restassured.response.Response;
import models.error.ErrorModel;
import models.login.LoginResponseModel;
import models.register.RegisterRequestModel;
import models.register.RegisterResponseModel;
import models.user.UserRequestModel;
import models.resource.ResourceModel;
import models.resource.SingleResourceModel;
import models.user.UserPostResponseModel;
import models.user.SingleUserModel;
import models.user.UserModel;
import models.user.UserUpdateResponseModel;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import service.ReqresService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;


public class ReqresTests extends BaseApiTest {

    private static final int page = 2;
    private static final int id = 2;
    private static final int delay = 3;

    @Test
    public void checkQueryParameterPageAfterGetListOfUsersTest() {
        Response usersResponse = ReqresService.getListOfUsersWithQueryParameterPage(page)
            .then()
            .extract().response();
        UserModel userModel = AbstractService.getModel(usersResponse, UserModel.class);
        assertThat(userModel.getPage(), Matchers.equalTo(page));
    }

    @Test
    public void getSingleUserByIdTest() {
        Response userResponse = ReqresService.getSingleUserById(id)
            .then()
            .extract().response();
        SingleUserModel singleUserModel = AbstractService.getModel(userResponse, SingleUserModel.class);
        assertThat(singleUserModel.getData().getId(), Matchers.equalTo(id));
    }

    @Test
    public void checkStatusCodeOfNonExistentUserTest() {
        Response userResponse = ReqresService.getNonExistentSingleUser()
            .then()
            .extract().response();
        assertThat(userResponse.statusCode(), Matchers.equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void checkTotalFieldAfterGetListOfResourcesTest() {
        Response resourcesResponse = ReqresService.getListOfResources()
            .then()
            .extract().response();
        ResourceModel resourceModel = AbstractService.getModel(resourcesResponse, ResourceModel.class);
        assertThat(resourceModel.getTotal(), Matchers.equalTo(12));
    }

    @Test
    public void getSingleResourceByIdTest() {
        Response resourceResponse = ReqresService.getSingleResourceById(id)
            .then()
            .extract().response();
        SingleResourceModel singleResourceModel = AbstractService.getModel(resourceResponse, SingleResourceModel.class);
        assertThat(singleResourceModel.getData().getId(), Matchers.equalTo(id));
    }

    @Test
    public void checkStatusCodeOfNonExistentResourceTest() {
        Response resourceResponse = ReqresService.getNonExistentResource()
            .then()
            .extract().response();
        assertThat(resourceResponse.statusCode(), Matchers.equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void checkNameInUserResponseAfterCreateUserTest() {
        UserRequestModel userRequestModel = new UserRequestModel();
        userRequestModel.setName("morpheus");
        userRequestModel.setJob("leader");
        Response response = ReqresService.createUser(userRequestModel)
            .then()
            .extract().response();
        UserPostResponseModel userPostResponseModel = AbstractService.getModel(response, UserPostResponseModel.class);
        assertThat(userPostResponseModel.getName(), Matchers.equalTo(userPostResponseModel.getName()));
    }

    @Test
    public void checkNameInUserResponseAfterUpdateUserWithPutMethodTest() {
        UserRequestModel userRequestModel = new UserRequestModel();
        userRequestModel.setName("morpheus");
        userRequestModel.setJob("zion resident");
        Response response = ReqresService.updateUserWithPutMethod(userRequestModel)
            .then()
            .extract().response();
        UserUpdateResponseModel userUpdateResponseModel = AbstractService.getModel(response, UserUpdateResponseModel.class);
        assertThat(userUpdateResponseModel.getName(), Matchers.equalTo(userUpdateResponseModel.getName()));
    }

    @Test
    public void checkJobInUserResponseAfterUpdateUserWithPatchMethodTest() {
        UserRequestModel userRequestModel = new UserRequestModel();
        userRequestModel.setName("morpheus");
        userRequestModel.setJob("zion resident");
        Response response = ReqresService.updateUserWithPatchMethod(userRequestModel)
            .then()
            .extract().response();
        UserUpdateResponseModel userUpdateResponseModel = AbstractService.getModel(response, UserUpdateResponseModel.class);
        assertThat(userUpdateResponseModel.getJob(), Matchers.equalTo(userUpdateResponseModel.getJob()));
    }

    @Test
    public void checkStatusCodeAfterDeleteUserTest() {
        Response userResponse = ReqresService.deleteUser()
            .then()
            .extract().response();
        assertThat(userResponse.statusCode(), Matchers.equalTo(HttpStatus.SC_NO_CONTENT));
    }

    @Test
    public void checkIdInRegisterResponseAfterRegisterUserTest() {
        RegisterRequestModel registerRequestModel = new RegisterRequestModel();
        registerRequestModel.setEmail("eve.holt@reqres.in");
        registerRequestModel.setPassword("pistol");
        Response response = ReqresService.registerUser(registerRequestModel)
            .then()
            .extract().response();
        RegisterResponseModel registerResponseModel = AbstractService.getModel(response, RegisterResponseModel.class);
        assertThat(registerResponseModel.getId(), Matchers.equalTo(4));
    }

    @Test
    public void checkErrorMessageAfterRegisterWithEmptyPasswordTest() {
        RegisterRequestModel registerRequestModel = new RegisterRequestModel();
        registerRequestModel.setEmail("sydney@fife");
        Response response = ReqresService.registerUser(registerRequestModel)
            .then()
            .extract().response();
        ErrorModel errorModel = AbstractService.getModel(response, ErrorModel.class);
        assertThat(errorModel.getError(), Matchers.equalTo("Missing password"));
    }

    @Test
    public void checkTokenInLoginResponseAfterLoginUserTest() {
        RegisterRequestModel registerRequestModel = new RegisterRequestModel();
        registerRequestModel.setEmail("eve.holt@reqres.in");
        registerRequestModel.setPassword("cityslicka");
        Response response = ReqresService.loginInUser(registerRequestModel)
            .then()
            .extract().response();
        LoginResponseModel loginResponseModel = AbstractService.getModel(response, LoginResponseModel.class);
        assertThat(loginResponseModel.getToken(), Matchers.equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void checkErrorMessageAfterLoginWithEmptyPasswordTest() {
        RegisterRequestModel registerRequestModel = new RegisterRequestModel();
        registerRequestModel.setEmail("peter@klaven");
        Response response = ReqresService.loginInUser(registerRequestModel)
            .then()
            .extract().response();
        ErrorModel errorModel = AbstractService.getModel(response, ErrorModel.class);
        assertThat(errorModel.getError(), Matchers.equalTo("Missing password"));
    }

    @Test
    public void checkStatusCodeAfterGetListOfUserWithDelayTest() {
        Response usersResponse = ReqresService.getListOfUsersWithQueryParameterDelay(delay)
            .then()
            .extract().response();
        assertThat(usersResponse.getStatusCode(), Matchers.equalTo(HttpStatus.SC_OK));
    }
}