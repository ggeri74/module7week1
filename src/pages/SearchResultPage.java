package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SearchResultPage {
    private WebDriver driver;

    SearchResultPage(WebDriver x) {
        driver = x;
    }

    private By summaryHeading = By.cssSelector(".summary>h1");
    private By chooseRoomButton = By.cssSelector(".cta>span");
    private By selectedHotelName = By.cssSelector(".p-name>a");


    public String getSummaryHeadingText() {
        return driver.findElement(summaryHeading).getText();
    }

    public HotelDetailsPage clickChooseRoomButton() {
        driver.findElement(chooseRoomButton).click();
        return new HotelDetailsPage(driver);
    }

    public String getSelectedHotelName() {
        return driver.findElement(selectedHotelName).getText();
    }
}