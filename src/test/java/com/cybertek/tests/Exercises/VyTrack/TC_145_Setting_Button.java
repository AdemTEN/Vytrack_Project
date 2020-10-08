package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.pages.VehicleContractsPage;
import com.cybertek.tests.TestBase;
import com.cybertek.tests.TestBase2ForExercise;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_145_Setting_Button extends TestBase {

    @Test
    public void settingButton(){

        VehicleContractsPage vehicleContractsPage = new VehicleContractsPage();
        BrowserUtils.clickWithJS(vehicleContractsPage.settingButton);
        BrowserUtils.waitFor(2);

        actions.(vehicleContractsPage.firstSortIcon,vehicleContractsPage.secondSortIcon).perform();

        // actions.moveToElement(vehicleContractsPage.firstSortIcon).clickAndHold().moveToElement(vehicleContractsPage.secondSortIcon).pause(2000).release().perform();

        /*
        WebElement sortItem1 = driver.findElement(By.xpath("//tr[2]//td[2]//span[1]//i[1]"));
        WebElement sortItem2 = driver.findElement(By.xpath("//tr[1]//td[2]//span[1]//i[1]"));
       BrowserUtils.waitForStaleElement(sortItem1);
        actions.moveToElement(sortItem1).clickAndHold().moveToElement(sortItem2).pause(2000).release().perform();

*/



    }
}
