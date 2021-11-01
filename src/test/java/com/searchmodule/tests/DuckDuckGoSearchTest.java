package com.searchmodule.tests;

import com.searchmodule.pages.DuckDuckGoSearchPage;
import com.tests.BaseTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DuckDuckGoSearchTest extends BaseTest {

    @Test
    @Parameters({"searchText"})
    public void search(String keyword) throws InterruptedException{
        DuckDuckGoSearchPage duckDuckGoSearchPage = new DuckDuckGoSearchPage(driver);
        duckDuckGoSearchPage.goTo();
    }

}
