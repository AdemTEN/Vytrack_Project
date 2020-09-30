package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.tests.TestBase2ForExercise;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TC141_EnterVEhicleContratPage extends TestBase2ForExercise {




    @DataProvider(name = "contract")
    public Object[][] enterData (){
        return new Object[][]{
                {"Mike Smith", "250", "50","15000","Apr 12, 2020","May 12, 2020","Sep 12, 2020", "Mclaren", "Hamilton","25250", "extra information"  }
        };
    }

    @Test(dataProvider = "contract")
    public void accesVehicleContract(String responsible, String activationCost, String costAmount, String odomater,
                                 String invoiceDate, String  startDate, String ExpirationDate,   String  vendor, String Driver, String contract, String terms) throws InterruptedException {
        WebElement createButton = driver.findElement(By.cssSelector("[class='btn main-group btn-primary pull-right ']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        BrowserUtils.clickWithJS(createButton);

        WebElement type =   driver.findElement(By.xpath("//*[.='Choose a value...']"));

        BrowserUtils.clickWithJS(type);
        WebElement type2 = driver.findElement(By.name("custom_entity_type[Type]"));
        Select typeDropdown = new Select(type2);
        typeDropdown.selectByValue("cash");

        driver.findElement(By.cssSelector("[name='custom_entity_type[Responsible]']")).sendKeys(responsible);
        //driver.findElement(By.cssSelector("[name='custom_entity_type[ActivationCost]']")).sendKeys(String.valueOf(activationCost));
        driver.findElement(By.cssSelector("[name='custom_entity_type[ActivationCost]']")).sendKeys(activationCost);
        driver.findElement(By.cssSelector("[name='custom_entity_type[RecurringCostAmount]']")).sendKeys(costAmount);

        WebElement costAmount2 = driver.findElement(By.cssSelector("[name='custom_entity_type[RecurringCostAm]']"));
        typeDropdown = new Select(costAmount2);
        typeDropdown.selectByValue("monthly");

        driver.findElement(By.cssSelector("[name='custom_entity_type[OdometerDetails]']")).sendKeys(odomater);
       WebElement date = driver.findElement(By.xpath("//input[contains(@id,'date_selector_custom_entity_type_InoviceDate-uid-')]"));
       date.sendKeys(invoiceDate);

       driver.findElement(By.xpath("//input[contains(@id,'date_selector_custom_entity_type_ContractStartDate-uid-')]")).sendKeys(startDate);
       driver.findElement(By.xpath("//input[contains(@id,'date_selector_custom_entity_type_ContractExpirationDate-uid-')]")).sendKeys(ExpirationDate);


        WebElement vendorInputBox = driver.findElement(By.cssSelector("[name='custom_entity_type[Vendor]']"));
        BrowserUtils.waitForClickablility(vendorInputBox,30);
        vendorInputBox.sendKeys(vendor);
        driver.findElement(By.cssSelector("[name='custom_entity_type[Driver]")).sendKeys(Driver);
        driver.findElement(By.cssSelector("[name='custom_entity_type[ContractReference]']")).sendKeys(contract);
        driver.findElement(By.cssSelector("[name='custom_entity_type[TermsandConditions]']")).sendKeys(terms);

        WebElement status = driver.findElement(By.cssSelector("[name='custom_entity_type[Status]']"));
        typeDropdown = new Select(status);
        typeDropdown.selectByValue("active");

        WebElement saveButton = driver.findElement(By.cssSelector(".btn.btn-success.action-button"));
        BrowserUtils.clickWithJS(saveButton);

        WebElement moreAction = driver.findElement(By.xpath("//a[@class='btn dropdown-toggle']"));
        Assert.assertTrue(moreAction.isDisplayed());
        WebElement head = driver.findElement(By.xpath("//*[@class='user-name'][contains(text(),'Mike Smith Mclaren Hamilton 25250')]"));

        String expectedResult = "Mike Smith Mclaren Hamilton 25250";
        String actualResult = head.getText();
        Assert.assertEquals(actualResult,expectedResult);

        BrowserUtils.waitFor(10);

        WebElement vehicle_contract = driver.findElement(By.linkText("Vehicle Contract"));
        jse.executeScript("arguments[0].click();",vehicle_contract);




    }
    @Test
    public void testTable(){
        List<WebElement> headers = driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//th"));
        System.out.println("headers.size() = " + headers.size());
        for (WebElement header : headers) {
            System.out.println(header.getText());

        }
        //list of all rows
        List<WebElement> allRows= driver.findElements(By.xpath("//tbody[@class='grid-body']/tr"));
        System.out.println("allRows.size() = " + allRows.size());
        for (WebElement allRow : allRows) {
            System.out.println(allRow.getText());
        }

        WebElement myContract = driver.findElement(By.xpath("//*[.='Yusuf Ali Kerim'][1]"));
        String actualResult = myContract.getText();
        Assert.assertEquals(actualResult, "Yusuf Ali Kerim");

        List<WebElement> myContractsInformations = driver.findElements(By.xpath("//*[.='Yusuf Ali Kerim'][1]/../td"));
        for (WebElement myContractsInformation : myContractsInformations) {
            System.out.println(myContractsInformation.getText());

        }

    }
    @Test
    public void assertionofContract(){
        WebElement numberofPage =  driver.findElement(By.xpath("//label[contains(text(),'|')]"));
        System.out.println(numberofPage.getAttribute("innerHTML"));

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='number']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", inputBox);

        String text = "7";

        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);




    }

}