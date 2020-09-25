package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    //Task:
    //write a static method that takes a string parameter name: browserType
    //based on the value of parameter
    //it will setup the browser and
    //the method will return chromedriver or firefoxdriver object.
    //name of the method: getDriver

    public static WebDriver  getDriver(String browserType){

        WebDriver driver = null;

        if(browserType.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();

             driver =  new ChromeDriver();


        }else if(browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();

        }else if(browserType.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
            return driver;


    }



}
