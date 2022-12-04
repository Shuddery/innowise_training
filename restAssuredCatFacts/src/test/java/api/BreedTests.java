package api;

import api.enums.StatusCode;
import api.models.BreedModel;
import api.service.BreedService;
import io.restassured.response.Response;
import java.util.List;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class BreedTests {
    private final static int LIMIT = 5;

    @Test
    public void checkStatusCodeGetFactsTest(){
        Response response = BreedService.getBreeds()
            .then()
            .extract().response();
        assertThat(response.statusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
    }

    @Test
    public void isSizeOfBreedsInResponseEqualsLimitInQueryParameterTest(){
        List<BreedModel> breeds = BreedService.getBreedsWithQueryLimitParameter(LIMIT)
            .then()
            .extract().response()
            .jsonPath().getList("data", BreedModel.class);
        assertThat(breeds.size(), Matchers.equalTo(LIMIT));
    }
}