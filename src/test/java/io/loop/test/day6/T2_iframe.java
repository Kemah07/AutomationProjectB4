package io.loop.test.day6;

    /*
    1- Open a chrome browser
    2- Go to: https://loopcamp.vercel.app/iframe.html
    3- Clear text from comment body
    4- Type "Loop Academy" in comment body
    5- Verify "Loop Academy" text is written in comment body
    6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
     */


import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T2_iframe extends TestBase {

@Test
    public void iframeTest() {
    driver.get("https://loopcamp.vercel.app/iframe.html");
//    WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")); // with xpath
//    driver.switchTo().frame(iframe);

//    driver.switchTo().frame(0); // with index
    driver.switchTo().frame("mce_0_ifr");  //with id of the Iframe

    WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
    textBox.clear();
    textBox.sendKeys("Loop Academy");
    Assert.assertEquals(textBox.getText(), "Loop Academy", "Actual is NOT matching with the expected");

    driver.switchTo().defaultContent();

    WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame')]"));
    Assert.assertTrue(header.isDisplayed(), "The header is not displayed");




//        WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame')]"));
//        System.out.println(header.getText());
//        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
//        System.out.println("textBox = " + textBox);

}

@Test
public void nestedFrame(){
    driver.get("https://loopcamp.vercel.app/nested-frames.html");
    List<WebElement> iframes;
    iframes = driver.findElements(By.xpath("//frame"));
    System.out.println("iframes.size() = " + iframes.size());
}
}
