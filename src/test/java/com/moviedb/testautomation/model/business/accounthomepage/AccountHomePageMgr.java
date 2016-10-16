package com.moviedb.testautomation.model.business.accounthomepage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

/**
 * Created by Sarthak on 10/1/2016.
 */
public class AccountHomePageMgr extends LoadableComponent<AccountHomePageMgr> {

    private WebDriver mDriver;
    private AccountHomePageUIMap mAccountHomePageUIMap;

    public AccountHomePageMgr(WebDriver driver) {
        mDriver = driver;
        PageFactory.initElements(mDriver,this);
        mAccountHomePageUIMap = new AccountHomePageUIMap(mDriver);
    }

    public void clickAndNavigateToTopRatedPage() {
        WebElement movies = mAccountHomePageUIMap.getMoviesLinkElement();
        new Actions(mDriver).moveToElement(movies).build().perform();
        mAccountHomePageUIMap.clickTopRatedLinkElement();
    }

    public void clickLogoutAndNavigateToLogOut() {
        mAccountHomePageUIMap.clickLogOutLinkElement();

    }

    protected void load() {

    }

    protected void isLoaded() throws Error {
        try {
            Assert.assertTrue(mAccountHomePageUIMap.getMoviesLinkElement().isDisplayed(), "MoviesLinkElement is not displayed"); //TODO this check can be made generic
        } catch (NoSuchElementException ex) {
            throw new AssertionError();
        }
    }
}
