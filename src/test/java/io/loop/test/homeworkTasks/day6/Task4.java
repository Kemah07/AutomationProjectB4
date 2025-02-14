package io.loop.test.homeworkTasks.day6;
/*
go to https://demoqa.com/nestedframes
Validate "Child Iframe" text
Validate "Parent Iframe" text
Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."
 */

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task4 extends TestBase {

    String expected, actual;

    @Test
    public void setUpIframe ()throws InterruptedException{
        driver.get("https://demoqa.com/nestedframes");


        driver.switchTo().frame("frame1"); //by //iframe[@id='frame1']
        Thread.sleep(300);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));

        // Validate "Child Iframe" text
        WebElement childIframeText = driver.findElement(By.xpath("//p[.='Child Iframe']"));
        actual=childIframeText.getText();
        expected ="Child Iframe";
        Assert.assertEquals(actual,expected, "Actual " + actual +  "DOES NOT match the expected " + expected + "=> Test Failed");

        // switching back to parent iframe
        driver.switchTo().parentFrame();

        WebElement parentIframeText = driver.findElement(By.xpath("//body[.='Parent frame']"));

        String actual = parentIframeText.getText();
        String expected = "Parent frame";
        Assert.assertEquals(actual,expected, "Actual " + actual +  "DOES NOT match the expected " + expected + "=> Test Failed");

        driver.switchTo().defaultContent();

        WebElement sampleNestedIframe = driver.findElement(By.xpath("//div[contains(text(),'Sample Nested Iframe page.')]"));
        Thread.sleep(300);
        actual = sampleNestedIframe.getText();
        expected = "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";

        Assert.assertEquals(actual,expected, "Actual " + actual +  "DOES NOT match the expected " + expected + "=> Test Failed");

        driver.switchTo().frame("frame1");

        List<WebElement> iframes = driver.findElements(By.tagName("Iframe"));

        System.out.println("iframes.size() = " + iframes.size());


    }

}
