package starter.support;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityRunner.class)
public class searchApi {
    public static final String API_URL = "https://waarkoop-server.herokuapp.com/api/v1/search/demo/";
    public String path;

    @Test
    @Title("Test the search functionality")
    public void testSearchFunctionality(String param) {
        SerenityRest.given()
                .when()
                .get(API_URL + param);
        path = API_URL + param;
    }

    public List<String> testSearchFunctionality() {
        SerenityRest.given()
                .when()
                .get(path)
                .then()
                .extract()
                .asString();
        List<String> expectedTitles = SerenityRest.then().extract().path("title");
        return expectedTitles;

    }

}

