package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepeatOptionsTests extends TestBase {

     /*VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */

    @Test
    public void test1(){
        LoginPage.loginAsUser("driver");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(5);
        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected());
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());

    }

    @Test
    public void test2(){

       /*
     VERIFY REPEAT OPTIONS
        Open browser
        Login as driver
        Go to Activities->Calendar Events
        Click on create calendar events button
        Click on repeat checkbox
        Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
     */

      LoginPage.loginAsUser("driver");
      DashboardPage dashboardPage = new DashboardPage();
      dashboardPage.navigateToModule("Activities", "Calendar Events");

      CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
      calendarEventsPage.waitUntilLoaderScreenDisappear();
      calendarEventsPage.createCalendarEvent.click();

      CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
      calendarEventsPage.waitUntilLoaderScreenDisappear();
      createCalendarEventsPage.repeat.click();








    }


}
