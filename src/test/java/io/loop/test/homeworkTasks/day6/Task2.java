package io.loop.test.homeworkTasks.day6;
/*
task2
=============
1. login as an advisor
2. go to received document
3. click search
4. click status dropdown
5. choose in progress
 */

import io.loop.test.base.TestBase;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.DocuportConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2 extends TestBase {

    @Test
    public void task2() throws InterruptedException {

        driver.get(ConfigurationReader.getProperties("docuportBeta"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement loginUsername = driver.findElement(By.xpath("//input[@id='input-14']"));

        loginUsername.sendKeys(DocuportConstants.USERNAME_ADVISOR);

        WebElement loginPassword = driver.findElement(By.xpath("//input[@id='input-15']"));

        loginPassword.sendKeys(DocuportConstants.DOCUPORT_PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath("//span[normalize-space()='Log in']"));

        loginButton.click();


        WebElement receivedDoc =driver.findElement(By.xpath("//h2[contains(.,'Received')]"));
        receivedDoc.click();

        WebElement clickSearch = driver.findElement(By.xpath("((//span[.='Search'])[2])"));
        clickSearch.click();


        WebElement clickStatus = driver.findElement(By.xpath("//label[.='Status']"));
        clickStatus.click();

        WebElement inProgress = driver.findElement(By.xpath("(//div[.='In progress'])[3]"));
        inProgress.click();







    }
}
