package baseEntities;

import com.github.javafaker.Faker;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LoginPage;
import pages.OnboardingPage;
import services.BrowsersService;
import services.WaitsService;
import steps.UserStep;

import java.util.Random;

public class BaseGuiTest {
    protected WebDriver driver;
    protected WaitsService waitsService;
    protected Faker faker;
    protected Random random;
    protected LoginPage loginPage;
    protected UserStep userStep;
    protected OnboardingPage onboardingPage;
    protected DashboardPage dashboardPage;

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        waitsService = new WaitsService(driver);

        iTestContext.setAttribute("webdriver", driver);

        faker = new Faker();
        random = new Random();

        driver.get(ReadProperties.getUrl());
        userStep = new UserStep(driver);
        loginPage = new LoginPage(driver);
        onboardingPage = new OnboardingPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
