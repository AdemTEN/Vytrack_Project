package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.tests.TestBaseForDays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReporter extends TestBase {

    @Test
    public void wrongPasswordTest(){
/*
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
        driver.findElement(By.id("_submit")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
*/
        extentLogger = report.createTest("Wrong PassWord Test");


        LoginPage loginPage = new LoginPage();


        extentLogger.info("Enter username : user1");
        loginPage.usernameInput.sendKeys("user1");

        extentLogger.info("Enter password: somepassword");
        loginPage.passwordInput.sendKeys("somepassword");

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test is Passed");

    }
    @Test
    public void wrongUsernameTest(){

        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter user name: smeusername");
        loginPage.usernameInput.sendKeys("smeusername");

        extentLogger.info("Enter password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click login Button");
        loginPage.loginBtn.click();

        extentLogger.info("verify URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/logina");

        extentLogger.pass("PASSED");
    }

}
