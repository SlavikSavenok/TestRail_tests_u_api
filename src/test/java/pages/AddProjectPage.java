package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.CheckBox;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BasePage {
    private final By NAME_INPUT_LOCATOR = By.xpath("//*[@data-testid='addProjectNameInput']");
    private final By ANNOUNCEMENT_INPUT_LOCATOR = By.xpath("//div[@class='fr-element fr-view']");
    private final By SHOW_ANNOUNCEMENT_CHECKBOX_LOCATOR = By.id("show_announcement");
    private final By PROJECTS_BUTTON = By.id("navigation-sub-projects");
    private final By ADD_PROJECT_BUTTON = By.id("accept");


    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return NAME_INPUT_LOCATOR;
    }

    public Input getNameInput() {
        return new Input(pageDriver, NAME_INPUT_LOCATOR);
    }

    public Input getAnnouncement() {
        return new Input(pageDriver, ANNOUNCEMENT_INPUT_LOCATOR);
    }

    public CheckBox getShowAnnouncement(){
        return new CheckBox(pageDriver,SHOW_ANNOUNCEMENT_CHECKBOX_LOCATOR);
    }

    public Button getAddButton() {
        return new Button(pageDriver, ADD_PROJECT_BUTTON);
    }

    public Button getProjectButton(){
        return new Button(pageDriver,PROJECTS_BUTTON);
    }

    public void setNameValue(String value) {
        getNameInput().clickAndWrite(value);
    }

    public void setAnnouncementValue(String value) {
        getAnnouncement().clickAndWrite(value);
    }

    public void clickShowAnnouncement(){
        getShowAnnouncement().setCheckBox(true);
    }

    public void clickAddProjectButton() {
        getAddButton().click();
    }

    public void clickProjectsButton(){
        getProjectButton().click();
    }

}
