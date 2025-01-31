package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/*
        1. Go to http://the-internet.herokuapp.com/checkboxes
        2. Confirm checkbox #1 is NOT selected by default
        3. Confirm checkbox #2 is SELECTED by default.
        4. Click checkbox #1 to select it.
        5. Click checkbox #2 to deselect it.
        6. Confirm checkbox #1 is SELECTED.
        7. Confirm checkbox #2 is NOT selected.

         */
public class T00_checkbox {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement checkBox1 = driver.findElement(By.xpath("//input/following-sibling::text()[contains(.,'checkbox 1')]/preceding-sibling::input"));


        //  another way of finding web element //form[@id='checkboxes']/input[1] OR         //input[@type='checkbox' and following-sibling::input]

         //input[@type='checkbox']/following-sibling::br    OR //input[@type = 'checkbox' and following-sibling::text()[contains(.,'checkbox 1')]]


         checkBox1.click();

        // 2. Confirm checkbox #1 is NOT selected by default

        if (!checkBox1.isSelected()) {
            System.out.println("Checkbox is not selected");
        } else {
            System.out.println("Checkbox is selected");
        }

        checkBox1.click();

        if (checkBox1.isSelected()) {
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is not selected");
        }

        // //input/following-sibling::text()[contains(.,'checkbox 2')]/preceding-sibling::br/following-sibling::input  checkbox2   or input[@type = 'checkbox' and normalize-space(following-sibling::text())='checkbox2']
    }
}
