package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T000_xpath_getText {
    /*
    1. open chrome
    2. go to docuport
    3. click on forgot password
    4. validate url contains: reset-password
    5. validate - Enter the email address associated with your account
    6. enter forgot passwordg1@gmail.com to email box
    7. validate send button is displayed
    8. validate cancel button is displayed
    9. click send button
    10. validate - We have sent you an email with a link to reset your password.Please check your email
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);

        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);
        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();

        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(DocuportConstants.RESET_PASSWORD_URL)) {
            System.out.println("Actual url matches expected URL");

        } else {
            System.out.println("Actual url does not match expected URL");

        }

        WebElement validateMessage = driver.findElement(By.xpath("//*[contains(text(),'Enter the email')]"));

        String actualValidateMessage = validateMessage.getText();

        if(actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");

        }

        // 6. enter forgotpasswordg1@gmail.com to email box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);


        // 7. validate send button is displayed
        // 8. validate cancel button is displayed

        //WebElement cancelButton = driver.findElement(By.xpath("//span[.,'Cancel')]"));
        WebElement cancelButton = driver.findElement(By.xpath("//*[contains(text(),'Cancel')]"));
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));

        if(cancelButton.isDisplayed()){
            System.out.println("Test pass - cancel is displayed");
        } else {
            System.out.println("Test fail - cancel is not displayed");
        }

        if(sendButton.isDisplayed()){
            System.out.println("Test pass - send is displayed");
        } else {
            System.out.println("Test fail - send is not displayed");
        }

        sendButton.click();
        Thread.sleep(3000);

        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));

        Thread.sleep(5000);

        // String actualMessage = successMessage.getText();

        // System.out.println("actualMessage = " + actualMessage);

        try{
            System.out.println(successMessage.getText());
        } catch (StaleElementReferenceException e){
            System.out.println("Element is not there anymore");
        }


    // StaleElementReferenceException  - Element was there but not found because message was disappeared

    }
}
