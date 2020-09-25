package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW1_TestCase3 {

    public static void main(String[] args) throws InterruptedException {

        /*
        Go to wikipedia.org (Links to an external site.)
        enter search term `selenium webdriver`
        click on search button
        click on search result `Selenium (software)`
        verify url ends with `Selenium_(software)'
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchInput'][@name='search']"));
        searchBox.sendKeys("selenium webdriver");
        Thread.sleep(3000);

        WebElement searchButton = driver.findElement(By.xpath("(//input[@type='hidden'])[3]/../button/i"));
        searchButton.click();
        Thread.sleep(3000);


        WebElement searchResult = driver.findElement(By.xpath("(//span[.='Selenium'])[1]"));
        searchResult.click();
        Thread.sleep(3000);

        String expectedResult = "Selenium_(software)";
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.endsWith(expectedResult)){
            System.out.println("PASS");
        }else
            System.out.println("FAIL");
        System.out.println("expectedResult = " + expectedResult);
        System.out.println("currentUrl = " + currentUrl);

        driver.quit();

    }
}
