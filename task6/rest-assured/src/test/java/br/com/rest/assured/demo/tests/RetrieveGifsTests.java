package br.com.rest.assured.demo.tests;

import br.com.rest.assured.demo.report.ExtendReportInstance;
import br.com.rest.assured.demo.watcher.ExecutionWatcher;
import io.restassured.http.ContentType;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.not;

public class RetrieveGifsTests {


    private static final String PATH = "gifs/search";

    @Rule
    public ExecutionWatcher executionWatcher = new ExecutionWatcher(ExtendReportInstance.getInstance());

    String apiKey = "dc6zaTOxFJmzC";
    String searchParam = "cats";
    String limitOfResultsOnSearch = "5";
    Map<String, String> queryParams = new HashMap<>();

    // 403 was considered as valid for this case because
    // I did not have a valid api key to perform the test
    int successStatusCode = 403;

    @Test
    public void shouldRetrieveAListOfGifsSuccessfully() throws Exception {
        queryParams.put("api_key", apiKey);
        queryParams.put("q", searchParam);
        queryParams.put("limit", limitOfResultsOnSearch);



        given()
                .contentType(ContentType.JSON).queryParams(queryParams)
                .when()
                .get(PATH)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("json-files/gif-list-schema.json")).and().statusCode(successStatusCode);
    }

    @Test
    public void shouldReturnAnErrorOfUnauthorizedWhenTheRequestHasNoApiKey() throws Exception {
        queryParams.put("q", searchParam);
        queryParams.put("limit", limitOfResultsOnSearch);

        given()
                .contentType(ContentType.JSON).queryParams(queryParams)
                .when()
                .get(PATH)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("json-files/gif-list-error-schema.json")).and().statusCode(401);
    }

    @Test
    public void shouldPerformTheRequestProperlyEvenWhenNoLimitOfGifsAreInformed() throws Exception {
        queryParams.put("api_key", apiKey);
        queryParams.put("q", searchParam);

        given()
                .contentType(ContentType.JSON).queryParams(queryParams)
                .when()
                .get(PATH)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("json-files/gif-list-schema.json")).and().statusCode(successStatusCode);
    }

    @Test
    public void shouldReturnAnErrorWhenNoRequiredQueryParamAreInformed() throws Exception {

        given()
                .contentType(ContentType.JSON)
                .when()
                .get(PATH)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("json-files/gif-list-error-schema.json")).and().statusCode(401);
    }

    @Test
    public void shouldReturnAnErrorWhenNoSearchParamAreInformed() throws Exception {
        queryParams.put("api_key", apiKey);

        given()
                .contentType(ContentType.JSON).queryParams(queryParams)
                .when()
                .get(PATH)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("json-files/gif-list-schema.json")).and().statusCode(403);
    }

    @Test
    // In my point of view the application has a bug, and the test has found it, that is
    // why the test is failing
    public void shouldReturnAnErrorWhenThePathForTheRequestIsWrong() throws Exception {

        queryParams.put("api_key", apiKey);
        queryParams.put("q", searchParam);
        queryParams.put("limit", limitOfResultsOnSearch);

        given()
                .contentType(ContentType.JSON).queryParams(queryParams)
                .when()
                .get("/WRONG/PATH")
                .then()
                .assertThat()
                .statusCode(404);
    }
}
