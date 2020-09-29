package com.cybertek.pages;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventsPage extends BasePage {

    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;

    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;

    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement days;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement description;

    @FindBy(xpath = "//option[contains(text(),'Daily')]")
    public WebElement daily;

    @FindBy(xpath = "//option[contains(text(),'Weekly')]")
    public WebElement weekly;

    @FindBy(xpath = "//option[contains(text(),'Monthly')]")
    public WebElement monthly;

    @FindBy(xpath = "//option[contains(text(),'Yearly')]")
    public WebElement yearly;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndClose;

    @FindBy(xpath = "//input[@name='temp-validation-name-126']")
    public WebElement repeatEvery;

    @FindBy(xpath = "//select[@name='recurrence[dayOfWeek]']")
    public WebElement repeatOnDailyOptions;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[2]/div[2]/div[4]/div[1]/div[2]/div[2]/div[1]/select[1]")
    public WebElement repeatOnMonthlyOptions;



    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }

    public Select repeatOnList(){
        return new Select(repeatOnDailyOptions);
    }

    public Select repeatOnMonthlyList(){
        return new Select(repeatOnMonthlyOptions);
    }


}