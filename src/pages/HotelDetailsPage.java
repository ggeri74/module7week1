package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HotelDetailsPage {
    WebDriver driver;

    public HotelDetailsPage(WebDriver x) {
        driver = x;
    }

    By displayedHotelName = By.cssSelector(".vcard>h1");
    By firstRoomName = By.cssSelector("[class = 'room cont clearfix']:first-child .room-info>h3");
    By firstRoomBookButton = By.cssSelector("#room-1-rateplan-1 .cta");
    By paymentPreferencePopup = By.className("payment-preference-overlay-content");
    By payNowButton = By.cssSelector("[class='payment-option pay-now'] [type='submit']");

    public String getFirstRoomName() {
        return driver.findElement(firstRoomName).getText();
    }

    public BookingForm ClickFirstRoomBookButton() {
        driver.findElement(firstRoomBookButton).click();
        return new BookingForm(driver);
    }

    public BookingForm ClickPayNowButton() {
        driver.findElement(payNowButton).click();
        return new BookingForm(driver);
    }

    public String getDisplayedHotelName() {
        return driver.findElement(displayedHotelName).getText();
    }

    public boolean isPaymentPreferencePopupDisplayed() {
        try {
            return driver.findElement(paymentPreferencePopup).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}


