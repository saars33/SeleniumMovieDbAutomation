package com.moviedb.testautomation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by ARVIND on 10/12/2016.
 */
public abstract class BaseTestClass {
    public WebDriver mWebDriver;

    @BeforeTest
    public void setupBeforeTest(){
        mWebDriver=new FirefoxDriver();
        mWebDriver.manage().window().maximize();
        mWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void teardownAfterTest(){
        mWebDriver.quit();
    }
}
