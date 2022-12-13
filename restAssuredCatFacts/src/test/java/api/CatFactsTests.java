package api;

import api.enums.StatusCode;
import api.models.CatFactModel;
import api.models.CatFactsModel;
import api.service.CatFactService;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import java.util.Arrays;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import utils.GsonUtils;

import static org.hamcrest.MatcherAssert.assertThat;

public class CatFactsTests extends BaseApiTest {
    private final static int MAX_LENGTH = 50;
    private final static int LIMIT = 3;

    @Description("Check length of fact in response after get '/fact' request with max_length parameter")
    @Test
    public void isLengthInResponseEqualsOrLessThanLengthInQueryParameterTest(){
        Response factResponse = CatFactService.getFactWithQueryLengthParameter(MAX_LENGTH)
            .then()
            .extract().response();
        CatFactModel model = AbstractService.getModel(factResponse, CatFactModel.class);
        assertThat(model.getLength(), Matchers.lessThanOrEqualTo(MAX_LENGTH));
    }

    @Description("Check response status code after get '/fact' request")
    @Test
    public void checkStatusCodeGetFactTest(){
        Response factResponse = CatFactService.getFact()
            .then()
            .extract().response();
        assertThat(factResponse.statusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
    }

    @Description("Check response status code after get '/facts' request")
    @Test
    public void checkStatusCodeGetFactsTest(){
        Response factsResponse = CatFactService.getFacts()
            .then()
            .extract().response();
        assertThat(factsResponse.statusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
    }

    @Description("Check lengths of facts in response after get '/facts' request with max_length parameter")
    @Test
    public void areLengthsInResponseEqualsOrLessThanLengthInQueryParameterTest(){
        String allFactsResponseBody = CatFactService.getFactsWithQueryLengthParameter(MAX_LENGTH)
            .then()
            .extract().body().asString();
        CatFactsModel responseFacts = GsonUtils.fromJson(allFactsResponseBody, CatFactsModel.class);
        Arrays.stream(responseFacts.getData()).forEach(x -> assertThat(x.getLength(),
            Matchers.lessThanOrEqualTo(MAX_LENGTH)));
    }

    @Description("Check amount of facts after get '/facts' request with limit parameter")
    @Test
    public void isSizeOfFactsInResponseEqualsLimitInQueryParameterTest(){
        String allFactsResponseBody = CatFactService.getFactsWithQueryLimitParameter(LIMIT)
            .then()
            .extract().body().asString();
        CatFactsModel responseFacts = GsonUtils.fromJson(allFactsResponseBody, CatFactsModel.class);
        assertThat(responseFacts.getData().length, Matchers.equalTo(LIMIT));
    }
}