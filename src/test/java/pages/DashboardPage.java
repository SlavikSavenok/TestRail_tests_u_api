package pages;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final By DASHBOARD_PAGE_LOCATOR = By.xpath("//div[@class = 'content-header-title page_title']");
    private final By ADD_PROJECT_BUTTON = By.id("sidebar-projects-add");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return DASHBOARD_PAGE_LOCATOR;
    }

    public Button getAddButton() {
        return new Button(pageDriver, ADD_PROJECT_BUTTON);
    }

    public void clickAddProjectButton() {
        getAddButton().click();

    }
}
