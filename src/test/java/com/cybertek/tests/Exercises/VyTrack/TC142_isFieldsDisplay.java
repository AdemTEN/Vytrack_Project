package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.tests.TestBase2ForExercise;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC142_isFieldsDisplay extends TestBase2ForExercise {

    @Test
    public void isDisplayAllSelectedFields() throws InterruptedException {

        WebElement createButton = driver.findElement(By.cssSelector("[class='btn main-group btn-primary pull-right ']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", createButton);

        //Type
        WebElement typeOption = driver.findElement(By.cssSelector("[name='custom_entity_type[Type]']"));
        jse.executeScript("arguments[0].click();", typeOption);
        Thread.sleep(3000);

        List<WebElement> options = driver.findElements(By.xpath("//select[@name='custom_entity_type[Type]']/option"));

        for (WebElement option : options) {
            Assert.assertTrue(option.isDisplayed());

        }

        Select leasingOption = new Select(typeOption);
        leasingOption.selectByValue("leasing");

        //Recurring Cost Amount
        WebElement costAmountOptions = driver.findElement(By.xpath("//select[@name='custom_entity_type[RecurringCostAm]']"));
        jse.executeScript("arguments[0].click();", costAmountOptions);

        List<WebElement> elementsOfCostAmount = driver.findElements(By.xpath("//select[@name='custom_entity_type[RecurringCostAm]']/option"));

        for (WebElement webElement : elementsOfCostAmount) {
            Assert.assertTrue(webElement.isDisplayed());
            System.out.println(webElement.getText());

        }

        Select costOptions = new Select(costAmountOptions);
        costOptions.selectByValue("monthly");
        Thread.sleep(30000);

        for(int i = 0; i<10;i++){
            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,250)");
        }

        //Status
        WebElement status = driver.findElement(By.xpath("//select[@name='custom_entity_type[Status]']"));
        jse.executeScript("arguments[0].click();", status);

        List<WebElement> statusOptions = driver.findElements(By.xpath("//select[@name='custom_entity_type[Status]']/option"));
        statusOptions.forEach(n -> Assert.assertTrue(n.isDisplayed()));

        Select statusSelect = new Select(status);
        statusSelect.selectByValue("active");

        WebElement active = driver.findElement(By.xpath("//select[@name='custom_entity_type[Status]']/option[2]"));
        Assert.assertTrue(active.isSelected());



        }

    }

