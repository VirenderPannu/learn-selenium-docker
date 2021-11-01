package com.newtours.tests;

import com.newtours.pages.GoogleSearchPage;
import com.tests.BaseTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private String searchText;

    @BeforeTest
    @Parameters({"searchText"})
    public void setupParameters(String searchText){
        this.searchText = searchText;
    }

    @Test
    public void googleSearchTest() throws InterruptedException {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.goTo();
    }

}
