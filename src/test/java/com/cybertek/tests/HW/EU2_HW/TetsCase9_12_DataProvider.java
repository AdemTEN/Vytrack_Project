package com.cybertek.tests.HW.EU2_HW;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TetsCase9_12_DataProvider {
    /*
    Test case #9
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “200”.
Step 4. Verify that following message is displayed:
“This page returned a 200 status code”


    Test case #10
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “301”.
Step 4. Verify that following message is displayed:
“This page returned a 301 status code”

    Test case #11
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “404”.
Step 5. Verify that following message is displayed:
“This page returned a 404 status code”

    Test case #12
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “500”.
Step 5. Verify that following message is displayed:
“This page returned a 500 status code”
     */

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);


        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. And click on “Status Codes”.
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @AfterMethod
    public  void closeBrowser(){
        driver.quit();

    }
    @DataProvider(name = "testCase9_12")
    public Object[][] dataTest(){

        return new Object[][] {
                                 {"200"},
                                 {"301"},
                                 {"404"},
                                 {"500"}
                            };
    }

    @Test(dataProvider = "testCase9_12")
    public void testCase9_12(String code ){

        //Step 3. Then click on “code”.
        driver.findElement(By.linkText(code)).click();
        String expectedResult = "This page returned a " +code+ " status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";


        //Step 4. Verify that following message is displayed: “This page returned a code status code.”
        Assert.assertTrue((driver.findElement(By.xpath("//*[@class='example']/p")).getText()).contains(expectedResult));



        /*
        @param code
     * @param message
     * @throws InterruptedException

        @Test(dataProvider = "getData")
        public void statCodes(String code, String message) throws InterruptedException {
            driver.findElement(By.linkText(code)).click();
            String msg = driver.findElement(By.tagName("p")).getText();
            boolean contains = msg.contains(message);
            Assert.assertTrue(contains);
        }

        @DataProvider
        public Object[][] getData() {

            Object[][] data = new Object[4][2];
            //first column = > error code
            //second column => er¬ror message

            // test case 9
            data[0][0] = "200";
            data[0][1] = "This page returned a 200 status code";

            // test case 10
            data[1][0] = "301";
            data[1][1] = "This page returned a 301 status code";

            // test case 11
            data[2][0] = "404";
            data[2][1] = "This page returned a 404 status code";

            // test case 12
            data[3][0] = "500";
            data[3][1] = "This page returned a 500 status code";
            return data;
        }
         */
    }



}
