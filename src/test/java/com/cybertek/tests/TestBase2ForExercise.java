package com.cybertek.tests;


import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase2ForExercise {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);

        driver.get(ConfigurationReader.get("url"));


       /* String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        driver.findElement(By.name("_username")).sendKeys(username);
        driver.findElement(By.cssSelector("[type='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("#_submit")).click();
        */

        LoginPage.loginAsUser("storemanager");

        Thread.sleep(6000);

        //locate the Fleet module
        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]"));
        actions.moveToElement(fleet).perform();

        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Vehicle Contracts')]")).click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract";

        Assert.assertEquals(actualURL,expectedURL,"verify that URL is correct");
        WebElement header = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertTrue(header.isDisplayed());



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       // Driver.closeDriver();
    }

}
