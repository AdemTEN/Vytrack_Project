package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.tests.TestBase;
import com.cybertek.tests.TestBase2ForExercise;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_144_Edit extends TestBase2ForExercise {

    @Test
    public  void tc144() throws InterruptedException {
        WebElement threepoint = driver.findElement(By.xpath("//*[@href='javascript:void(0);'][1]"));
        Thread.sleep(6000);
        BrowserUtils.hover(threepoint);



        WebElement edit = driver.findElement(By.cssSelector("[class='fa-pencil-square-o hide-text']"));
        BrowserUtils.waitForStaleElement(edit);
        BrowserUtils.clickWithJS(edit);


        //driver.findElement(By.cssSelector("[name='custom_entity_type[Responsible]']")).clear();
        //driver.findElement(By.cssSelector("[name='custom_entity_type[Responsible]']")).sendKeys("Marco");
        //Save and close
        //WebElement saveButton = driver.findElement(By.cssSelector(".btn.btn-success.action-button"));
        //jse.executeScript("arguments[0].click();",saveButton);
    }



}
