package api;

import api.enums.StatusCode;
import api.models.CatFactModel;
import api.service.CatFactService;
import io.restassured.response.Response;
import java.util.List;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CatFactsTests {
    private final static int MAX_LENGTH = 50;
    private final static int LIMIT = 3;

    @Test
    public void isLengthInResponseEqualsOrLessThanLengthInQueryParameterTest(){
        Response response = CatFactService.getFactWithQueryLengthParameter(MAX_LENGTH)
            .then()
            .extract().response();
        CatFactModel model = AbstractService.getModel(response, CatFactModel.class);
        assertThat(model.getLength(), Matchers.lessThanOrEqualTo(MAX_LENGTH));
    }

    @Test
    public void checkStatusCodeGetFactTest(){
        Response response = CatFactService.getFact()
            .then()
            .extract().response();
        assertThat(response.statusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
    }

    @Test
    public void checkStatusCodeGetFactsTest(){
        Response response = CatFactService.getFacts()
            .then()
            .extract().response();
        assertThat(response.statusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
    }

    @Test
    public void areLengthsInResponseEqualsOrLessThanLengthInQueryParameterTest(){
        List<CatFactModel> facts = CatFactService.getFactsWithQueryLengthParameter(MAX_LENGTH)
            .then()
            .extract().response()
            .jsonPath().getList("data", CatFactModel.class);
        facts.forEach(x -> assertThat(x.getLength(), Matchers.lessThanOrEqualTo(MAX_LENGTH)));
    }

    @Test
    public void isSizeOfFactsInResponseEqualsLimitInQueryParameterTest(){
        List<CatFactModel> facts = CatFactService.getFactsWithQueryLimitParameter(LIMIT)
            .then()
            .extract().response()
            .jsonPath().getList("data", CatFactModel.class);
        assertThat(facts.size(), Matchers.equalTo(LIMIT));
    }
}