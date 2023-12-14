package com.loop.test.day5_testNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class Test1_TestNG_Intro {
    @BeforeClass // run just once
    public void setUPp(){
        System.out.println("Before class is running");
    }
    @AfterClass   // run just once
    public void tearDown(){
        System.out.println("After class is running");
    }


        @BeforeMethod //annotation
            public void setUpMethod(){
        System.out.println("Before method is running");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running");
        
    }

  @Test (priority = 1)
  public void test1(){
      System.out.println("TestNG is running");
      String actual = "Feyruz";
      String expected = "Feyruz";

      //using assertion instead of if/else statements

      Assert.assertEquals(actual, expected, "Message from Assertion, will be displayed ONLY, when the test will fail");

  }

  @Test (priority = 2)
    public void test2(){
      System.out.println("test2 is running");
  }
}
