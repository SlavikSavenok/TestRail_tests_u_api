package baseEntities;

import com.github.javafaker.Faker;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import services.BrowsersService;
import services.WaitsService;
import steps.LoginSteps;
import steps.ProjectSteps;

import java.util.Random;

public class BaseGuiTest {
    protected WebDriver driver;
    protected WaitsService waitsService;
    protected Faker faker;
    protected Random random;
    protected LoginPage loginPage;
    protected LoginSteps loginSteps;
    protected OnboardingPage onboardingPage;
    protected DashboardPage dashboardPage;
    protected AddProjectPage addProjectPage;
    protected ProjectSteps projectSteps;
    protected ProjectsPage projectsPage;

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        waitsService = new WaitsService(driver);

        iTestContext.setAttribute("webdriver", driver);

        faker = new Faker();
        random = new Random();

        driver.get(ReadProperties.getUrl());
        loginSteps = new LoginSteps(driver);
        loginPage = new LoginPage(driver);
        onboardingPage = new OnboardingPage(driver);
        dashboardPage = new DashboardPage(driver);
        addProjectPage = new AddProjectPage(driver);
        projectSteps = new ProjectSteps(driver);
        projectsPage = new ProjectsPage(driver);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
