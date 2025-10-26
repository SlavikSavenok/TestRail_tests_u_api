package servises;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

public class ProjectService implements IProjectService {


    @Override
    public Response getProjects() {
        return given()
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    @Override
    public Project getProject(int id) {
        return given()
                .pathParam("project_id", id)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class, ObjectMapperType.GSON);
    }

    @Override
    public void getValidateDataTypes(int projectID) {
        given()
                .pathParam("project_id", projectID)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("id", is(Matchers.instanceOf(Integer.class)))
                .body("name", is(Matchers.instanceOf(String.class)))
                .body("is_completed", is(Matchers.instanceOf(Boolean.class)))
                .body("suite_mode", is(Matchers.instanceOf(Integer.class)))
                .body("show_announcement", is(Matchers.instanceOf(Boolean.class)))
                .body("url", is(Matchers.instanceOf(String.class)));
    }

    @Override
    public Response getResponseTime() {
        return given()
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(2000L))
                .extract()
                .response();
    }

    @Override
    public Project addProject(Project project) {
        return  given()
                .contentType(ContentType.JSON)
                .body(project)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(Project.class, ObjectMapperType.GSON);
    }

    @Override
    public Project updateProject(int projectId, Project project) {
        return given()
                .contentType(ContentType.JSON)
                .pathParam("project_id", projectId)
                .body(project)
                .log().body()
                .when()
                .post(Endpoints.UPDATE_PROJECT) // Нужно добавить этот endpoint
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(Project.class, ObjectMapperType.GSON);
    }


    @Override
    public Response deleteProject(int projectId) {
        return given()
                .pathParam("project_id", projectId)
                .when()
                .delete(Endpoints.DELETE_PROJECT);
    }
}
