package io.loop.test.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        // web driver is already set up in Selenium 4

        // if you use older version of Selenium 4.21 then you need webdrivermanager and bonigarcia dependency

       WebDriver driver = new ChromeDriver();

       // maximize the window

        driver.manage().window().maximize();

        // navigate to the page
        driver.get("https://www.loopcamp.io/");

        // wait
        Thread.sleep(3000);

        // navigate to the page
        driver.navigate ().to ("https://www.google.com");

        // navigate back
        driver.navigate().back();

        // navigate forward
        driver.navigate().forward();

        // for refreshing the page
        driver.navigate().refresh();

        // quitting the browser

        driver.quit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement dynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
            dynamicElement.click();
        }
        catch (TimeoutException e) {
            System.out.println("Eelment not found within the specified time");
        }

    }


}
