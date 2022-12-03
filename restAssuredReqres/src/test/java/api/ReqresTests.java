package api;

import enums.StatusCode;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class ReqresTests {

    private final static String URL = "https://reqres.in/";
    private final Map<String, String> user = new HashMap<>();
    private final Map<String, String> register = new HashMap<>();

    @Test(description = "LIST USERS")
    public void getListUsersTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.OK.getCode()));
        Services.getRequest("api/users?page=2")
            .then()
            .body("data.id[0]", equalTo(7));
    }

    @Test(description = "SINGLE USER")
    public void getSingleUserTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.OK.getCode()));
        Services.getRequest("api/users/2")
            .then()
            .body("data.id", equalTo(2));
    }

    @Test(description = "SINGLE USER NOT FOUND")
    public void getNonExistentUserTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.NOT_FOUND.getCode()));
        Services.getRequest("api/users/23");
    }

    @Test(description = "LIST <RESOURCE>")
    public void getListResourceTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.OK.getCode()));
        Services.getRequest("api/unknown")
            .then()
            .body("page", notNullValue())
            .body("per_page", notNullValue())
            .body("total", notNullValue());
    }

    @Test(description = "SINGLE <RESOURCE>")
    public void getSingleResourceTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.OK.getCode()));
        Services.getRequest("/api/unknown/2")
            .then()
            .body("data.id", equalTo(2));
    }

    @Test(description = "SINGLE <RESOURCE> NOT FOUND")
    public void getNonExistentResourceTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.NOT_FOUND.getCode()));
        Services.getRequest("api/unknown/23");
    }

    @Test(description = "CREATE")
    public void createUserTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.CREATED.getCode()));
        user.put("name", "morpheus");
        user.put("job", "leader");
        Services.postRequest("api/users", user)
            .then()
            .body("name", equalTo("morpheus"))
            .body("job", equalTo("leader"));
    }

    @Test(description = "UPDATE WITH PUT METHOD")
    public void updateUserWithPutMethodTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.OK.getCode()));
        user.put("name", "morpheus");
        user.put("job", "zion resident");
        Services.putRequest("api/users/2", user)
            .then()
            .body("name", equalTo("morpheus"))
            .body("job", equalTo("zion resident"));
    }

    @Test(description = "UPDATE WITH PATCH METHOD")
    public void updateUserWithPatchMethodTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.OK.getCode()));
        user.put("name", "morpheus");
        user.put("job", "zion resident");
        Services.patchRequest("api/users/2", user)
            .then()
            .body("name", equalTo("morpheus"))
            .body("job", equalTo("zion resident"));
    }

    @Test(description = "DELETE")
    public void deleteUserTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.NO_CONTENT.getCode()));
        Services.deleteRequest("api/users/2");
    }

    @Test(description = "REGISTER - SUCCESSFUL")
    public void checkSuccessfulRegisterTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.OK.getCode()));
        register.put("email", "eve.holt@reqres.in");
        register.put("password", "pistol");
        Services.postRequest("api/register", register)
            .then()
            .body("id", equalTo(4))
            .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test(description = "REGISTER - UNSUCCESSFUL")
    public void checkUnsuccessfulRegisterTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.BAD_REQUEST.getCode()));
        register.put("email", "sydney@fife");
        register.put("password", "");
        Services.postRequest("api/register", register)
            .then()
            .body("error", equalTo("Missing password"));
    }

    @Test(description = "LOGIN - SUCCESSFUL")
    public void checkSuccessfulLoginTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.OK.getCode()));
        register.put("email", "eve.holt@reqres.in");
        register.put("password", "cityslicka");
        Services.postRequest("api/login", register)
            .then()
            .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test(description = "LOGIN - UNSUCCESSFUL")
    public void checkUnsuccessfulLoginTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.BAD_REQUEST.getCode()));
        register.put("email", "peter@klaven");
        register.put("password", "");
        Services.postRequest("api/login", register)
            .then()
            .body("error", equalTo("Missing password"));
    }

    @Test(description = "DELAYED RESPONSE")
    public void getDelayedListUsersTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL),
            Specifications.responseSpec(StatusCode.OK.getCode()));
        Services.getRequest("/api/users?delay=3")
            .then()
            .body("data.id[0]", equalTo(1));
    }
}