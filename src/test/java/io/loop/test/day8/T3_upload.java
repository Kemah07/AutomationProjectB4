package io.loop.test.day8;

    /*
    1. Go to “http://demo.guru99.com/test/upload”
    2. Upload file into Choose File
    3. Click terms of service check box
    4. Click Submit File button
    5. Validate expected message appeared. Expected: “1 file has been successfully uploaded.
    */

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class T3_upload {

    @Test
    public void upload_file() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("guru.url"));

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@type='file']"));
        String path = "/Users/kananmahmudov/Desktop/note from me.";
        chooseFile.sendKeys(path);

        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();

        Thread.sleep(3000);

        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//h3[@id='res']"));

        String expected = "1 file\nhas been successfully uploaded.";
        Assert.assertEquals(expected, successMessage.getText());
    }

}
