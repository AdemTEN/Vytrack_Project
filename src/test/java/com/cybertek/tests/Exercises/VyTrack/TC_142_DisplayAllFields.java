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

public class TC_142_DisplayAllFields extends TestBase {

    @DataProvider(name = "contract")
    public Object[][] enterData() {

        return new Object[][]{
                {"Mike Smith", "250", "50", "15000", "Apr 12, 2020", "May 12, 2020", "Sep 12, 2020", "Mclaren", "Hamilton", "25250","Star Car Maintenance", "extra information"}
        };
    }

    @Test(dataProvider = "contract")
    public void testCase141(String responsible, String activationCost, String costAmount, String odometer,
                            String invoiceDate, String startDate, String expirationDate, String vendor, String Driver, String reference,String service, String termsAndConditions) {

        extentLogger = report.createTest("Creation of Vehicle Contract");

        VehicleContractsPage vehicleContractsPage = new VehicleContractsPage();

        extentLogger.info("click Create Vehicle Contract button");
        BrowserUtils.clickWithJS(vehicleContractsPage.createVehicleContract);

        CreateVehicleContractPage createVehicleContractPage = new CreateVehicleContractPage();

        extentLogger.info("verify header of Create Vehicle Page");
        Assert.assertEquals(createVehicleContractPage.headerOfPage.getText(), "Create Vehicle Contract", "verify header");

        extentLogger.info("verify type Options");
        Select typeDropdown = createVehicleContractPage.typeOptionsList();
        List<WebElement> typeOptions = typeDropdown.getOptions();

        for (WebElement typeOption : typeOptions) {
            System.out.println("typeOption.getText() = " + typeOption.getText());
        }

        List<String> expectedTypeList = Arrays.asList("", "Leasing", "Personal Loan", "Credit Card", "Cash");

        List<String> actualTypeList = BrowserUtils.getElementsText(typeOptions);

        Assert.assertEquals(actualTypeList, expectedTypeList, "verify type options");
        extentLogger.info("select Credit Card");
        typeDropdown.selectByVisibleText("Credit Card");
        extentLogger.info("verify Credit Card is selected");
        Assert.assertTrue(createVehicleContractPage.creditCardOption.isSelected());

        createVehicleContractPage.responsible.sendKeys(responsible);
        createVehicleContractPage.activationCost.sendKeys(activationCost);
        createVehicleContractPage.depreciatedCost.sendKeys(costAmount);

        extentLogger.info("verify Cost Amount Options");
        Select costAmountDropdown = createVehicleContractPage.costAmountOptionsList();
        List<WebElement> costAmountOptions = costAmountDropdown.getOptions();
        for (WebElement costAmountOption : costAmountOptions) {
            System.out.println("costAmountOption.getText() = " + costAmountOption.getText());

        }
        List<String> expectedCostAmountList = Arrays.asList("", "No", "Daily", "Weekly", "Monthly", "Yearly");
        List<String> actualCostAmountOptions = BrowserUtils.getElementsText(costAmountOptions);
        Assert.assertEquals(actualCostAmountOptions, expectedCostAmountList, "verify cost Amount Options");

        costAmountDropdown.selectByVisibleText("Monthly");
        extentLogger.info("verify monthly is selected");
        Assert.assertTrue(createVehicleContractPage.monhtly.isSelected());
        extentLogger.info("Enter informations of input boxes");
        createVehicleContractPage.odometer.sendKeys(odometer);
        createVehicleContractPage.invoiceDate.sendKeys(invoiceDate);
        createVehicleContractPage.startDate.sendKeys(startDate);
        createVehicleContractPage.expirationDate.sendKeys(expirationDate);
        createVehicleContractPage.vendor.sendKeys(vendor);
        createVehicleContractPage.driver.sendKeys(Driver);
        createVehicleContractPage.reference.sendKeys(reference);
        createVehicleContractPage.service.sendKeys(service);
        createVehicleContractPage.termsAndCondition.sendKeys(termsAndConditions);


        extentLogger.info("verify status Options");
        Select statusDropdown = createVehicleContractPage.statusOptionsList();
        List<WebElement> statusOptions = statusDropdown.getOptions();
        List<String> expectedStatusList = Arrays.asList("", "Active", "Archived");

        List<String> actualStatusList = BrowserUtils.getElementsText(statusOptions);
        Assert.assertEquals(actualStatusList, expectedStatusList, "verify status options");

        extentLogger.info("verify Active status is selected");
        statusDropdown.selectByVisibleText("Active");
        Assert.assertTrue(createVehicleContractPage.active.isSelected());
        extentLogger.info("add vehicle models");
        BrowserUtils.clickWithJS(createVehicleContractPage.vehicleModelLink);
        BrowserUtils.clickWithJS(createVehicleContractPage.vehicleModelAdd);

        BrowserUtils.clickWithJS(createVehicleContractPage.firstAssigned);
        Assert.assertTrue(createVehicleContractPage.firstAssigned.isSelected());

        extentLogger.info("select first Model");
        BrowserUtils.clickWithJS(createVehicleContractPage.selectButton);

        extentLogger.info("verify Model Name is displayed");
        Assert.assertTrue(createVehicleContractPage.modelName.isDisplayed());

        BrowserUtils.clickWithJS(createVehicleContractPage.vehicleModelLink);
        BrowserUtils.clickWithJS(createVehicleContractPage.vehicleMakeAdd);

        BrowserUtils.clickWithJS(createVehicleContractPage.firstAssigned);
        Assert.assertTrue(createVehicleContractPage.firstAssigned.isSelected());

        extentLogger.info("select first Make");
        BrowserUtils.clickWithJS(createVehicleContractPage.selectButton);
        extentLogger.info("verify Make is displayed");
        Assert.assertTrue(createVehicleContractPage.make.isDisplayed());
        extentLogger.info("click Save And Close Button");
        BrowserUtils.clickWithJS(createVehicleContractPage.saveAndCloseButton);

        GeneralInformationPage generalInformationPage = new GeneralInformationPage();
        System.out.println("generalInformationPage.headerOfContract.getText() = " + generalInformationPage.headerOfContract.getText());
        extentLogger.info("Verify Contract is Displayed");
        Assert.assertEquals(generalInformationPage.headerOfContract.getText(),"Mike Smith Mclaren Hamilton 25250","verify header");

        extentLogger.info("Go to All Vehicle Contract Page");
        BrowserUtils.clickWithJS(generalInformationPage.vehicleContractLink);
        BrowserUtils.waitFor(2);
        Assert.assertEquals(vehicleContractsPage.getPageSubTitle(),"All Vehicle Contract","verify subtitle");

        extentLogger.info("Get the number of Pages");
        System.out.println("vehicleContractsPage.numberOfPage.getText() = " + vehicleContractsPage.numberOfPage.getText());
        String numberOfPage = vehicleContractsPage.numberOfPage.getText();

        String [] pagenumber = numberOfPage.split(" ");

        System.out.println("Arrays.toString(pagenumber) = " + Arrays.toString(pagenumber));

        int number = Integer.parseInt(pagenumber[1]);
        System.out.println("number = " + number);
        extentLogger.info("Click the next Button 'number of page -1' times");

        for (int i = 1; i < number ; i++) {
            BrowserUtils.clickWithJS(vehicleContractsPage.nextButton);
        }


        BrowserUtils.waitFor(3);
        System.out.println("vehicleContractsPage.allrows.getText() = " + vehicleContractsPage.allrows.getText());
        extentLogger.info("verify Vehicle Contract is Displayed on the grid");
        Assert.assertTrue(vehicleContractsPage.allrows.getText().contains("Mclaren"));

        extentLogger.info("PASS");


    }
}