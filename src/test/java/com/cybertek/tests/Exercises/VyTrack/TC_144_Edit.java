package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.pages.CreateVehicleContractPage;
import com.cybertek.pages.GeneralInformationPage;
import com.cybertek.pages.VehicleContractsPage;
import com.cybertek.tests.TestBase;
import com.cybertek.tests.TestBase2ForExercise;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TC_144_Edit extends TestBase {

    @Test
    public  void tc144() throws InterruptedException {
        VehicleContractsPage vehicleContractsPage = new VehicleContractsPage();

        String numberOfPage = vehicleContractsPage.numberOfPage.getText();

        String [] pagenumber = numberOfPage.split(" ");

        System.out.println("Arrays.toString(pagenumber) = " + Arrays.toString(pagenumber));

        int number = Integer.parseInt(pagenumber[1]);
        System.out.println("number = " + number);
        extentLogger.info("Click the next Button 'number of page -1' times");

        for (int i = 1; i < number ; i++) {
            BrowserUtils.clickWithJS(vehicleContractsPage.nextButton);
        }
        vehicleContractsPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.hover(vehicleContractsPage.threepoint);
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(vehicleContractsPage.editIcon);

        CreateVehicleContractPage createVehicleContractPage = new CreateVehicleContractPage();
        createVehicleContractPage.responsible.clear();
        createVehicleContractPage.responsible.sendKeys("Schumaher");

        BrowserUtils.clickWithJS(createVehicleContractPage.saveAndCloseButton);

        GeneralInformationPage generalInformationPage = new GeneralInformationPage();
        BrowserUtils.waitFor(2);
        String header = "Schumaher Mclaren Hamilton 25250";
        Assert.assertTrue(generalInformationPage.getHeaderOfContract(header).getText().contains("Schumaher"));
        Assert.assertEquals(generalInformationPage.nameOfResponsible.getText(),"Schumaher");


    }



}
