package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_CalendarEventPage extends TestBase {

    @Test
    public void test1(){
        LoginPage.loginAsUser("storemanager");

        CalendarEventsPage calendar = new CalendarEventsPage();

        calendar.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.clickWithJS(calendar.createCalendarEvent);

        CreateCalendarEventsPage createCalendar = new CreateCalendarEventsPage();

        BrowserUtils.waitForPageToLoad(15);
        createCalendar.repeatOptionsList().selectByVisibleText("cyber tek");


        driver.findElement(By.name("oro_calendar_event_form[title]")).sendKeys("a");

        //createCalendar.title.sendKeys("McLaren");
        //createCalendar.description.sendKeys("extra information");




    }


}
