package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class GeneralInformationPage extends BasePage {

    @FindBy(xpath = "//*[@class='user-name'][contains(text(),'Mike Smith Mclaren Hamilton 25250')]")
    public WebElement headerOfContract;
}
