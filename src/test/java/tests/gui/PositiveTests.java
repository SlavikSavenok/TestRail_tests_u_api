package tests.gui;


import baseEntities.BaseGuiTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PositiveTests extends BaseGuiTest {

    @Test(description = "Успешная авторизация с корректными учетными данными")
    public void successfulLogin() {
        userStep.successfulLogin();

        Assert.assertTrue(onboardingPage.isPageOpened());
    }
}
