package Telus;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TelusBasePage extends Base{


    private WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static WebDriver driver = Base.getInstanceOfWebDriverManager().getDriver();



    private WebElement welcomeModal() {
        return driver.findElement(By.cssSelector("div.home div.welcome-modal-container:nth-child(5) div.welcome-modal-popup-container div.popUpContainer.welcome-modal-popup div.welcome-slide-container > span.close-modal"));
    }

    private WebElement onDemandButton() {
        return driver.findElement(By.xpath("//a[normalize-space()='On Demand']"));
    }

    private WebElement moviesTag() {
        return driver.findElement(By.xpath("//span[text()='Movies']"));
    }

    private WebElement filterDropdow() {
        return driver.findElement(By.xpath("//div[contains(@class, 'dropdown-button filterDropdownButton ') and text() = 'Filter']"));
    }
    private WebElement animatedSectionButton() {
        return driver.findElement(By.xpath("//span[contains(@class, 'label') and text() = 'Animated']"));
    }
    private WebElement applyButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'filter-button filter-apply-button filter-button-enabled') and text() = 'Apply']"));
    }

    private WebElement ratingTag() {
        return driver.findElement(By.xpath("//p[contains(@class, 'subtitle') and text() = '18+']"));
    }
    private WebElement assetDetails() {
        return driver.findElement(By.xpath("//span[contains(@class, 'no-scores-line-metadata')]"));
    }

    public void closeModal()
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(welcomeModal()));
        welcomeModal().click();
    }

    public void clickOnDemand() {
        onDemandButton().click();
    }

    public void scrollToMoviesTag() {
        Base.getInstanceOfWebDriverManager().scrollIntoView(moviesTag());
        moviesTag().click();
    }

    public void clickFilterButton() {
        filterDropdow().click();
    }

    public void selectAnimatedSection() {
        animatedSectionButton().click();
    }

    public void clickApplyButton() {
        applyButton().click();
    }

    public void select18TagAsset() {
        ratingTag().click();
    }

    public String getAssetDetails() {
        return assetDetails().getText();
    }
}