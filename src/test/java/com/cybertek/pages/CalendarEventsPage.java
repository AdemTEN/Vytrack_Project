package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public   WebElement createCalendarEvent;

    @FindBy(xpath = "//div[contains(text(),'Options')]")
    public WebElement optionsLink;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//button[contains(text(),'25')]")
    public WebElement perPageNumber;



    @FindBy(xpath = "//thead//input[@type='checkbox']")
    public WebElement checkAllBoxOfThead;

   // @FindBy(xpath = "(//tbody//input[@type='checkbox'])[1]")
    // public WebElement checkBoxOfTbody;

    public WebElement isCheckBoxesSelected(int number){
        String xpath = "(//tbody//input[@type='checkbox'])["+number+"]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//td[@data-column-label='Title'][contains(text(),'Testers meeting')]")
    public WebElement titleName;

    public WebElement getTitleName(String title) {
        String xpath = "//td[@data-column-label='Title'][contains(text(),'" + title + "')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//i[contains(text(),'Next')]")
    public WebElement nextButton;

    @FindBy(xpath = "//label[contains(text(),'of')]" )
    public WebElement numberOfPage;

    @FindBy(xpath = "//label[contains(text(),'Total of')]")
    public WebElement records;

    @FindBy(xpath = "//label[contains(text(),'View per page:')]/../div/button")
    public WebElement viewPerPageButton;

    @FindBy(xpath ="//a[contains(text(),'100')]")
    public WebElement button100;

    public WebElement getRows(int rowNumber){
        String xpath = "//tbody/tr["+rowNumber+"]";
        return Driver.get().findElement(By.xpath(xpath));
    }


}

