package io.loop.test.homeworkTasks.day7;
/*
 1. go to https://loopcamp.vercel.app/
    2. click "Multiple Windows" link
    3. Validate "Powered by Loopcamp" is displayed
    4. Validate title is "Windows"
    5. Click - click here
    6. Switch to new window and validate title
 */

import io.loop.test.utilities.BrowserUtils;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;


public class Task3 {

    String expected,actual;
    @Test
    public void testWindowHandle() {
        Driver.getDriver().get(ConfigurationReader.getProperties("loop.practice"));

        WebElement multipleWindows = Driver.getDriver().findElement(By.xpath("//a[.='Multiple Windows']"));
        multipleWindows.click();


        WebElement validateWindow = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'Powered')]"));

        expected ="Powered by LOOPCAMP";
        actual = validateWindow.getText();

        Assert.assertEquals(actual, expected, "actual text doesn't match expected");

        Assert.assertEquals(Driver.getDriver().getTitle(), "Windows", "Title doesn't match expected");


        WebElement clickHere = Driver.getDriver().findElement(By.xpath("//a[.='Click Here']"));



        clickHere.click();

       // System.out.println(Driver.getDriver().getTitle());


        String originalWindow = Driver.getDriver().getWindowHandle();




//        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
//
//        for (String each : windowHandles) {
//            System.out.println("each window = " + each);
//            Driver.getDriver().switchTo().window(each);
//        }

        BrowserUtils.switchToWindow(Driver.getDriver(), "New Window");
        System.out.println(Driver.getDriver().getWindowHandles());

        // System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());

       // System.out.println(Driver.getDriver().getTitle());

        Assert.assertEquals(Driver.getDriver().getTitle(), "New Window", "Title doesn't match expected");




    }

}
