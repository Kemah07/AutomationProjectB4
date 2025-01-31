package io.loop.test.homeworkTasks.day6;

/*
go to http://the-internet.herokuapp.com/dropdown
validate "Please select an option" is selected by default
Choose option 1 and validate that it is selected
Choose option 2 and validate that it is selected
Validate dropdown name is "Dropdown List"
 */


import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 extends TestBase {



    @Test
    public void task1() {

        driver.get("http://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select dropDown = new Select(dropdown);

        String expected = "Please select an option";

        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), expected, "Actual does Not match expected");


        expected = "Option 1";
        dropDown.selectByIndex(1);

        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), expected, "Actual does Not match expected");


        expected = "Option 2";
        dropDown.selectByVisibleText("Option 2");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), expected, "Actual does Not match expected");



        WebElement dropDownList = driver.findElement(By.tagName("h3"));

        expected = "Dropdown List";
        Assert.assertEquals(dropDownList.getText(), expected, "Actual does Not match expected");






    }


}
