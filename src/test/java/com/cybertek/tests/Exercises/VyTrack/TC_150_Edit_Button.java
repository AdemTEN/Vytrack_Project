package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.tests.TestBase2ForExercise;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_150_Edit_Button extends TestBase2ForExercise {

    @Test
    public void editButton(){

        WebElement firstContract = driver.findElement(By.xpath("//td[contains(text(),'Marc')]"));
        BrowserUtils.clickWithJS(firstContract);

    }
}
