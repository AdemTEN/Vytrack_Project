package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW1_TestCase2 {

    public static void main(String[] args) {

        /*
        Go to Ebay
        search Selenium
        click on search button
        verify title contains Selenium
        */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        String product = "selenium";

        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys(product);

        WebElement searchButton = driver.findElement(By.xpath("//td[@class='gh-td gh-sch-btn']/input"));
        searchButton.click();

        String expectedResult = "Selenium";
        String actualResult = driver.getTitle();

        if(actualResult.contains(product.toLowerCase())){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("actualResult = " + actualResult);
        }

    }
}
