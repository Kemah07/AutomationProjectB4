package io.loop.pages;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDragDropPage {

    public LoopPracticeDragDropPage() {   // creating public constructor
        PageFactory.initElements(Driver.getDriver(), this); // it comes from selenium, implementing page factory to initialize
        // element (the purpose is not to call driver to find element each time and we'll do the as following)
    }

    @FindBy (xpath = "//div[@id='draggable']")
    public WebElement smallCircle;

    @FindBy (xpath = "//div[@id = 'droptarget']")
    public WebElement bigCircle;

}
