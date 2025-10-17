package servises;

import io.restassured.response.Response;
import models.Project;

public interface IProjectService {
    Response getProjects();
    Project getProject(int id);
}
