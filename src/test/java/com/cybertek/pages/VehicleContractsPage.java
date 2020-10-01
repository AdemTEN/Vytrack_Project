package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleContractsPage extends BasePage {


    @FindBy(css = "[class='btn main-group btn-primary pull-right ']")
    public WebElement createVehicleContract;

    @FindBy(xpath = "//i[contains(text(),'Next')]")
    public WebElement nextButton;

    @FindBy(xpath = "//label[contains(text(),'of 2 |')]")
    public WebElement numberOfPage;

    @FindBy(xpath = "//tbody")
    public WebElement allrows;






}
