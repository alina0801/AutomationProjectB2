package com.loop.test.day4_xpath_findelement;

/*
 * verify forget password
 * identify reset password heading using css and go from parent to child
 */

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;

public class T0_forget_password {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app/");

        // do everything manually first
        // verify forget password link

        // forgot the password link:

        WebElement forgetPasswordLink = driver.findElement(By.cssSelector("a[href='/reset-password']"));
        forgetPasswordLink.click();

        // in css from parent to child --> we use ">"h1 ---> div(tag) [class(attribute)='login-layout__form(value)']>h1")

        //!!!!!! we cant go from child to parent in css!!!!!!!
        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class='login-layout__form']>h1"));
        System.out.println("forgetPasswordHeading = " + forgetPasswordHeading.getText());



    }
}
