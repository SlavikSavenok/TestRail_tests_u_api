package pages;

import baseEntities.BasePage;

import elements.Button;
import elements.Input;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By EMAIL_INPUT_LOCATOR= By.id("name");
    private final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private final By LOGIN_BUTTON_LOCATOR = By.id("button_primary");
    private final By LOGIN_ERROR_TEXT_LOCATOR = By.cssSelector("div[data-testid='loginErrorText']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return EMAIL_INPUT_LOCATOR;
    }

    public Input getEmailInput(){
        return new Input(pageDriver,EMAIL_INPUT_LOCATOR);
    }

    public Input getPasswordInput() {
        return new Input(pageDriver, PASSWORD_INPUT_LOCATOR);
    }

    public Button getLoginButton() {
        return new Button(pageDriver, LOGIN_BUTTON_LOCATOR);
    }

    public UIElement getLoginErrorMessageLocator() {
        return new UIElement(pageDriver, LOGIN_ERROR_TEXT_LOCATOR);
    }

    public void setEmailValue(String value) {
        getEmailInput().clickAndWrite(value);
    }

    public void setPasswordValue(String value) {
        getPasswordInput().clickAndWrite(value);
    }

    public void clickLogin() {
        getLoginButton().click();
    }

    public String showLoginErrorMessage() {
       return getLoginErrorMessageLocator().getText();
    }
}
