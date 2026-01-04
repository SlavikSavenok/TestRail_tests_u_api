package pages;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnboardingPage extends BasePage {
    private final By ONBOARDING_PAGE_LOCATOR = By.xpath("//div[@class = 'integrations-header']");
    private final By DASHBOARD_BUTTON = By.id("navigation-sub-dashboard");

    public OnboardingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return ONBOARDING_PAGE_LOCATOR;
    }

    public Button getDashboardButton() {
        return new Button (pageDriver,DASHBOARD_BUTTON);
    }

    public void clickDashboardButton(){
        getDashboardButton().click();
    }
}
