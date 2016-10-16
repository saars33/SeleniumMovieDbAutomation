package com.moviedb.testautomation.tests;

import com.moviedb.testautomation.model.business.loginpage.LoginPageMgr;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ARVIND on 10/12/2016.
 */
public class ProjectDeliverablesTest2 extends BaseTestClass {

    @Test
    public void testTC2(){

//        Assert.assertTrue(true,"testTC2 should pass");
        LoginPageMgr loginMgr=new LoginPageMgr(mWebDriver);
        loginMgr.get();
        loginMgr.doLogin("sampleUsername","samplePassWord");
        loginMgr.verifyIncorrectCredentialError();
    }

}
