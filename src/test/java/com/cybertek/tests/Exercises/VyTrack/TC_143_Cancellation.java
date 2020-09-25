package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.tests.TestBase2ForExercise;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_143_Cancellation extends TestBase2ForExercise {

    @Test
    public void tc143(){

        WebElement createbutton = driver.findElement(By.cssSelector(".btn.main-group.btn-primary.pull-right "));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", createbutton);


        driver.findElement(By.cssSelector("[name='custom_entity_type[Responsible]']")).sendKeys("Marco");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement cancel = driver.findElement(By.cssSelector(".btn.back.icons-holder-text "));
        jse.executeScript("arguments[0].click();", cancel);

        WebElement header = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertTrue(header.getText().contains("Vehicle Contract"));

    }


}
