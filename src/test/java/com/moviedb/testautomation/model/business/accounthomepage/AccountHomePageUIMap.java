package com.moviedb.testautomation.model.business.accounthomepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Sarthak on 10/1/2016.
 */
public class AccountHomePageUIMap {

    private WebDriver mWebDriver;
    private WebElement mTopRatedLinkElement;
    private WebElement mMoviesLinkElement;
    private WebElement mLogOutLinkElement;

    public AccountHomePageUIMap(WebDriver mWebDriver) {
        this.mWebDriver = mWebDriver;
    }


    public WebElement getTopRatedLinkElement() {
        if(mTopRatedLinkElement ==null){
            mTopRatedLinkElement =mWebDriver.findElement(By.linkText("Top Rated"));
        }
        return mTopRatedLinkElement;
    }

    public WebElement getMoviesLinkElement() {
        if(mMoviesLinkElement ==null){
            mMoviesLinkElement =mWebDriver.findElement(By.cssSelector("a[href='/movie']"));
        }
        return mMoviesLinkElement;
    }

    public WebElement getLogOutLinkElement() {
        if(mLogOutLinkElement==null){
            mLogOutLinkElement=mWebDriver.findElement(By.linkText("Logout"));
        }
        return mLogOutLinkElement;
    }

    public void clickTopRatedLinkElement(){
        getTopRatedLinkElement().click();
    }

    public void clickLogOutLinkElement(){
        getLogOutLinkElement().click();
    }
}
