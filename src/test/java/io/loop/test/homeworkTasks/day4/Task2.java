package io.loop.test.homeworkTasks.day4;

/*
Practice tasks
==============

task 1
=============
1. go to https://loopcamp.vercel.app/forgot-password.html
2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
3. use css
4. Validate those elements are displayed


 */

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        driver.get(LoopCampConstants.LOOPCAMP_FORGETPASSWORD_URL);


        WebElement forgetPassword = driver.findElement(By.tagName("h2"));
        System.out.println("forgetPassword.isDisplayed() = " + forgetPassword.isDisplayed());

        WebElement email = driver.findElement(By.xpath("//label[contains(text(),'E-mail')]"));
        System.out.println("email.isDisplayed() = " + email.isDisplayed());

        WebElement inputEmail = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("inputEmail.isDisplayed() = " + inputEmail.isDisplayed());

        WebElement retrievePassword = driver.findElement(By.xpath("//i[contains (.,'Retrieve password')]"));
        System.out.println("retrievePassword.isDisplayed() = " + retrievePassword.isDisplayed());

        driver.quit();


    }
}
