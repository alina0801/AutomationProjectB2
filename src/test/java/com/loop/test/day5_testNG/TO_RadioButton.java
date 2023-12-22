package com.loop.test.day5_testNG;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/*
    https://demoqa.com/radio-button
    wait implicitly 10 seconds
 */
public class TO_RadioButton {
    public static void main(String[] args) throws InterruptedException {
        /*
        https://demoqa.com/radio-button
        wait implicitly 10 seconds
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");
        // wait the whole page loads - selenium 3
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // wait the whole page load - selenium 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement red = driver.findElement(By.xpath("//input[@id='red']"));
        WebElement green = driver.findElement(By.xpath("//input[@id='green']"));

        // isSelected()

        System.out.println(red.isSelected() + " before clicking");  // false because blue is selected by default
        red.click();
        Thread.sleep(3000);
        System.out.println(red.isSelected() + " after clicking");   // true because we clicked
        green.click();

        //isEnabled
        System.out.println(red.isEnabled() + " checking if enabled");  //true because its working clickable
        System.out.println(green.isEnabled() + " checking if enabled"); //false because is disabled
    }
}
    