package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

        // chrome the driver object
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();

        // locating the web element
        WebElement searchBoxWithId = driver.findElement(By.id("APjFqb"));
        WebElement weblink = driver.findElement(By.linkText("About"));
        weblink.click();

        String textToSearch = "Feyruz is the king of Java";
        searchBoxWithId.sendKeys(textToSearch);
        Thread.sleep(2000);
        searchBoxWithId.clear();
        searchBoxWithId.sendKeys("Nadir is the king of Soft skills" + Keys.ENTER);
    }
}
