
package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ConfirmationPage {
    private WebDriver driver;

    ConfirmationPage(WebDriver x) {
        driver = x;
    }

    private By confirmationMessageBox = By.className("bdc-assurance");

    public boolean isConfirmationMessageBoxDisplayed() {
        try {
            return driver.findElement(confirmationMessageBox).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
