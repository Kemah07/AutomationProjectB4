package io.loop.test.day4;
   /*
   https://the-internet.herokuapp.com/forgot_password
     */

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T00_css_isDisplayed {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement forgotPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));

        System.out.println("forgotPasswordHeading: " + forgotPasswordHeading.getText());

        System.out.println("forgotPasswordHeading.isDislpayed() = " + forgotPasswordHeading.isDisplayed());

        if(forgotPasswordHeading.isDisplayed()) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test fail");
        }







    }


}
