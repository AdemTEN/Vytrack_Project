package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckboxHW {

    @Test
    public void testCase2() throws InterruptedException {

        /*
        TC #2: SeleniumEasy Checkbox Verification – Section 1
        1.Open Chrome browser
        2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        3.Verify “Success – Check box is checked” message is NOT displayed.
        4.Click to checkbox under “Single Checkbox Demo” section
        5.Verify “Success – Check box is checked” message is displayed.
        */



        String browser = "chrome firefox edge";
        String [] webBrowser = browser.split(" ");
        //System.out.println("Arrays.toString(webBrowser) = " + Arrays.toString(webBrowser));
        for (int i = 0; i<webBrowser.length; i++){

           // 1.Open browsers
            WebDriver driver = WebDriverFactory.getDriver(webBrowser[i]);

            System.out.println("VERIFICATION #" + webBrowser[i]);

            //Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
            driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

            //Verify “Success – Check box is checked” message is NOT displayed.
            WebElement successCheckBox = driver.findElement(By.id("txtAge"));

            System.out.println("successCheckBox.isDisplayed() = " + successCheckBox.isDisplayed());


            Assert.assertFalse(successCheckBox.isDisplayed(), "verify that Success – Check box is checked message is NOT displayed.");

            //Click to checkbox under “Single Checkbox Demo” section
            driver.findElement(By.cssSelector("input#isAgeSelected")).click();

            Thread.sleep(3000);

            //Verify “Success – Check box is checked” message is displayed.
            Assert.assertTrue(successCheckBox.isDisplayed(),"verify that Success – Check box is checked message is  displayed.");

            driver.quit();

        }

    }

    @Test
    public void tesCase3() throws InterruptedException {
       /*
       TC #3: SeleniumEasy Checkbox Verification –Section 2
       1.Open Chrome browser
       2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
       3.Verify “Check All” button text is “Check All”
       4.Click to “Check All” button
       5.Verify all check boxes are checked
       6.Verify button text changed to “Uncheck All”
        */

        String browser = "chrome firefox edge";
        String[] webBrowser = browser.split(" ");
        //System.out.println("Arrays.toString(webBrowser) = " + Arrays.toString(webBrowser));
        for (int i = 0; i < webBrowser.length; i++) {

            // 1.Open browsers
            WebDriver driver = WebDriverFactory.getDriver(webBrowser[i]);

            System.out.println("VERIFICATION #" + webBrowser[i]);

            //Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
            driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

            //Verify “Check All” button text is “Check All”
            WebElement checkAllButton = driver.findElement(By.cssSelector("#check1"));
            System.out.println("checkAllButton.getAttribute(\"value\") = " + checkAllButton.getAttribute("value"));
            String expectedText = "Check All";
            String actualText = checkAllButton.getAttribute("value");
            Assert.assertEquals(actualText, expectedText);

            //Click to “Check All” button
            checkAllButton.click();
            Thread.sleep(3000);

            //Verify all check boxes are checked
            ArrayList<Integer> options = new ArrayList<Integer>(Arrays.asList(2,3,4,5));

            for(int j =0; j<options.size();j++){
                Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='checkbox']/label/input)["+ options.get(j)+"]")).isSelected());
            }

            //Verify button text changed to “Uncheck All”
            WebElement uncheckAllButton = driver.findElement(By.cssSelector("[id='check1'][value='Uncheck All']"));
            String expectedText2 = "Uncheck All";
            String actualText2 = uncheckAllButton.getAttribute("value");
            Assert.assertTrue(expectedText2.equals(actualText2));

            driver.quit();

        }
    }

}
