package io.loop.test.homeworkTasks.day7;
/*
 go to https://loopcamp.vercel.app/nested-frames.html
    validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

 */

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.TimeUtils;


public class Task1 extends TestBase {


    String actual, expected;
    @Test
    public void validateIframes() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        String xpath = "//*[contains(text(), 'LEFT')]";

        WebElement leftFrame = driver.findElement(By.xpath(xpath));
        expected = "LEFT";
        actual = leftFrame.getText().trim();

        Assert.assertEquals(actual,expected, "Actual " + actual +  "DOES NOT match the expected " + expected + "=> Test Failed");


        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        WebElement middle = driver.findElement(By.xpath("//*[contains(text(),'MIDDLE')]"));
        expected = "MIDDLE";
        actual = middle.getText().trim();

        Assert.assertEquals(actual,expected, "Actual " + actual +  "DOES NOT match the expected " + expected + "=> Test Failed");


        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        WebElement right = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]"));
        expected = "RIGHT";
        actual = right.getText().trim();

        Assert.assertEquals(actual,expected, "Actual " + actual +  "DOES NOT match the expected " + expected + "=> Test Failed");


        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]"));
        expected = "BOTTOM";
        actual = bottom.getText().trim();

        Assert.assertEquals(actual,expected, "Actual " + actual +  "DOES NOT match the expected " + expected + "=> Test Failed");



    }
}
