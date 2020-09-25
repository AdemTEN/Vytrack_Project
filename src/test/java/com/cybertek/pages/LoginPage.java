package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    /*
    //driver.findElement(By.id("prependedInput"));
   //if all locators are matching with element then it will return it. AND logic applies here.
    @FindBys({
            @FindBy(id = "prependedInput"),
            @FindBy(name ="_username")
    })
    public WebElement usernameInput;


    //gives us option to use multiple locators, if at least one of them is matching it will find the web element
    @FindAll({
            @FindBy(id="prependedInput"),
            @FindBy(name = "_username")

    })
    public WebElement userNameInputBox;
*/
    //driver.findElement(By.id("prependedInput"));
    @FindBy(name = "_username")
    public WebElement usernameInput;


    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;


    public void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

}
