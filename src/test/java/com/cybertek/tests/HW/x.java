package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class x {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void Test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        List<WebElement> figures = driver.findElements(By.xpath("//div[@class='figure']"));
        int figureSize = figures.size();
        Actions action = new Actions(driver);
        int count = 1;
        first:
        for (WebElement element : figures) {
            if (count <= figureSize) {
                String str = "(//h5)["+count+"]";
                action.moveToElement(element).perform();
                WebElement name = driver.findElement(By.xpath(str));
                Assert.assertTrue(name.isDisplayed(), "verify that name is displayed");
                count++;
            } else {
                break first;
            }
        }
    }
}

