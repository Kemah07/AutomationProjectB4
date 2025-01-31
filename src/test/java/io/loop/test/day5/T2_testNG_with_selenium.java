package io.loop.test.day5;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//set up chrome and create driver
// go to google.com
//Assert; title is "Google"

public class T2_testNG_with_selenium {

    WebDriver driver;
    String expected;
    String actual;
@BeforeMethod
    public void setUp() {
    driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
    driver.manage().window().maximize();
}

@AfterMethod
    public void tearDown() {
    driver.close();
}

@Test
    public void googleTitle() {
    driver.get("http://google.com");
    System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
    expected = "Google";
    actual = driver.getTitle();
    Assert.assertEquals(actual, expected, "Actual: " + actual + " does not match expected " + expected);
}

@Test
    public void docuportTitle() {
    driver.get(DocuportConstants.DOCUPORT_TEST);
    System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
    expected = "Docuport";
    actual = driver.getTitle();
    Assert.assertTrue(actual.contains(expected), "Actual: " + actual + " does not match expected " + expected);
}
}
