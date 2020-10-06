package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.WeakHashMap;

public class CreateVehicleContractPage extends BasePage {

    @FindBy (xpath = "//h1[contains(text(),'Create Vehicle Contract')]")
    public WebElement headerOfPage;

    @FindBy(css = "[name='custom_entity_type[Type]']")
    public WebElement typeOptions;

    @FindBy(xpath = "//option[contains(text(),'Leasing')]")
    public WebElement leasingOption;

    @FindBy(xpath = "//option[contains(text(),'Personal Loan')]")
    public WebElement personalLoanOption;

    @FindBy(xpath = "//option[contains(text(),'Credit Card')]")
    public WebElement creditCardOption;

    @FindBy(xpath = "//option[contains(text(),'Cash')]")
    public WebElement cashOption;

    @FindBy(css = "[name='custom_entity_type[Responsible]']")
    public WebElement responsible;

    @FindBy(css = "[name='custom_entity_type[ActivationCost]']")
    public WebElement activationCost;

    @FindBy(css = "[name='custom_entity_type[RecurringCostAmount]']")
    public WebElement depreciatedCost;

    @FindBy(css = "[name='custom_entity_type[OdometerDetails]']")
    public WebElement odometer;

    @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_InoviceDate-uid-')]")
    public WebElement invoiceDate;

    @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_ContractStartDate-uid-')]")
    public WebElement startDate;

    @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_ContractExpirationDate-uid-')]")
    public WebElement expirationDate;

    @FindBy(css = "[name='custom_entity_type[Vendor]']")
    public WebElement vendor;

    @FindBy(css = "[name='custom_entity_type[Driver]']")
    public WebElement driver;

    @FindBy(css = "[name='custom_entity_type[ContractReference]']")
    public WebElement reference;

    @FindBy(css = "[name='custom_entity_type[TermsandConditions]']")
    public WebElement termsAndCondition;

    @FindBy(css = "[name='custom_entity_type[RecurringCostAm]']")
    public WebElement costAmountOptions;


    @FindBy(xpath = "//option[contains(text(),'Daily')]")
    public WebElement daily;

    @FindBy(xpath = "//option[contains(text(),'Weekly')]")
    public WebElement weekly;

    @FindBy(xpath = "//option[contains(text(),'Monthly')]")
    public WebElement monhtly;

    @FindBy(xpath = "//option[contains(text(),'Yearly')]")
    public WebElement yearly;

    @FindBy(css = "[name='custom_entity_type[Status]']")
    public WebElement status;

    @FindBy(xpath = "//option[contains(text(),'Active')]")
    public WebElement active;

    @FindBy(xpath = "//option[contains(text(),'Archived')]")
    public WebElement archived;

    @FindBy(xpath = "//a[contains(text(),'VehiclesModel')]")
    public WebElement vehicleModelLink;

    @FindBy(xpath = "(//button[@class='btn btn-medium add-btn'])[1]")
    public WebElement vehicleModelAdd;

    @FindBy(xpath = "(//button[@class='btn btn-medium add-btn'])[2]")
    public WebElement vehicleMakeAdd;

    @FindBy(xpath = "//tbody/tr[1]/td[1]/input[1]")
    public WebElement firstAssigned;

    @FindBy(xpath = "//button[contains(text(),'Select')]")
    public WebElement selectButton;

    @FindBy(xpath = "//div[contains(text(),'Model Name:')]")
    public WebElement modelName;

    @FindBy(xpath = "//div[contains(text(),'Make:')]")
    public WebElement make;

    @FindBy(xpath = "(//button[@type='submit'][contains(text(),'Save and Close')])[1]")
    public WebElement saveAndCloseButton;


    @FindBy(xpath = "//label[contains(text(),'Service')]")
    public WebElement service;

    @FindBy(xpath = "//a[@title='Cancel'][//a[contains(text(),'Cancel')]]")
    public WebElement cancelButton;





    public Select typeOptionsList(){
        return new Select(typeOptions);
    }

    public Select costAmountOptionsList(){
        return new Select((costAmountOptions));
    }

    public Select statusOptionsList(){
        return new Select(status);
    }




}
