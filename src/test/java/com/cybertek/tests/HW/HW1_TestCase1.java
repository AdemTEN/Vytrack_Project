package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW1_TestCase1 {

    public static void main(String[] args) throws InterruptedException {

        /*
        Go to Ebay
        enter search term
        click on search button
        print number of results
         */

        //open chrome browser and go to Ebay
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        //enter search Term
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("computer");
        Thread.sleep(3000);

        //click on search Button
        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        searchButton.click();
        Thread.sleep(3000);

        //print result
        WebElement result = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        System.out.println("Result = " + result.getText());

        WebElement numberOfResult = driver.findElement(By.xpath("(//span[contains(text(), '32,')])[3]"));
        System.out.println(numberOfResult.getText());


        WebElement searchterm = driver.findElement(By.xpath("//span[text()='computer']"));
        System.out.println(searchterm.getText());

        driver.quit();


    }
}
