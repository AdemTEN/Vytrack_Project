package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.pages.CreateVehicleContractPage;
import com.cybertek.pages.VehicleContractsPage;
import com.cybertek.tests.TestBase;
import com.cybertek.tests.TestBase2ForExercise;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_143_Cancellation extends TestBase {

    @Test
    public void tC143_Cancellation(){

        VehicleContractsPage vehicleContractsPage = new VehicleContractsPage();
        BrowserUtils.clickWithJS(vehicleContractsPage.createVehicleContract);

        CreateVehicleContractPage createVehicleContractPage = new CreateVehicleContractPage();
        BrowserUtils.clickWithJS(createVehicleContractPage.cancelButton);
        BrowserUtils.waitFor(2);
        Assert.assertEquals(vehicleContractsPage.getPageSubTitle(),"All Vehicle Contract","verify subtitle");





    }




}
