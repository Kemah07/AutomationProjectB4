package io.loop.test.homeworkTasks.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.ExecutionException;

/*
Practice tasks
==============


Task 1
================
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Validate title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Validate title equals:
Expected: Google

 */
public class Task1Gmail {
    public static void main(String[] args) {

      // Open a chrome browser
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

       // Go to: https://google.com
        driver.get("https://google.com");

        // locating web element

        WebElement gmailButton = driver.findElement(By.xpath("//a[contains(text(),'Gmail')]"));
        gmailButton.click();



        // Validate to see if the page contains Gmail

        String expectedTitle = "Gmail";

        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("ActualTitle matches ExpectedTitle --> TEST Passed");
        } else {
            System.out.println("ActualTitle Does NOT match ExpectedTitle --> TEST FAILED");
        }

       // Go back to Google by using the .back();

        driver.navigate().back();

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if (actualGoogleTitle.contains(expectedGoogleTitle)) {
            System.out.println("ActualGoogleTitle matches ExpectedGoogleTitle --> TEST Passed");
        } else {
            System.out.println("ActualGoogleTitle Does NOT match ExpectedGoogleTitle --> TEST FAILED");
        }


        driver.quit();

    }
}
