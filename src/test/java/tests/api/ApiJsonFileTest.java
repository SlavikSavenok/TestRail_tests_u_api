package tests.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiJsonFileTest extends BaseApiTest {

    @Description("API Post Тест на проверку создания проекта c использованием данных из JSON")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "API Post создание проекта c использованием данных из JSON",
            description = "API Post создание проекта c использованием данных из JSON")
    public void addProjectUsingJsonFileTest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(ApiJsonFileTest.class.getClassLoader().getResourceAsStream("data/dataForApiTest/dataForApiTest.json"))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("name", is("JSON data test"))
                .body("announcement", is("JSON announcement"))
                .extract().response();

        int projectId = response.jsonPath().getInt("id");

        deleteProjectById(projectId);
    }

    private void deleteProjectById(int projectId) {
        projectService.deleteProject(projectId)
                .then()
                .statusCode(HttpStatus.SC_OK);

        System.out.println("Project with ID " + projectId + " deleted successfully");
    }
}

