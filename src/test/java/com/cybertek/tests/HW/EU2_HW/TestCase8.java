package com.cybertek.tests.HW.EU2_HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase8 {

    /*
    Test case #8
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. And click on “Autocomplete”.
    Step 3. Enter “United States of America” into country input box.
    Step 4. Verify that following message is displayed: “You selected: United States of America
     */


    WebDriver driver ;


    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeDriver(){
        // driver.quit();
    }

    @Test
    public void test7(){

        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. And click on “Autocomplete”.
        driver.findElement(By.linkText("Autocomplete")).click();

        //Step 3. Enter “United States of America” into country input box.
        driver.findElement(By.cssSelector("#myCountry")).sendKeys("United States of America");
        driver.findElement(By.tagName("strong")).click();
        driver.findElement(By.cssSelector("[value='Submit']")).click();

        //Step 4. Verify that following message is displayed: “You selected: United States of America
        String actualResult = driver.findElement(By.cssSelector("#result")).getText();
        String expectedResult = "You selected: United States of America";
        Assert.assertEquals(actualResult,expectedResult," verify that result is 'You selected: United States of America'");

    }
}
