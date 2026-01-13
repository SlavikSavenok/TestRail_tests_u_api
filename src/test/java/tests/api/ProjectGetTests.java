package tests.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;


public class ProjectGetTests extends BaseApiTest {

    @Description("Тест на проверку имеющихся проектов")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API GET проверка имеющихся проектов", description = "Тест на проверку имеющихся проектов")
    public void getAllProjects() {
        Response response = projectService.getProjects();

        System.out.println("Статус код = " + response.getStatusCode());
    }

    @Description("API GET проверка проекта по id")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API GET проверка проекта по id", description = "API GET проверка проекта по id")
    public void getProject() {
        int projectID = 1;
        projectService.getProject(projectID);
    }

    @Description("Проверка корректности типов данных в ответе")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API GET проверка типов данных", description = "Проверка корректности типов данных в ответе")
    public void validateDataTypes() {
        int projectID = 1;
        projectService.getValidateDataTypes(projectID);
    }

    @Description("API GET несуществующий проект")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API GET несуществующий проект", description = "API GET несуществующий проект")
    public void invalidProjectTest() {
        given()
                .when()
                .get(Endpoints.GET_INVALID_PROJECT)
                .then().log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Description("Проверка что ответ приходит в допустимое время")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API GET проверка времени ответа", description = "Проверка что ответ приходит в допустимое время")
    public void responseTimeTest() {
        Response response = projectService.getResponseTime();

        System.out.println("Фактическое время ответа: " + response.getTime() + " мс");
    }
}
