package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
    go to docuport app
    identify docuport with css
    get value of the attribute
    validate if it is "Docuport"


    locate:
    username
    password
    login
    with css
    login to docuport
    locate home icon of docuport after login or any other element after login
    validated that you logged in

     */

public class T3_getAttribute_css {
    public static void main(String[] args) throws InterruptedException {

        //go to url

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);

        //identify the logo with css
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));

        String docuport = logo.getDomAttribute("alt");

        System.out.println("docuport = " + docuport);

        if (DocuportConstants.LOGO_DOCUPORT.equals(docuport)) {
            System.out.println("Expected logo: " + DocuportConstants.LOGO_DOCUPORT + " MATCHES with actual logo " + docuport + " =>Test Passed");


        } else {
            System.err.println("Expected DOES NOT match with actual logo =>Test Failed");

        }

        WebElement LoginUsername = driver.findElement(By.cssSelector("input[id='input-14']"));
        LoginUsername.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement LoginPassword = driver.findElement(By.cssSelector("input[id='input-15']"));
        LoginPassword.sendKeys(DocuportConstants.DOCUPORT_PASSWORD);


        WebElement LoginButton = driver.findElement(By.cssSelector("span[class = 'v-btn__content']"));
        LoginButton.click();

        Thread.sleep(3000);

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();


        WebElement afterLoginButton = driver.findElement(By.cssSelector("div[class='v-avatar primary']>span"));


        if (afterLoginButton.isDisplayed()) {
            System.out.println("Expected after login button: " + afterLoginButton.getText() + " => Test Passed");
        } else {
            System.err.println("Expected after login button: " + afterLoginButton.getText() + " => Test Failed");
        }






    }
}
