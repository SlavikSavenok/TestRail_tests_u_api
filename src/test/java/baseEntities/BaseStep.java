package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;
import steps.LoginSteps;

public class BaseStep {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AddProjectPage addProjectPage;
    protected OnboardingPage onboardingPage;
    protected DashboardPage dashboardPage;
    protected ProjectsPage projectsPage;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        addProjectPage = new AddProjectPage(driver);
        onboardingPage = new OnboardingPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage=new ProjectsPage(driver);
    }
}
