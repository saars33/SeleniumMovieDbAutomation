package com.moviedb.testautomation.tests;

import com.moviedb.testautomation.model.business.accounthomepage.AccountHomePageMgr;
import com.moviedb.testautomation.model.business.loginpage.LoginPageMgr;
import com.moviedb.testautomation.model.business.topratedpage.TopRatedPageMgr;
import org.testng.annotations.Test;

/**
 * Created by ARVIND on 10/8/2016.
 */
public class ProjectDeliverablesTest1 extends BaseTestClass{

    @Test
    public void testTC1(){
//        Assert.assertTrue(true,"testTC1 should pass");
        LoginPageMgr loginMgr=new LoginPageMgr(mWebDriver);
        loginMgr.get();
        AccountHomePageMgr accountHomeMgr=loginMgr.loginAndNavigateToAccountHome("regis_selenium_user", "seleniumP@ssword");
        accountHomeMgr.clickAndNavigateToTopRatedPage();
        TopRatedPageMgr topRatedMgr=new TopRatedPageMgr(mWebDriver);
        topRatedMgr.validateMovieList();
        accountHomeMgr=topRatedMgr.clickUserHome();
        accountHomeMgr.clickLogoutAndNavigateToLogOut();
    }
}