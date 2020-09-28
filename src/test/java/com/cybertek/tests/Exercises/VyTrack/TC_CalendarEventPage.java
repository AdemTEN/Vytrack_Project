package com.cybertek.tests.Exercises.VyTrack;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TC_CalendarEventPage extends TestBase {

    @Test
    public void test1(){

        LoginPage.loginAsUser("driver");

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        Select repeatDropdown = createCalendarEventsPage.repeatOptionsList();
        List<WebElement> options = repeatDropdown.getOptions();

        repeatDropdown.selectByVisibleText("Weekly");
        BrowserUtils.waitFor(2);
       /*
        createCalendarEventsPage.repeatEvery.click();
        createCalendarEventsPage.repeatEvery.clear();

        createCalendarEventsPage.repeatEvery.sendKeys("3");
        */

        Select repeatOnDropdown = createCalendarEventsPage.repeatOnList();
        List<WebElement> optionsRepeatOn = repeatOnDropdown.getOptions();

        List<String> expectedRepetOnList = Arrays.asList("S","M","T","W","T","F","S");

        List<String> actualRepeatOnList = BrowserUtils.getElementsText(optionsRepeatOn);
        Assert.assertEquals(actualRepeatOnList, expectedRepetOnList);



    }


}
