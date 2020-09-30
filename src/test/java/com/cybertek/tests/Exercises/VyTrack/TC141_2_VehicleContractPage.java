package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListResourceBundle;

public class TC141_2_VehicleContractPage extends TestBase {

    @DataProvider(name= "contract")
    public Object [][] enterData(){

        return new Object[][]{
                {"Mike Smith", "250", "50","15000","Apr 12, 2020","May 12, 2020","Sep 12, 2020", "Mclaren", "Hamilton","25250", "extra information" }
        };
    }

    @Test(dataProvider = "contract")
    public void testCase141(String responsible, String activationCost, String costAmount, String odomater,
                            String invoiceDate, String  startDate, String ExpirationDate,   String  vendor, String Driver, String contract, String terms){
        LoginPage.loginAsUser("storemanager");



        DashboardPage dashboardPage = new DashboardPage();
        //verify user name
        Assert.assertEquals(dashboardPage.getUserName(),"Judy Gerhold");

        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");

        VehicleContractsPage vehicleContractsPage = new VehicleContractsPage();
        //verify Vehicle Contract Page subtitle
        Assert.assertEquals(vehicleContractsPage.getPageSubTitle(),"All Vehicle Contract","verify subtitle");

        //click Create Vehicle Contract button
        BrowserUtils.clickWithJS(vehicleContractsPage.createVehicleContract);

        CreateVehicleContractPage createVehicleContractPage = new CreateVehicleContractPage();

        //verify header of Create Vehicle Page
        Assert.assertEquals(createVehicleContractPage.headerOfPage.getText(),"Create Vehicle Contract","verify header");

        //verify type Options
        Select typeDropdown = createVehicleContractPage.typeOptionsList();
        List<WebElement> typeOptions = typeDropdown.getOptions();

        for (WebElement typeOption : typeOptions) {
            System.out.println("typeOption.getText() = " + typeOption.getText());
        }

        List<String> expectedTypeList = Arrays.asList("","Leasing", "Personal Loan", "Credit Card", "Cash");

        List<String> actualTypeList = BrowserUtils.getElementsText(typeOptions);

        Assert.assertEquals(actualTypeList,expectedTypeList,"verify type options");
        //select Credit Card
        typeDropdown.selectByVisibleText("Credit Card");
        //verify Credit Card is selected
        Assert.assertTrue(createVehicleContractPage.creditCardOption.isSelected());

        createVehicleContractPage.responsible.sendKeys(responsible);
        createVehicleContractPage.activationCost.sendKeys(activationCost);




    }


}
