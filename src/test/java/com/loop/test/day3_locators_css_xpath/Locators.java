package com.loop.test.day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        // setup driver OBJ
        WebDriverManager.chromedriver().setup();

        // create the driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google
        driver.get("https://www.google.com/");


        // maximize the window
        driver.manage().window().maximize();

        // locate the element
        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb"));
        WebElement searchBoxWithName = driver.findElement(By.name("q"));

        // locate aboutLink.click();
        WebElement aboutLink = driver.findElement(By.linkText("About"));
        //              aboutLink.click();

        // create a string what you want to search
        searchBoxWithID.sendKeys("Feyruz is handsome");

        searchBoxWithID.clear();

        String textToSearch = "Loop Academy";
        searchBoxWithID.sendKeys(textToSearch + Keys.ENTER);


        //Gavin, validating if you actually landed in a search for loop academy

        //we are not using line 45 because numbers here will always be changing
        //String expectedURL = "https://www.google.com/search?q=loop+academy&rlz=1C5CHFA_enUS815US815&oq=loop+ac&gs_lcrp=EgZjaHJvbWUqBwgDEAAYgAQyBggAEEUYOTINCAEQLhivARjHARiABDIHCAIQABiABDIHCAMQABiABDIHCAQQABiABDIHCAUQABiABDIHCAYQABiABDIHCAcQABiABDIHCAgQABiABNIBCTY4NDRqMGoxNagCALACAA&sourceid=chrome&ie=UTF-8";

        String actualURL = driver.getCurrentUrl();

        // don't use equals, because numbers will always change
        if (actualURL.contains("Loop")) {
            System.out.println("Actual title contains \"Loop\": " + actualURL + ", matches expected title, => TEST PASS");
        } else {
            System.err.println("Actual title doesn't contains \"Loop\": " + actualURL + ", DOES NOT match expected title, => TEST FAIL");
        }
        String actualTitle = driver.getTitle();

        if (actualTitle.contains("Loop Academy - Google Search")) {
            System.out.println("Actual Title contains \"Loop\"");
        } else {
            System.err.println("\"Actual Title DOES NOT contains \"Loop\"");

        }
    }
}