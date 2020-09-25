package com.cybertek.tests.HW.EU2_HW;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TestCases1_5WithDataPovider {

    /*
    Test case #1
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    Step 3. Enter “wrong_dob” into date of birth inputbox.
    Step 4. Verify that warning message is displayed:“The date of birth is not valid”
     */

    WebDriver driver ;
    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closeDriver(){
       driver.quit();
    }

    @Test
    public void test1(){

        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();
        //Step 3. Enter “wrong_dob” into date of birth inputbox.
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("wrong_dob");

        // Step 4. Verify that warning message is displayed:“The date of birth is not valid”
        WebElement message = driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));
        Assert.assertTrue(message.isDisplayed(),"verify that warning message  is diyplayed");

        String actualMessage = message.getText();
        String expectedMessage = "The date of birth is not valid";
        Assert.assertEquals(actualMessage, expectedMessage,"verify  whether warning message is'The date of birth is not valid' or not");

    }

    @Test
    public void test2(){

        /*
        Test case #2
        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Verify that following options forprogramming languages are displayed: c++, java,JavaScript
         */

        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();

        List<WebElement> languages = driver.findElements(By.className("form-check-label"));
        System.out.println("languages.size() = " + languages.size());

        String expectedResult = "C++, Java, JavaScript";
        String actualResult = "";
        for (WebElement language : languages) {
           // System.out.println(language.getText());
            actualResult += language.getText() + ", ";

        }
        actualResult = actualResult.substring(0,actualResult.length()-2);

        //Step 3. Verify that following options forprogramming languages are displayed: c++, java,JavaScript
        Assert.assertEquals(actualResult,expectedResult, "verify that languages are displayed: c++, java,\n" +
                "JavaScript");


    }
    @Test
    public void test3(){
        /*
        Test case #3
        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter only one alphabetic character into first name input box.
        Step 4. Verify that warning message is displayed:
        “first name must be more than 2 and less than 64
         characters long”
         */

        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();

        //Step 3. Enter only one alphabetic character into first name input box.
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("a");

        /*
        Step 4. Verify that warning message is displayed
        “first name must be more than 2 and less than 64  characters long”
        */
        WebElement message = driver.findElement(By.xpath("//*[.='first name must be more than 2 and less than 64 characters long']"));

        Assert.assertTrue(message.isDisplayed(),"verify warning message is displayed");

        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        String actualMessage = message.getText();


        Assert.assertEquals(actualMessage,expectedMessage,"verify that warning message is 'first name must be more than 2 and less than 64\n" +
                "characters long'");


    }
    @Test
    public void test4(){
       /*
        Step 1. Go to https://practicecybertekschool.herokuapp.com
        Step 2. Click on “Registration Form”
        Step 3. Enter only one alphabetic character into last name input box.
        Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than
        64 characters long”
        */

        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();

        //Step 3. Enter only one alphabetic character into last name input box.
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("a");

         /*
        Step 4. Verify that warning message is displayed:
        “last name must be more than 2 and less than 64  characters long”
        */
        WebElement warningMessage = driver.findElement(By.xpath("//*[.='The last name must be more than 2 and less than 64 characters long']"));

        Assert.assertTrue(warningMessage.isDisplayed(),"verify tht warning message is displayed");
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
        String actualMessage = warningMessage.getText();

        Assert.assertEquals(actualMessage,expectedMessage, "verify that warning message is 'first name must be more than 2 and less than 64\\n\" +\n" +
                "                characters long'");
    }

    @DataProvider(name = "test5")
    public Object [][] createData1(){
        return new Object[][]{
                {"Marco","Franco","marcfranc","franco@gmail.com","123456789","571-000-0000","10/10/1980"},
                {"Mike","Smith","mikesmth","mikeo@gmail.com","987654321","571-000-0001","10/05/1982"}
        };

    }
    @Test(dataProvider = "test5")
    public void test5(String name,String lastName,String userName,String email,String password,
                      String tlf, String birthday){
        /*
        Test case #5
        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter any valid first name.
        Step 4. Enter any valid last name.
        Step 5. Enter any valid user name.
        Step 6. Enter any valid email adress.
        Step 7. Enter any valid password.
        Step 8. Enter any valid phone number.
        Step 9. Select gender.
        Step 10. Enter any valid date of birth.
        Step 11. Select any department.
        Step 12. Enter any job title.
        Step 13. Select java as a programming language.
        Step 14. Click Sign up.
        Step 15. Verify that following success message isdisplayed: “You've successfully completed
                   registration!”
         */

        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();

        //Step 3. Enter any valid first name.
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys(name);

        //Step 4. Enter any valid last name.
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys(lastName);

        // Step 5. Enter any valid user name.
        driver.findElement(By.cssSelector("[name='username']")).sendKeys(userName);

        //Step 6. Enter any valid email adress.
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);

        //  Step 7. Enter any valid password.
        driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);

        //Step 8. Enter any valid phone number.
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys(tlf);

        //Step 9. Select gender.
        driver.findElement(By.cssSelector("[value='male']")).click();

        //Step 10. Enter any valid date of birth.
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys(birthday);

        //Step 11. Select any department.
        WebElement department= driver.findElement(By.cssSelector("[name='department']"));
        Select selectDepartment = new Select(department);
        selectDepartment.selectByVisibleText("Department of Engineering");

        //Step 12. Enter any job title.
        WebElement jobTitle = driver.findElement(By.cssSelector("[name='job_title']"));
        Select selectJob = new Select(jobTitle);
        selectJob.selectByVisibleText("QA");

        // Step 13. Select java as a programming language.
        driver.findElement(By.id("inlineCheckbox2")).click();

        //Step 14. Click Sign up.
        driver.findElement(By.id("wooden_spoon")).click();

        String actualMessage = driver.findElement(By.cssSelector(".alert.alert-success>p")).getText();
        String expectedMessage = "You've successfully completed registration!";

        //Step 15. Verify that following success message isdisplayed: “You've successfully completed
        //registration!”
        Assert.assertEquals(actualMessage,expectedMessage, "verify that 'You've successfully completed registration!' message is diaplayed ");



    }





}
