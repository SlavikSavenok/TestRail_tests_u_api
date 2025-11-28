package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By EMAIL_INPUT_LOCATOR = By.id("name");
    //private final By PASSWORD_INPUT_LOCATOR =;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return EMAIL_INPUT_LOCATOR;
    }
}
