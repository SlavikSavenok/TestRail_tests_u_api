package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiJsonFileTest extends BaseApiTest {

    @Test(testName = "API Post создание проекта c использованием данных из JSON", description = "API Post создание проекта c использованием данных из JSON")
    public void addProjectUsingJsonFileTest() {

        given()
                .contentType(ContentType.JSON)
                .body(ApiJsonFileTest.class.getClassLoader().getResourceAsStream("data/dataForApiTest/dataForApiTest.json"))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("name", is("JSON data test"))
                .body("announcement", is("JSON announcement"));
    }
}

