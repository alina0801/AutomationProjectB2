package com.loop.test.day6_alerts_iframes;

import com.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/*/*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed


     */
public class T1Alerts extends TestBase {
    @Test
    public void informationAlert() {

        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickForJSAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You successfully clicked an alert";
        String actual = successMessageForInformationAlert.getText();
        assertEquals(actual, expected, "actual does not match the expected");

    }

    @Test
    public void confirmationAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
        clickForJSConfirm.click();
        driver.switchTo().alert().accept(); //will click ok and accept
        WebElement successMessageForConfirmationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You click: Ok";
        String actual = successMessageForConfirmationAlert.getText();
        assertEquals(actual, expected, "Actual does not match the expected");
    }

    @Test
    public void promptAlert() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickJSPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
        clickJSPrompt.click();

        String text = "Loop Academy";

//        driver.switchTo().alert().sendKeys(text);
//        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        WebElement successMessagePromptAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessagePromptAlert.getText();
        String expected = "You entered: " + text;
        // Check that a variable is an expected value. The variable's value will be converted to a string for comparison. The test will stop if the assert fails.
                assertEquals(actual, expected, "actual does not match the expected");
    }
}
