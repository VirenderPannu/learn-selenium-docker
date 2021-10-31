package com.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname

        String host = "localhost";   // localhost
        ImmutableCapabilities capabilities;
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        ChromeOptions chromeOptions = new ChromeOptions();
        
        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":4444/wd/hub";
        //dc.setCapability("name", testName);
        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            //System.setProperty("webdriver.chrome.driver","//Users//virender.singh//Desktop//Webdrivers//geckodriver");
            //capabilities = new ImmutableCapabilities("browserName", "firefox");
            // this.driver = new FirefoxDriver();
            this.driver = new RemoteWebDriver(new URL(completeUrl), firefoxOptions);
            //this.driver.manage().window().fullscreen();
        }
        else{
            //capabilities = new ImmutableCapabilities("browserName", "chrome");
            //System.setProperty("webdriver.chrome.driver","//Users//virender.singh//Desktop//Webdrivers//chromedriver");
            //this.driver = new ChromeDriver();
            this.driver = new RemoteWebDriver(new URL(completeUrl), chromeOptions);
            //this.driver.manage().window().fullscreen();
        }
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }



}
