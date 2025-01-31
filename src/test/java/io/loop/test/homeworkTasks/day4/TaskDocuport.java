package io.loop.test.homeworkTasks.day4;

/*
task 2
=============
1. login to docuport application
2. logout from docuport application
3. Validate successful login
4. Validate successful logout
 */

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskDocuport {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement loginUsername = driver.findElement(By.xpath("//input[@id='input-14']"));

        loginUsername.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement loginPassword = driver.findElement(By.xpath("//input[@id='input-15']"));

        loginPassword.sendKeys(DocuportConstants.DOCUPORT_PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath("//span[normalize-space()='Log in']"));

        loginButton.click();

        Thread.sleep(3000);

        WebElement continueButton = driver.findElement(By.xpath("//span[normalize-space()='Continue']"));

        continueButton.click();

        WebElement batch1Group3 = driver.findElement(By.xpath("//span[.='Batch1 Group3']"));

        String expectedBatch = "Batch1 Group3";
        String actualBatch = batch1Group3.getText();

        if (!expectedBatch.equals(actualBatch)) {
            System.err.println("Test Failed");
        } else {
            System.out.println("Test Passed");
        }

      batch1Group3.click();

        Thread.sleep(3000);

        WebElement logoutButton = driver.findElement(By.xpath("//span[normalize-space () = 'Log out']"));

        logoutButton.click();

        WebElement docuportlogo = driver.findElement(By.xpath("//img[@src='/img/logo.d7557277.svg']"));


        if (docuportlogo.isDisplayed()) {
            System.out.println("Test Passed");
        } else {
            System.err.println("Test Failed");
        }







    }
}
