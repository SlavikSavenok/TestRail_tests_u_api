package tests.gui;

import baseEntities.BaseGuiTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests extends BaseGuiTest {

    @Test
    public void invalidLogin(){
        userStep.invalidLogin();

       Assert.assertEquals(loginPage.showLoginErrorMessage(),
               "Email/Login or Password is incorrect. Please try again.");

    }
}
