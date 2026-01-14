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
    @Test(testName = "Успешная авторизация",
            description = "Успешная авторизация с корректными учетными данными")
    public void successfulLogin() {
        loginSteps.successfulLogin();

        Assert.assertTrue(onboardingPage.isPageOpened());
    }

    @Description("Тест на создание нового проекта через UI интерфейс")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "Создание нового проекта",
            description = "Проверка успешного создания проекта с заполнением всех полей формы")
    public void addProject() {
        projectSteps
                .navigateToAddProjectPage()
                .createProject();
        Assert.assertTrue(projectsPage.isProjectCreated("Pet Project"));
    }

    @Description("Тест на удаление существующего проекта")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "Удаление проекта Pet Project",
            description = "Проверка успешного удаления созданного проекта", dependsOnMethods = "addProject")
    public void deleteProject() throws InterruptedException {
        projectSteps.navigateToProjectsList();
        projectSteps.deleteProject("Pet Project");

    }
}
