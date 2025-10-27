package tests.api;

import baseEntities.BaseApiTest;
import models.Project;
import org.apache.http.HttpStatus;
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

        Assert.assertNotNull(actualProject.getId());
        Assert.assertEquals(actualProject.getName(), expectedProject.getName());
        Assert.assertEquals(actualProject.getAnnouncement(), expectedProject.getAnnouncement());
        Assert.assertEquals(actualProject.getShowAnnouncement(), expectedProject.getShowAnnouncement());
    }

    @Test(testName = "API Get проверка чтения созданного проекта",
            description = "Тест на проверку чтения созданного проекта по ID",
            dependsOnMethods = "addProjectTest")
    public void getProjectTest() {
        int createdProjectId = actualProject.getId();

        Project retrievedProject = projectService.getProject(createdProjectId);

        Assert.assertEquals(retrievedProject.getId(), actualProject.getId());
        Assert.assertEquals(retrievedProject.getName(), actualProject.getName());
        Assert.assertEquals(retrievedProject.getAnnouncement(), actualProject.getAnnouncement());
        Assert.assertEquals(retrievedProject.getShowAnnouncement(), actualProject.getShowAnnouncement());

    }

    @Test(testName = "API Post проверка обновления проекта", description = "Тест на проверку обновления проекта",
            dependsOnMethods = "addProjectTest")
    public void updateProjectTest() {
        int createdProjectId = actualProject.getId();
        Project updates = new Project();
        updates.setName(actualProject.getName());
        updates.setAnnouncement("Updated project description");
        updates.setShowAnnouncement(true);

        Project updateProject = projectService.updateProject(createdProjectId, updates);

        Assert.assertEquals(updateProject.getAnnouncement(), updates.getAnnouncement());

    }

    @Test(testName = "API Delete проверка удаления проекта", description = "Тест на проверку удаления проекта",
            dependsOnMethods = "updateProjectTest")
    public void deleteProjectTest() {
        int projectIdToDelete = actualProject.getId();
        projectService.deleteProject(projectIdToDelete)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
