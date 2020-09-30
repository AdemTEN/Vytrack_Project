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

    @FindBy(css = "[name='custom_entity_type[InoviceDate]']")
    public WebElement invoiceDate;

    @FindBy(css = "[name='custom_entity_type[ContractStartDate]']")
    public WebElement startDate;

    @FindBy(css = "[name='custom_entity_type[ContractExpirationDate]']")
    public WebElement expirationDate;

    @FindBy(css = "[name='custom_entity_type[Vendor]']")
    public WebElement vendor;

    @FindBy(css = "[name='custom_entity_type[Driver]']")
    public WebElement driver;

    @FindBy(css = "[name='custom_entity_type[ContractReference]']")
    public WebElement reference;

    @FindBy(css = "[name='custom_entity_type[TermsandConditions]']")
    public WebElement termsAndCondition;







    public Select typeOptionsList(){
        return new Select(typeOptions);
    }

}
