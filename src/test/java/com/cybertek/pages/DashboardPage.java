package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    //no need to explicitly write constructor, because it will use base page constructer.


    @FindBy(xpath = "tr[@class='grid-row']//a[contains(text(),'Mariam Brackstone')]")
    public WebElement contactName;

    public WebElement getContactName(String contactName){
        String xpath = "tr[@class='grid-row']//a[contains(text(),'" + contactName + "')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

}
