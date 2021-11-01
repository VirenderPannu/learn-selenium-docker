package com.newtours.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchTextBox;

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
        // this.wait = new WebDriverWait(driver, 30);
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goTo() throws InterruptedException{
        this.driver.get("https://www.google.com/");
    }

}
