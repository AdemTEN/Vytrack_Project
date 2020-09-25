package com.cybertek.tests.HW.EU2_HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase7_UploadFile {

    /*
    Test case #7
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. And click on “File Upload".
    Step 3. Upload any file with .txt extension from your computer.
    Step 4. Click “Upload” button.
    Step 5. Verify that subject is: “File Uploaded!”
    Step 6. Verify that uploaded file name is displayed.
    Note: use element.sendKeys(“/file/path”) with
    specifying path to the file for uploading. Run this
    method against “Choose File” button.
     */

    WebDriver driver ;


    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeDriver(){
         driver.quit();
    }

    @Test
    public void test7(){

        //    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //    Step 2. And click on “File Upload".
        driver.findElement(By.linkText("File Upload")).click();

        //    Step 3. Upload any file with .txt extension from your computer.
        WebElement uploadElement = driver.findElement(By.id("file-upload"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile2.txt";
        String fullPath = projectPath+"/"+filePath;
        uploadElement.sendKeys(fullPath);

        //    Step 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();

        //    Step 5. Verify that subject is: “File Uploaded!”
        String actualSubject = driver.findElement(By.tagName("h3")).getText();
        String expectedSubject = "File Uploaded!";
        Assert.assertEquals(actualSubject,expectedSubject,"verify that subject is File Uploaded!");

        //    Step 6. Verify that uploaded file name is displayed.
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        String expectedFileName = "textfile2.txt";
        Assert.assertEquals(actualFileName,expectedFileName,"verify that file name is sublime_text.exe");



    }
}
