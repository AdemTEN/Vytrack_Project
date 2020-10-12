package com.cybertek.tests.HW.Vytrack_HW;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CalenderEventsInfoPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.tests.TestBaseForDays;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestCases1_6 extends TestBaseForDays {


    @Test
    public void testCase1(){
      /*
        1.Go to “https://qa1.vytrack.com/"
        2.Login as a store manager
        3.Navigate to “Activities -> Calendar Events”
        4.Verify that page subtitle "Options" is displayed
       */

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.verifyElementDisplayed(calendarEventsPage.optionsLink);


    }

    @Test
    public void testCase2(){

        /*
        1.Go to “https://qa1.vytrack.com/"
        2.Login as a store manager
        3.Navigate to “Activities -> Calendar Events”
        4.Verify that page number is equals to "1"
         */

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1", "Verify that page number is equals to 1");

    }

    @Test
    public void testCase3(){

        /*
        1.Go to “https://qa1.vytrack.com/"
        2.Login as a store manager
        3.Navigate to “Activities -> Calendar Events”
        4.Verify that view per page number is equals to "25"
         */

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.perPageNumber.getText(),"25","Verify that view per page number is equals to 25");
    }

    @Test
    public void testCase4(){

        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that number of calendar events (rows in
        the table) is equals to number of records
         */
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.clickWithJS(calendarEventsPage.viewPerPageButton);
        BrowserUtils.clickWithJS(calendarEventsPage.button100);

        BrowserUtils.waitFor(2);

        String numberOfPage = calendarEventsPage.numberOfPage.getText();

        String [] pagenumber = numberOfPage.split(" ");

        System.out.println("Arrays.toString(pagenumber) = " + Arrays.toString(pagenumber));
        int number = Integer.parseInt(pagenumber[1]);
        System.out.println("number = " + number);

        String numberOfRecords = calendarEventsPage.records.getText();
        String [] recordsNumber = numberOfRecords.split(" ");
        System.out.println("Arrays.toString(recordsNumber) = " + Arrays.toString(recordsNumber));
        int numberOfEvents = Integer.parseInt(recordsNumber[2]);


        extentLogger.info("Click the next Button 'number of page -1' times");
        int count = 0;
        outer:
        for (int i = 1; i <= number ; i++) {
            if(count!=0){
                BrowserUtils.clickWithJS(calendarEventsPage.nextButton);
            }
            for(int j = 1; j <= 100; j++){

                calendarEventsPage.getRows(j);
                count++;
                if(count==numberOfEvents){
                 break outer;
                }

            }

        }

        String rowNumbers = String.valueOf(count);
        Assert.assertTrue(calendarEventsPage.records.getText().contains(rowNumbers));
        System.out.println("numberOfEvents = " + numberOfEvents);
        System.out.println("rowNumbers = " + rowNumbers);


    }

    @Test
    public void testCase5(){

       /*
       1. Go to “https://qa1.vytrack.com/"
       2. Login as a store manager
       3. Navigate to “Activities -> Calendar Events”
       4. Click on the top checkbox to select all
       5. Verify that all calendar events were selected
        */

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.clickWithJS(calendarEventsPage.checkAllBoxOfThead);
        Assert.assertTrue(calendarEventsPage.checkAllBoxOfThead.isSelected());


        for (int i = 1; i <= 25; i++) {
            Assert.assertTrue(calendarEventsPage.isCheckBoxesSelected(i).isSelected());

        }

    }

    @Test
    /*
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Select “Testers meeting”
    5. Verify that following data is displayed:
     */
    public void testCase6(){
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitFor(2);

        calendarEventsPage.getTitleName("Testers meeting").click();

        CalenderEventsInfoPage calenderEventsInfoPage = new CalenderEventsInfoPage();
        Assert.assertEquals(calenderEventsInfoPage.getTitle("Testers meeting").getText(),"Testers meeting");

        Assert.assertEquals(calenderEventsInfoPage.getDescription("This is a a weekly testers meeting").getText(),"This is a a weekly testers meeting");

        Assert.assertEquals(calenderEventsInfoPage.getStart("Nov 27, 2019, 9:30 PM").getText(),"Nov 27, 2019, 9:30 PM");


        Assert.assertEquals(calenderEventsInfoPage.getEnd("Nov 27, 2019, 10:30 PM").getText(),"Nov 27, 2019, 10:30 PM");

        Assert.assertEquals(calenderEventsInfoPage.allDayEvent.getText(),"No");

        Assert.assertEquals(calenderEventsInfoPage.organizer.getText().trim(),"Stephan Haley");

        Assert.assertEquals(calenderEventsInfoPage.guests.getText().trim(),"Tom Smith");

        Assert.assertEquals(calenderEventsInfoPage.recurrence.getText().trim(),"Weekly every 1 week on Wednesday");

        Assert.assertEquals(calenderEventsInfoPage.callViaHangout.getText().trim(),"No");
    }


}
