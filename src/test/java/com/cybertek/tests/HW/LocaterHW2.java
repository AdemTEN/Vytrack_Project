package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocaterHW2 {

    public static void main(String[] args) {

        /*
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        3. Locate all the WebElements on the page using XPATH locator only (total of 6)
            a. “Home” link
            b. “Forgot password” header
            c. “E-mail” text
            d. E-mail input box
            e. “Retrieve password” button
        4.Print text of a,b,c,e and put some email to d
         */

        //open Chrome Browser

        String [] webBrowser = {"chrome", "firefox", "edge"};
        for(String val : webBrowser) {
            System.out.println("TEST BROWSER = " + val);
            WebDriver driver = WebDriverFactory.getDriver(val);

            //Go to http://practice.cybertekschool.com/forgot_password
            driver.get("http://practice.cybertekschool.com/forgot_password");
            driver.manage().window().maximize();

            //Locate all the WebElements on the page using XPATH locator only (total of 6)
            //“Home” link
            WebElement homeLink = driver.findElement(By.xpath("//a[text()='Home']"));

            //“Forgot password” header
            WebElement forgotPassword = driver.findElement(By.xpath("//h2[contains(text(), 'Forgot')]"));

            //“E-mail” text
            WebElement emailText = driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/label"));

            //E-mail input box
            WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='text'][@name='email']"));

            //“Retrieve password” button
            WebElement retrievePasswordButton = driver.findElement(By.xpath("//button[@id='form_submit']/i"));

            //Print text of a,b,c,e  put some email to d
            System.out.println("homeLink = " + homeLink.getText());
            System.out.println("forgotPassword = " + forgotPassword.getText());
            System.out.println("emailText = " + emailText.getText());
            System.out.println("retrievePasswordButton = " + retrievePasswordButton.getText());

            //put some email to d
            String email = "mike@cybertek.com";
            emailInputBox.sendKeys(email);

            WebElement poweredBy = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
            System.out.println("poweredBy = " + poweredBy.getText());

            //print only Cybertek
            WebElement onlyCypertek = driver.findElement(By.xpath("//a[contains(text(),'Cybertek School')]"));
            System.out.println("onlyCypertek.getText() = " + onlyCypertek.getText());

            //print only poweredBy
            String[] arr = poweredBy.getText().split("Cy");
            System.out.println("Only poweredBy= " + arr[0].trim());
            driver.quit();

        }
    }


}
