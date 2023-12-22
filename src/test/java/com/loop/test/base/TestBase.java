package com.loop.test.base;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
      @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}
