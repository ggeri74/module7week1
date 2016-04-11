package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver x) {
        driver = x;
    }

    private By destinationField = By.id("qf-0q-destination");
    private By autoSuggestFirstItem = By.cssSelector(".autosuggest-category-result");
    private By checkinField = By.id("qf-0q-localised-check-in");
    private By checkoutField = By.id("qf-0q-localised-check-out");
    private By searchButton = By.cssSelector("[type=submit]");
    private By headerBar = By.id("header-bar");

    public void fillDestination(String destination) {
        driver.findElement(destinationField).sendKeys(destination);
    }

    public String getDestinationFieldContent() {
        return driver.findElement(destinationField).getAttribute("value");
    }

    public void fillCheckin(String date) {
        WebElement cif = driver.findElement(checkinField);
        cif.clear();
        cif.sendKeys(date);
        clickHeaderBar(); // to close date picker
    }

    public void fillCheckout(String date) {
        WebElement cof = driver.findElement(checkoutField);
        cof.clear();
        cof.sendKeys(date);
        clickHeaderBar(); // to close date picker
    }

    private void clickHeaderBar() {
        driver.findElement(headerBar).click();
    }

    public void clickFirstAutoSuggestItem() {
        driver.findElement(autoSuggestFirstItem).click();
    }

    public SearchResultPage clickSearchButton() {
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }


}
