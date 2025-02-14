package io.loop.test.day8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.PizzaOrderWebTablesUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
go to https://loopcamp.vercel.app/web-tables.html

create a method to test given field for a given name
test type
test amount
test date
test street
test city
test state
test zip
test card
test card number
test exp
 */

public class T0_pizza_order extends TestBase {

    @Test
    public void test_pizza_type() {
     driver.get("https://loopcamp.vercel.app/web-tables.html");
     String name = "Samuel Jackson";
     String expectedPizzaType = "Italian";;

     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     String actualPizzaType = PizzaOrderWebTablesUtil.returnAnyFieldValue(driver, name, "Pizza Type");



        System.out.println("actualPizzaType = " + actualPizzaType);
        Assert.assertEquals(actualPizzaType, expectedPizzaType, "Actual does NOT match expected");

    }
}
