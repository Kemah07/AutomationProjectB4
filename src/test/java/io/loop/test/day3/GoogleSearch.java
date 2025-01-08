package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Navigate to Google search
 * maximize the page
 * get title of the page
 * get url of the page
 * validate the title, expected title is "Google"
 * validate the url of the page, expected url is "https://www.google.com/"
 * close the browser
 */

public class GoogleSearch {
    public static void main(String[] args) {

        // in selenium 3 we had to set up the driver, for that we need webdrivermanager libraries
        // WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver();

        //navigate to google
        driver.navigate().to("https://www.google.com/");
        //driver.get("https://www.google.com/");

        // maximize
        driver.manage().window().maximize();

        String expectedTitle = "Goodgle";
        String actualTitle = driver.getTitle();
        //System.out.println(ExpectedTitle);

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Actual title: " + actualTitle + " matches expected title: " + expectedTitle + ". => Test Passed");
        } else {
            System.out.println("Actual title: " + actualTitle + " DOES NOT match expected title: " + expectedTitle + ". => Test Failed");
        }


        String expectedUrl = "https://www.google.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Actual url: " + actualUrl + ", matches expected url: " + expectedUrl + ". => TEST PASS");
        }else {
            System.out.println("Actual url: " + actualUrl + ", DOES NOT match expected url: " + expectedUrl + ". => TEST FAIL");
        }

        driver.quit();


    }
}
