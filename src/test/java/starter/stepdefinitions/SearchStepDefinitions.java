package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.support.searchApi;

import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class SearchStepDefinitions {

    @Steps
    private final searchApi searchShop = new searchApi();

    @Given("^I use path parameter (orange|apple)$")
    public void I_am_on_the_search_page(String arg) {
        switch (arg) {
            case "orange":
                searchShop.testSearchFunctionality("orange");
                break;
            case "apple":
                searchShop.testSearchFunctionality("apple");
                break;
        }
    }

    @Then("^I get status code$")
    public void I_get_status_code(DataTable dataTable) {
        Map<String, String> tableValue = (Map) dataTable.asMaps(String.class, String.class).get(0);
        restAssuredThat(response -> response.statusCode(Integer.parseInt(tableValue.get("Status Code"))));
    }

    @Then("^I want to see several products containing (orange|apple) in their title$")
    public void I_should_see_a_list_of_products_containing_appropriate_title(String args, DataTable dataTable) {

        Map<String, String> tablevalue = (Map) dataTable.asMaps(String.class, String.class).get(0);
        String value = tablevalue.get("Existing product");
        switch (args) {
            case "orange":
            case "apple":
                searchShop.testSearchFunctionality();
                Assert.assertFalse(searchShop.testSearchFunctionality().isEmpty());
                for (String title : searchShop.testSearchFunctionality()) {
                    Assert.assertTrue((searchShop.testSearchFunctionality().contains(value)));
                }
                break;
        }

    }

    @And("^I don't see (apple|orange) products containing non-corresponding titles$")
    public void the_non_corresponding_titles(String args, DataTable dataTable) {
        Map<String, String> tableValue = (Map) dataTable.asMaps(String.class, String.class).get(0);
        String value = tableValue.get("Existing product");
        switch (args) {
            case "orange":
            case "apple":
                searchShop.testSearchFunctionality();
                Assert.assertFalse(searchShop.testSearchFunctionality().isEmpty());
                for (String title : searchShop.testSearchFunctionality()) {
                    Assert.assertFalse((searchShop.testSearchFunctionality().contains(value)));
                }
                break;
        }

    }
}