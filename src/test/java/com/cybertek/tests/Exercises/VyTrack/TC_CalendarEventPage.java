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
        for (WebElement webElement : optionsRepeatOn) {
            System.out.println("webElement.getText() = " + webElement.getAttribute("title"));
        }

        List<String> expectedRepetOnList = Arrays.asList("S","M","T","W","T","F","S");

       List<String> actualRepeatOnList = BrowserUtils.getElementsgetAttribute(optionsRepeatOn);
        /*
        List<String > actualRepeatOnList = new ArrayList<>();
        for (WebElement optionsREPEATOn  : optionsRepeatOn) {
            actualRepeatOnList.add(optionsREPEATOn.getAttribute("title"));

        }
        */

        Assert.assertEquals(actualRepeatOnList, expectedRepetOnList);
    }
    @Test
    public void test2(){
        LoginPage.loginAsUser("driver");
        DashboardPage dashboardPage =new DashboardPage();

        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(4);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        createCalendarEventsPage.monthly.click();

        Select monthlyRepeatOnDropdown = createCalendarEventsPage.repeatOnMonthlyList();
        List<WebElement> monthlyOptions = monthlyRepeatOnDropdown.getOptions();
        for (WebElement monthlyOption : monthlyOptions) {
            System.out.println("monthlyOption.getText() = " + monthlyOption.getText().trim());
        }
        List<String> expectedList = Arrays.asList("Day","━━━━━━━━━","First","Second", "Third","Fourth", "Last");

        List<String> actualList = BrowserUtils.getElementsText(monthlyOptions);
        Assert.assertEquals(actualList,expectedList);

       /*
        monthlyRepeatOnDropdown.selectByValue("1");
        BrowserUtils.waitFor(3);
        Assert.assertTrue(createCalendarEventsPage.First.isSelected());
*/

    }



}
