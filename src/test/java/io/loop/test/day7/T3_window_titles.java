package io.loop.test.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class T3_window_titles extends TestBase {

    @Test
    public void windowHandleTitles() {

        driver.get("http://www.google.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.loopcamp.io");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.yahoo.com");

        System.out.println("driver.getTitle() = " + driver.getTitle());

//        Set<String> windowHandles = driver.getWindowHandles();
//        for (String eachWindow : windowHandles) {
//            driver.switchTo().window(eachWindow);
//
//            if (driver.getTitle().contains("Amazon")) {
//                break;
//            }
//        }

       // BrowserUtils.switchWindowAndValidate(driver, "google.com", "Google");

        BrowserUtils.switchToWindow(driver, "Google");
    }

}
