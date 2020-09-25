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

public class HoverTest {
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

    /**
     * hover over each image in the website
     * verify each name:user text is displayed
     */

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");
        //System.out.println(driver.findElement(By.xpath("(//h5)[1]")).getText());

        List<WebElement> images = driver.findElements(By.cssSelector("[src='/img/avatar-blank.jpg']"));
        System.out.println("images.size() = " + images.size());
        List<WebElement> userNames = driver.findElements(By.tagName("h5"));
        //System.out.println(userNames.get(0).getAttribute("innerHTML"));
        System.out.println("userNames.size() = " + userNames.size());

        Actions actions = new Actions(driver);


        String expectedResult = "name: user";
        String actualResult = "";
        for (int i = 0; i < images.size(); i++) {
            expectedResult = "name: user" + (i + 1);
            //  hover over each image in the website
            actions.moveToElement(images.get(i)).perform();

            actualResult = userNames.get(i).getAttribute("innerHTML");
            System.out.println("actualResult = " + actualResult);
            Assert.assertEquals(actualResult, expectedResult, "verify that user names are correct");
            //verify each name:user text is displayed
            Assert.assertTrue(userNames.get(i).isDisplayed(), "verify that user names are displayed");

        }


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i <= 3; i++) {

            String xpathImg = "(//img)[" + i + "]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textXpath = "//h5[.='name: user" + i + "']";
            WebElement text1 = driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            Assert.assertTrue(text1.isDisplayed(), "verify user " + i + " is displayed");

        }
    }
}

