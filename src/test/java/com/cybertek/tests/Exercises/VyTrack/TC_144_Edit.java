package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.tests.TestBase2ForExercise;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_144_Edit extends TestBase2ForExercise {

    @Test
    public  void tc144() throws InterruptedException {
        WebElement threepoint = driver.findElement(By.xpath("//*[@href='javascript:void(0);'][1]"));
        Thread.sleep(6000);
        actions.moveToElement(threepoint).perform();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

       
        WebElement edit = driver.findElement(By.xpath("//tr[1]//td[16]//div[1]//div[1]//ul[1]//li[1]//ul[1]//li[2]//a[1]//i[1]"));

        jse.executeScript("arguments[0].click();", edit);

        driver.findElement(By.cssSelector("[name='custom_entity_type[Responsible]']")).clear();
        driver.findElement(By.cssSelector("[name='custom_entity_type[Responsible]']")).sendKeys("Marco");
        //Save and close
        WebElement saveButton = driver.findElement(By.cssSelector(".btn.btn-success.action-button"));
        jse.executeScript("arguments[0].click();",saveButton);
    }

}
