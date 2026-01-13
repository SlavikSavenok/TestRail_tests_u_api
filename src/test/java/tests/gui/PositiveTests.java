package tests.gui;


import baseEntities.BaseGuiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PositiveTests extends BaseGuiTest {

    @Description("Успешная авторизация с корректными учетными данными")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName ="Успешная авторизация",
            description = "Успешная авторизация с корректными учетными данными")
    public void successfulLogin() {
        userStep.successfulLogin();

        Assert.assertTrue(onboardingPage.isPageOpened());
    }

    @Test
    public void addProject() {
        userStep.successfulLogin();
        onboardingPage.clickDashboardButton();
        dashboardPage.clickAddProjectButton();

    }

}
