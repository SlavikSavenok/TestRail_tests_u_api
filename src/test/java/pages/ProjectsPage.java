package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProjectsPage extends BasePage {
    private final By PROJECT_PAGE_LOCATOR = By.xpath("//div[@data-testid='testCaseContentHeaderTitle']");
    private final By PROJECT_LINK_LOCATOR = By.xpath("//a[text()='Pet Project']");
    private final By DELETE_PET_PROJECT_BUTTON = By.xpath("//a[text()='Pet Project']/following::div[@class='icon-small-delete'][1]");
    private final By DELETE_CHECKBOX = By.xpath("//div[@id='deleteDialog']//input[@name='deleteCheckbox']");
    private final By OK_BUTTON = By.xpath("//a[@data-testid='deleteCaseDialogActionSecondary']");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return PROJECT_PAGE_LOCATOR;
    }

    public boolean isProjectCreated(String projectName) {
        try {
            By locator = By.xpath("//*[text()='" + projectName + "']");
            return waitsService.waitVisibilityOf(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public Button getProjectLinkButton(String projectName) {
        return new Button(pageDriver, PROJECT_LINK_LOCATOR);
    }

    public Button getDeletePetProjectButton() {
        return new Button(pageDriver, DELETE_PET_PROJECT_BUTTON);
    }

    public CheckBox getDeleteCheckBox() {
        return new CheckBox(pageDriver, DELETE_CHECKBOX);
    }

    public Button getOkDeleteButton(){
        return new Button(pageDriver,OK_BUTTON);
    }

    public void clickDeletePetProjectButton() {
        getDeletePetProjectButton().click();
    }

    public void clickOkDeleteButton(){
        getOkDeleteButton().safeClick();
    }

    public void clickDeleteCheckBox(){
        getDeleteCheckBox().setCheckBox(true);
    }

}
