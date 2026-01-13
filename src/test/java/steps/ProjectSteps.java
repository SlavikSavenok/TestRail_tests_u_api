package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;

public class ProjectSteps extends BaseStep {

    public ProjectSteps(WebDriver driver) {
        super(driver);
    }

    public ProjectSteps navigateToAddProjectPage() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.successfulLogin();
        onboardingPage.clickDashboardButton();
        dashboardPage.clickAddProjectButton();
        return this;
    }

    public ProjectSteps createProject() {
        addProjectPage.setNameValue("Pet Project");
        addProjectPage.setAnnouncementValue("Pet Announcement");
        addProjectPage.clickAddProjectButton();
        projectsPage.isProjectCreated("Pet Project");
        return this;
    }


}
