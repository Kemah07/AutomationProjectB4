package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class T1_window extends TestBase {
        /*
    1. Open a chrome browser
    2. Go to : http://the-internet.herokuapp.com/windows
    3. Assert: Title is “The Internet”
    4. Click to: “Click Here” link
    5. Switch to new Window.
    6. Assert: Title is “New Window”
     */

    @Test
    public void testWindow() {
        driver.get("http://the-internet.herokuapp.com/windows");

        assertEquals(driver.getTitle(), "The Internet", "Results are NOT matching");

        System.out.println(driver.getWindowHandles() + ": this is windows's unique ID");



        WebElement clickHere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        clickHere.click();
        System.out.println("driver.getTitle() = " + driver.getTitle());


        //here I get the original window handle and assign it to String
        String originalWindow = driver.getWindowHandle();
        //driver.switchTo().window(originalWindow);
        // here i get all window handles
        Set<String> windowHandles = driver.getWindowHandles(); //the windowHandles is that element that will allow to jump from one window to the next one

        for (String each : windowHandles) {
            System.out.println("each window handle " + each);
            driver.switchTo().window(each);
        }



        System.out.println("driver.getTitle() = " + driver.getTitle());

        driver.switchTo().window(originalWindow); //switching back to the original one
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @Test
    public void selenium4_window() {
        driver.get("http://the-internet.herokuapp.com/windows");

        // opening a new tab

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.loopcamp.io");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");

    }
}
