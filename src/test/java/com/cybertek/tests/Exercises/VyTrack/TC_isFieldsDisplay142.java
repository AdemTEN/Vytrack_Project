package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.tests.TestBase2ForExercise;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC_isFieldsDisplay142 extends TestBase2ForExercise {

    @Test
    public void isDisplayAllSelectedFields() throws InterruptedException {

        WebElement createButton = driver.findElement(By.cssSelector("[class='btn main-group btn-primary pull-right ']"));
        BrowserUtils.clickWithJS(createButton);



        //Type
        WebElement typeOption = driver.findElement(By.cssSelector("[name='custom_entity_type[Type]']"));
        BrowserUtils.clickWithJS(typeOption);
       BrowserUtils.waitFor(3);
        //Thread.sleep(3000);

        List<WebElement> options = driver.findElements(By.xpath("//select[@name='custom_entity_type[Type]']/option"));

        for (WebElement option : options) {
            Assert.assertTrue(option.isDisplayed());

        }

        Select leasingOption = new Select(typeOption);
        leasingOption.selectByValue("leasing");

        //Recurring Cost Amount
        WebElement costAmountOptions = driver.findElement(By.xpath("//select[@name='custom_entity_type[RecurringCostAm]']"));
        BrowserUtils.clickWithJS(costAmountOptions);
        List<WebElement> elementsOfCostAmount = driver.findElements(By.xpath("//select[@name='custom_entity_type[RecurringCostAm]']/option"));

        for (WebElement webElement : elementsOfCostAmount) {
            Assert.assertTrue(webElement.isDisplayed());
            System.out.println(webElement.getText());

        }

        Select costOptions = new Select(costAmountOptions);
        costOptions.selectByValue("monthly");
        BrowserUtils.waitFor(3);


        for(int i = 0; i<10;i++){
           BrowserUtils.waitFor(3);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,250)");
        }

        //Status
        WebElement status = driver.findElement(By.xpath("//select[@name='custom_entity_type[Status]']"));
        BrowserUtils.clickWithJS(status);

        List<WebElement> statusOptions = driver.findElements(By.xpath("//select[@name='custom_entity_type[Status]']/option"));
        statusOptions.forEach(n -> Assert.assertTrue(n.isDisplayed()));

        Select statusSelect = new Select(status);
        statusSelect.selectByValue("active");

        WebElement active = driver.findElement(By.xpath("//select[@name='custom_entity_type[Status]']/option[2]"));
        Assert.assertTrue(active.isSelected());



        }

    }

