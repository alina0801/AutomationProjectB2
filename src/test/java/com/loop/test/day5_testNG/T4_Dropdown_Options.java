package com.loop.test.day5_testNG;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
    1. Open Chrome browser
    2. Go to https://demoqa.com/select-menu
    3. go old style select menu
    4. Select Yellow and validate
    5. Select Red and validate
    6. Select White and validate
    Use all Select options. (visible text, value, index)
     */
public class T4_Dropdown_Options {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // providing url in here , because everything on one page -> one session id
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
     @Test
     public void colorTest(){
        //creating the object of select
         Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
         //parameter is integer ->  find the index starts from 0, don't get confused with the value

         dropdown.selectByIndex(3);
         //after selecting the yellow , i actually getting the selected option and getting text of it and validating if it equals to "YELLOW"
         Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Yellow");

         dropdown.selectByValue("red");
         Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Red");

         dropdown.selectByVisibleText("White");
         Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"White");

     }
}
