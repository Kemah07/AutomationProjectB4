package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/*
        https://loopcamp.vercel.app/radio-buttons.html
        wait implicitly 10 seconds
         */

public class T0_radioButton {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //selenium 3

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //slenium 4

        WebElement red = driver.findElement(By.xpath("//input[@id='red']"));
        WebElement green = driver.findElement(By.xpath("//input[@id='green']"));

        //isSelected()

        System.out.println("red.isSelected() BEFORE CLICKING = " + red.isSelected());
        red.click();
        System.out.println("red.isDisplayed() AFTER CLICKING= " + red.isSelected());

        System.out.println("red.isDisplayed() = " + red.isDisplayed());

        green.click();
        //isEnabled()
        System.out.println("red.isEnabled() = " + red.isEnabled());
        System.out.println("green.isEnabled() = " + green.isEnabled());


    }
}
