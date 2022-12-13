package api;

import api.enums.StatusCode;
import api.models.BreedsModel;
import api.service.BreedService;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import utils.GsonUtils;

import static org.hamcrest.MatcherAssert.assertThat;

public class BreedTests extends BaseApiTest {
    private final static int LIMIT = 5;

    @Description("Check response status code after get '/breeds' request")
    @Test
    public void checkStatusCodeGetBreedsTest(){
        Response breedsResponse = BreedService.getBreeds()
            .then()
            .extract().response();
        assertThat(breedsResponse.statusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
    }

    @Description("Check amount of breeds after get '/breeds' request with limit parameter")
    @Test
    public void isSizeOfBreedsInResponseEqualsLimitInQueryParameterTest(){
        String allBreedsResponseBody = BreedService.getBreedsWithQueryLimitParameter(LIMIT)
            .then()
            .extract().body().asString();
        BreedsModel responseBreeds = GsonUtils.fromJson(allBreedsResponseBody, BreedsModel.class);
        assertThat(responseBreeds.getData().length, Matchers.equalTo(LIMIT));
    }
}