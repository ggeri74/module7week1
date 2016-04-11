package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPage;
import pages.HotelDetailsPage;
import pages.BookingForm;
import pages.ConfirmationPage;

import lib.Utils;

import java.util.concurrent.TimeUnit;
import static java.lang.System.setProperty;

public class TestHotelsCom {


    @Test(groups = "Firefox")
    public void testEndToEndBookingFlowFirefox() {
        FirefoxDriver driver = new FirefoxDriver();
        testEndToEndBookingFlow(driver);
    }

    @Test(groups = "Chrome")
    public void testEndToEndBookingFlowChrome() {
        setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        testEndToEndBookingFlow(driver);
    }

    @Test(groups = "IE")
    public void testEndToEndBookingFlowIE() {
        setProperty("webdriver.ie.driver", "C:\\Java\\IEDriverServer.exe");
        InternetExplorerDriver driver = new InternetExplorerDriver();
        testEndToEndBookingFlow(driver);
    }

    @Test(groups = "PhantomJS")
    public void testEndToEndBookingFlowPhantomJS() {
        System.setProperty("phantomjs.binary.path", "C:\\Java\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        PhantomJSDriver driver = new PhantomJSDriver();
        testEndToEndBookingFlow(driver);
    }


    public void testEndToEndBookingFlow(RemoteWebDriver driver) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://hotels.com/?locale=en_US&pos=HCOM_US");

        // ----------------- Search for suitable hotel, moving to the search result page -------------------------

        HomePage hp = new HomePage(driver);
        hp.fillDestinationField("Budapest Hungary");
        hp.clickFirstAutoSuggestItem();
        String selectedAutoSuggestItem = hp.getDestinationFieldContent();
        hp.fillCheckin("12/22/16");
        hp.fillCheckout("12/24/16");
        SearchResultPage srp = hp.clickSearchButton();

        // ----------------- Selecting a hotel, moving to the hotel details page -------------------------

        Assert.assertEquals(selectedAutoSuggestItem, srp.getSummaryHeadingText());
        String selectedHotelName = srp.getSelectedHotelName();
        HotelDetailsPage hdp = srp.clickChooseRoomButton();
        new Utils(driver).switchToNewWindow(driver.getWindowHandle());

        // ----------------- Selecting a room, moving to the booking form -------------------------

        Assert.assertEquals(selectedHotelName, hdp.getDisplayedHotelName());
        String selectedRoomName = hdp.getFirstRoomName();
        BookingForm bf = hdp.ClickFirstRoomBookButton();
        if (hdp.isPaymentPreferencePopupDisplayed()) {
            hdp.ClickPayNowButton();
        }

        Assert.assertEquals(selectedRoomName, bf.getRoomTypeInTheFinancialColumn());

        // ----------------- Booking -------------------------

        bf.fillFirstNameAtRoomDetails("Clark");
        bf.fillLastNameAtRoomDetails("Kent");
        bf.fillFirstNameAtPaymentDetails("Lois");
        bf.fillLastNameAtPaymentDetails("Lane");
        bf.fillCardNumber("4716796323706374");
        bf.fillCvv("123");
        bf.selectExpiryMonthOption("5");
        bf.selectExpiryYearOption("2020");
        bf.fillZipCode("12345678");
        bf.fillEmailAddress("gergely_glosz@epam.com");
        bf.fillPhoneNumber("5555555666");
        ConfirmationPage cp = bf.clickBookButton();

        // ----------------- Confirmation Page -------------------------

        //Assert.assertTrue(cp.isConfirmationMessageBoxDisplayed());
    }
}
