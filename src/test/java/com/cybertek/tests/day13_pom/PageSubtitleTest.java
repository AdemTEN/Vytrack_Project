package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * Test case
     * Open Chrome browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */
    @Test
    public void test1() {

        LoginPage.loginAsUser("driver");

        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubTitle = "Quick Launchpad";
        String actualSubTitle = dashboardPage.getPageSubTitle();
        Assert.assertEquals(actualSubTitle,expectedSubTitle,"verify subtitle");

        dashboardPage.navigateToModule("Activities","Calendar Events" );

        //now we are Calendar Events Page, so we need to create an object
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitFor(2);
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","verify subtitle Calender Events");

    }
}
