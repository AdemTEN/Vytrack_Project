package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.WeakHashMap;

public class CalenderEventsInfoPage extends BasePage{

    public WebElement getTitle(String title){
        String xpath = "//div[contains(text(),'"+title+"')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    public WebElement getDescription(String descriptiion){
        String xpath = "//span[contains(text(),'"+descriptiion+"')]";
        return Driver.get().findElement(By.xpath(xpath));
    }
    public WebElement getStart(String start){
        String xpath = "//div[contains(text(),'"+start+"')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    public WebElement getEnd (String end){
        String xpath = "//div[contains(text(),'"+end+"')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    @FindBy (xpath = "//label[contains(text(),'All-day event')]/../div/div")
    public  WebElement allDayEvent;

    @FindBy(xpath = "//div[@class='calendar-event-organizer']/a")
    public WebElement organizer;

    @FindBy(xpath = "//span[@class='list-group-item-text']/a")
    public WebElement guests;

    @FindBy(xpath = "//label[contains(text(),'Recurrence')]/../div/div")
    public WebElement recurrence;

    @FindBy(xpath = "//label[contains(text(),'Call via Hangout')]/../div/div")
    public WebElement callViaHangout;



    /*
    public WebElement getAllDayEvent (String allDayEvent){
        String xpath = "//div[contains(text(),'"+allDayEvent+"')]";
        return Driver.get().findElement(By.xpath(xpath));
    }
/*
    public WebElement getOrganizer(String organizer){
        String xpath =
    }
*/

}
