package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnboardingPage extends BasePage {
    private final By ONBOARDING_PAGE_LOCATOR = By.xpath("//div[@class = 'integrations-header']");

    public OnboardingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return ONBOARDING_PAGE_LOCATOR;
    }
}
