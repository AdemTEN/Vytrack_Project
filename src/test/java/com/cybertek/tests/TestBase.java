package com.cybertek.tests;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VehicleContractsPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));

        LoginPage.loginAsUser("storemanager");

        DashboardPage dashboardPage = new DashboardPage();
        //verify user name
        Assert.assertEquals(dashboardPage.getUserName(),"Judy Gerhold");

        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");
        BrowserUtils.waitFor(3);

        VehicleContractsPage vehicleContractsPage = new VehicleContractsPage();
        //verify Vehicle Contract Page subtitle
        Assert.assertEquals(vehicleContractsPage.getPageSubTitle(),"All Vehicle Contract","verify subtitle");




    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //Driver.closeDriver();
    }

}