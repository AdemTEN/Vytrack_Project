package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class GeneralInformationPage extends BasePage {

    @FindBy(xpath = "//h1[@class='user-name'][contains(text(),'Mike Smith Mclaren Hamilton 25250')]")
    public WebElement headerOfContract;

    public WebElement getHeaderOfContract(String headerOfContract){
        String xpath = "//h1[@class='user-name'][contains(text(),'" + headerOfContract + "')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    @FindBy(linkText = "Vehicle Contract")
    public WebElement vehicleContractLink;

    @FindBy(xpath = "//div[contains(text(),'Schumaher')]")
    public WebElement nameOfResponsible;
}
