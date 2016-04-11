package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SearchResultPage {
    WebDriver driver;

    public SearchResultPage(WebDriver x) {
        driver = x;
    }

    By summaryHeading = By.cssSelector(".summary>h1");
    By chooseRoomButton = By.cssSelector(".cta>span");
    By selectedHotelName = By.cssSelector(".p-name>a");


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