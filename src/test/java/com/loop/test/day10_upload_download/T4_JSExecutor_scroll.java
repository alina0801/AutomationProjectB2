package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class T4_JSExecutor_scroll {

    //we can scroll with javascript executor
    @Test
    public void etsy_scroll_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy"));
        WebElement emailBox = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));

        //how to scroll to element
        //#1 use actions move to element

        Actions action = new Actions(Driver.getDriver());
       // action.moveToElement(emailBox).perform();
        action.scrollToElement(emailBox).perform();

        //#2 just use Key Press
        //action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //#3 move horizontally or vertically

        js. executeScript("window.scroll(0,5000)");
        //4
        js.executeScript("arguments[0].scrollIntoView(true)", emailBox);
        js.executeScript("arguments[0].click", emailBox);

    }


}
