package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {
    public static void main(String[] args) {
        // creating driver object
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // navigate to loopcamp practice page
        driver.get("https://loopcamp.vercel.app/registration_form.html");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("John");
        WebElement className = driver.findElement(By.className("form-control"));
        //className.sendKeys("Loop");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Camp");

        WebElement female = driver.findElement(By.name("gender"));
        female.click();

    }
}
