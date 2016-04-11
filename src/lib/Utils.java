package lib;

import org.openqa.selenium.WebDriver;
import java.util.Iterator;
import java.util.Set;

public class Utils {

    WebDriver driver;

    public Utils(WebDriver x) {
        driver = x;
    }

    public void switchToNewWindow(String parentWindowHandle){
        Set windowHandles = driver.getWindowHandles();
        Iterator iterator = windowHandles.iterator();
        String windowHandle;

        while(iterator.hasNext()) {
            windowHandle = (String)iterator.next();
            if(!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }
}
