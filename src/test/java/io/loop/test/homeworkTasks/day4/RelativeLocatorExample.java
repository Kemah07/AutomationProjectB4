package io.loop.test.homeworkTasks.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // Let's assume we have two elements: 'elementA' and 'elementB'
        WebElement elementA = driver.findElement(By.className("gLFyf"));

        // Using relative locators to find elementB below elementA
        WebElement elementB = driver.findElement(RelativeLocator.with(By.tagName("button")).below(elementA));

        // Interact with elementB (for example, clicking it)
        elementB.click();

        driver.quit();
    }
}
