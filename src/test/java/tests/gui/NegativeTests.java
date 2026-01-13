package tests.gui;

import baseEntities.BaseGuiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests extends BaseGuiTest {

    @Description("Неуспешная авторизация с некорректными учетными данными")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "Неуспешная авторизация",
            description = "Попытка авторизации с некорректными учетными данными. Ожидается сообщение об ошибке.")
    public void invalidLogin() {
        userStep.invalidLogin();

        Assert.assertEquals(loginPage.showLoginErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.");

    }
}

