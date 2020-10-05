package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.tests.TestBaseForDays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBaseForDays {

    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Test
    public void contactDetailsTest(){

        extentLogger = report.createTest("Contact Details Test");

        extentLogger.info(" navigate to customers ->contacts");
        new DashboardPage().navigateToModule("Customers","Contacts");

        ContactsPage contactsPage =new ContactsPage();

        contactsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("click on email mbrackstone9@example.com");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();


        ContactInfoPage contactInfoPage = new ContactInfoPage();

        extentLogger.info("verify that full name is Mariam Brackstone");
        Assert.assertEquals(contactInfoPage.name.getText(),"Mariam Brackstone","verify name");

        extentLogger.info("verify that email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone");

        extentLogger.info("verify that phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com" ,"verify email");

        extentLogger.pass("PASSED");








    }
}
