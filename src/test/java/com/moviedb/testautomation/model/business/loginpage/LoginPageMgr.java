package com.moviedb.testautomation.model.business.loginpage;

import com.moviedb.testautomation.model.business.accounthomepage.AccountHomePageMgr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

/**
 * Created by Sarthak on 9/30/2016.
 */
public class LoginPageMgr extends LoadableComponent<LoginPageMgr>{

    private WebDriver mDriver=null;
    private LoginPageUIMap mLoginPageUIMap;
    public LoginPageMgr(WebDriver driver){
        mDriver=driver;
        mLoginPageUIMap =new LoginPageUIMap(mDriver);
    }


    private void setUserName(String userName){
        mLoginPageUIMap.getUserNameEdit().sendKeys(userName);
    }

    private void setPassword(String password){
        mLoginPageUIMap.getPasswordEdit().sendKeys(password);
    }

    private void clickLoginButton(){
        mLoginPageUIMap.getLoginButton().click();
    }

    public void doLogin(String userName,String password){
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }

    public AccountHomePageMgr loginAndNavigateToAccountHome(String userName, String password){
        doLogin(userName,password);
        return new AccountHomePageMgr(mDriver);
    }

    public void verifyIncorrectCredentialError(){
        String curProblemLabelText= mLoginPageUIMap.getThereWasAProblemLabel().getText();
        Assert.assertTrue(curProblemLabelText.trim().equalsIgnoreCase("There was a problem"),"Verify Problem Label");

    }


    protected void load() {
        mDriver.get("https://www.themoviedb.org/login");
    }

    protected void isLoaded() throws Error {
        String url = mDriver.getCurrentUrl();
        Assert.assertTrue(url.contains("login"),"Not on the right page.");
    }
}
