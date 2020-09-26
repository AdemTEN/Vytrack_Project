package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.tests.TestBase2ForExercise;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_145_Setting_Button extends TestBase2ForExercise {

    @Test
    public void settingButton(){

        WebElement settingButton = driver.findElement(By.xpath("//i[@class='fa-cog hide-text']"));
        BrowserUtils.clickWithJS(settingButton);
        WebElement sortItem1 = driver.findElement(By.xpath("//tr[2]//td[2]//span[1]//i[1]"));
        WebElement sortItem2 = driver.findElement(By.xpath("//tr[1]//td[2]//span[1]//i[1]"));
       BrowserUtils.waitForStaleElement(sortItem1);
        actions.moveToElement(sortItem1).clickAndHold().moveToElement(sortItem2).pause(2000).release().perform();





    }
}
