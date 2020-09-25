package com.cybertek.tests.HW.EU2_HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase6 {

    /*
    Test case #6
    Step 1. Go to "https://www.tempmailaddress.com/"
    Step 2. Copy and save email as a string.
    Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
    Step 4. And click on “Sign Up For Mailing List".
    Step 5. Enter any valid name.
    Step 6. Enter email from the Step 2.
    Step 7. Click Sign Up
    Step 8. Verify that following message is displayed:
    “Thank you for signing up. Click the button below toreturn to the home page.”
    Step 9. Navigate back to the “https://www.tempmailaddress.com/”
    Step 10. Verify that you’ve received an email from“do-not-reply@practice.cybertekschool.com”
    Step 11. Click on that email to open it.
    Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
    Step 13. Verify that subject is: “Thanks for
    subscribing to practice.cybertekschool.com!”
     */

    WebDriver driver ;
    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeDriver(){
        // driver.quit();
    }

    @Test
    public void test6() throws InterruptedException {

        //Step 1. Go to "https://www.tempmailaddress.com/"
        driver.get("https://www.fakemail.net/");

        //    Step 2. Copy and save email as a string.
        String email = driver.findElement(By.id("email")).getText();
        System.out.println(email);

        //    Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //    Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        //    Step 5. Enter any valid name.
        driver.findElement(By.cssSelector("[name='full_name']")).sendKeys("Marco");

        //    Step 6. Enter email from the Step 2.
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);

        //    Step 7. Click Sign Up
        driver.findElement(By.cssSelector("[name='wooden_spoon']")).click();

        //    Step 8. Verify that following message is displayed:“Thank you for signing up. Click the button below to return to the home page.”
        String actualMessage = driver.findElement(By.tagName("h3")).getText();
        String expextedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actualMessage,expextedMessage,"verify that message is displayed");

        //    Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.get("https://www.fakemail.net/");

        //    Step 10. Verify that you’ve received an email from“do-not-reply@practice.cybertekschool.com”
        WebElement actualEmail = driver.findElement(By.cssSelector("#schranka"));
        String emailsText = actualEmail.getText();
        Assert.assertTrue(emailsText.contains("do-not-reply@practice.cybertekschool.com"));

        //    Step 11. Click on that email to open it.
        WebElement email_do_not = driver.findElement(By.xpath("//span[text()='do-not-reply@practice.cybertekschool.com']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",email_do_not);

        //    Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
        WebElement EmailAdress = driver.findElement(By.id("odesilatel"));
        String actualEmailAdress = EmailAdress.getText();
        String expectedEmailAdress = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualEmailAdress,expectedEmailAdress);

        //    Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        WebElement subject = driver.findElement(By.id("predmet"));
        String actualSubject = subject.getText();
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualSubject,expectedSubject);



    }
}
