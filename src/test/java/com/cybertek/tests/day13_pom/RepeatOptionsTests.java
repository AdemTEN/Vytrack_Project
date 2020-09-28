package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

      Select repeatOptions = createCalendarEventsPage.repeatOptionsList();

      List<WebElement> options = repeatOptions.getOptions();

      List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

      List<String> actualList = new ArrayList<>();
        for (WebElement option : options) {
            actualList.add(option.getText());

        }

        Assert.assertEquals(actualList,expectedList,"Verify Daily, weekly, monthly, yearly");

    }

    @Test
    public void test3(){
        LoginPage.loginAsUser("driver");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        Select repeatDropdown = createCalendarEventsPage.repeatOptionsList();
        List<WebElement> options = repeatDropdown.getOptions();

        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

        List<String> actualList = new ArrayList<>();

        for(WebElement option: options){
            actualList.add(option.getText());
        }
        Assert.assertEquals(actualList,expectedList);
        repeatDropdown.selectByVisibleText("Weekly");

        Assert.assertTrue(createCalendarEventsPage.weekly.isSelected());


    }

    @Test
    public void test4(){

        LoginPage.loginAsUser("driver");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(5);
        createCalendarEventsPage.repeat.click();

        Select dropDownOptions = createCalendarEventsPage.repeatOptionsList();
        List<WebElement> options = dropDownOptions.getOptions();

        List<String> actualList = BrowserUtils.getElementsText(options);
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

        Assert.assertEquals(actualList,expectedList);
        dropDownOptions.selectByVisibleText("Weekly");

        Assert.assertTrue(createCalendarEventsPage.weekly.isSelected());
        Assert.assertFalse(createCalendarEventsPage.daily.isSelected());

        BrowserUtils.clickWithJS(createCalendarEventsPage.saveAndClose);

    }


}
