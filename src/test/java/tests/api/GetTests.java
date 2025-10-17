package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;

import models.Project;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class GetTests extends BaseApiTest {

    @Test(testName = "API GET проверка имеющихся проектов", description = "Тест на проверку имеющихся проектов")
    public void getAllProjects() {
        Response response = projectService.getProjects();

        System.out.println("Статус код = " + response.getStatusCode());
    }

    @Test(testName = "API GET проверка проекта по id", description = "API GET проверка проекта по id")
    public void getProject() {
        int projectID = 2;
        Project project = projectService.getProject(projectID);
    }

    @Test(testName = "API GET несуществующий проект", description = "API GET несуществующий проект")
    public void invalidProjectTest() {
        given()
                .when()
                .get(Endpoints.GET_INVALID_PROJECT)
                .then().log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

}
