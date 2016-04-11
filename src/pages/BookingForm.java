package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class BookingForm {
    WebDriver driver;

    public BookingForm(WebDriver x) {
        driver = x;
    }

    By roomTypeInTheFinancialColumn = By.className("room-type");

    By firstNameAtRoomDetails = By.id("room-details-room-0-first-name");
    By lastNameAtRoomDetails = By.id("room-details-room-0-last-name");

    By firstNameAtPaymentDetails = By.id("payment-details-first-name");
    By lastNameAtPaymentDetails = By.id("payment-details-last-name");

    By cardNumber = By.id("payment-details-card-number");
    By cvv = By.id("payment-details-cvv");

    By expiryMonth = By.id("payment-details-expiry-month");

    By expiryYear = By.id("payment-details-expiry-year");

    By zipCode = By.id("billing-details-post-code");
    By emailAddress = By.id("contact-details-email");
    By phoneNumber = By.id("contact-details-phone");
    By bookButton = By.id("book-button");

    public void fillFirstNameAtRoomDetails(String firstName) {
        driver.findElement(firstNameAtRoomDetails).sendKeys(firstName);
    }

    public void fillLastNameAtRoomDetails(String lastName) {
        driver.findElement(lastNameAtRoomDetails).sendKeys(lastName);
    }

    public void fillFirstNameAtPaymentDetails(String firstName) {
        WebElement fn = driver.findElement(firstNameAtPaymentDetails);
        fn.clear();
        fn.sendKeys(firstName);
    }

    public void fillLastNameAtPaymentDetails(String lastName) {
        WebElement ln = driver.findElement(lastNameAtPaymentDetails);
        ln.clear();
        ln.sendKeys(lastName);
    }

    public void fillCardNumber(String number) {
        driver.findElement(cardNumber).sendKeys(number);
    }

    public void fillCvv(String number) {
        driver.findElement(cvv).sendKeys(number);
    }

    public void selectExpiryMonthOption(String month) {
        driver.findElement(expiryMonth).click();
        driver.findElement(By.cssSelector("#payment-details-expiry-month option[value='" + month + "']")).click();
    }

    public void selectExpiryYearOption(String year) {
        driver.findElement(expiryYear).click();
        driver.findElement(By.cssSelector("#payment-details-expiry-year option[value='" + year + "']")).click();
    }

    public void fillZipCode(String code) {
        driver.findElement(zipCode).sendKeys(code);
    }

    public void fillEmailAddress(String address) {
        driver.findElement(emailAddress).sendKeys(address);
    }

    public void fillPhoneNumber(String number) {
        driver.findElement(phoneNumber).sendKeys(number);
    }

    public ConfirmationPage clickBookButton() {
        driver.findElement(bookButton).click();
        return new ConfirmationPage(driver);
    }

    public String getRoomTypeInTheFinancialColumn() {
        return driver.findElement(roomTypeInTheFinancialColumn).getText();
    }
}