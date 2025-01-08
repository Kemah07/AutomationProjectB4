package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsExample {
    public static void main(String[] args) {

        // create an object of chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        // add argument to that option
        //chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-gpu");



        // start chrome with that option
        WebDriver driver = new ChromeDriver(chromeOptions);

        // navigate
        driver.get("https://www.google.com/");
    }
}
