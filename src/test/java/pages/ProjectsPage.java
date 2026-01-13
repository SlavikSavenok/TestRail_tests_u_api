package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProjectsPage extends BasePage {
    private final By PROJECT_PAGE_LOCATOR = By.xpath("//div[@data-testid='testCaseContentHeaderTitle']");

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

}
