package tests.api;

import baseEntities.BaseApiTest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectCrudTests extends BaseApiTest {

    @Test(testName = "API Post проверка создания проекта")
    public void addProjectTest() {

        Project expectedProject = new Project();
        expectedProject.setName("CRUD Test Project");
        expectedProject.setAnnouncement("CRUD Announcement");
        expectedProject.setShowAnnouncement(false);

        actualProject = projectService.addProject(expectedProject);
        Assert.assertEquals(actualProject.getName(), expectedProject.getName());
        Assert.assertEquals(actualProject.getAnnouncement(), expectedProject.getAnnouncement());
        Assert.assertEquals(actualProject.getShowAnnouncement(), expectedProject.getShowAnnouncement());
    }
}
