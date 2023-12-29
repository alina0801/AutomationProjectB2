package com.loop.test.day10_upload_download;

import com.google.j2objc.annotations.Weak;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

/*
 1. Go to “http://demo.guru99.com/test/upload”
 2. Upload file into Choose File
 3. Click terms of service check box
 4. Click Submit File button
 5. Validate expected message appeared. Expected: “1 file has been successfully uploaded.
  */
public class T1_upload {
  /*Windows:

#1- Right click on the file
#2- Select "properties"
#3- Go to "Security" tab
#4- Get the path from "Object name"

For windows, either double backward "\" or single forward "/" works.
Mac:

#1- Right click on the file
#2- Press and hold "option" button from keyboard
#3- Select "copy file as path name" option
#4- Paste into IntelliJ

   */
    @Test
    public void upload_file(){
        Driver.getDriver().get(ConfigurationReader.getProperty("guru.url"));
        WebElement chooseFile = Driver.getDriver().findElement(By.id("uploadfile_0"));
        String path = "/Users/akhramenkova/Desktop/ALINA/note.txt";
        chooseFile.sendKeys(path);
        WebElement checkBox = Driver.getDriver().findElement(By.id("terms"));
        checkBox.click();
        WebElement submitButton = Driver.getDriver().findElement(By.id("submitbutton"));
        submitButton.click();
        WebElement successMessage = Driver.getDriver().findElement(By.id("res"));
        String expectedMessage = "1 file\nhas been successfully uploaded.";
        assertEquals(successMessage.getText(), expectedMessage);
        // Driver.closeDriver();

    }
    
}
