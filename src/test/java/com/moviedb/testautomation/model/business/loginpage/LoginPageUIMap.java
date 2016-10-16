package com.moviedb.testautomation.model.business.loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Sarthak on 9/30/2016.
 */

public class LoginPageUIMap {
    private WebDriver mDriver;
    public LoginPageUIMap(WebDriver driver){
        mDriver=driver;
    }

    private WebElement mUserNameEdit;
    private WebElement mPasswordEdit;
    private WebElement mLoginButton;
    private WebElement mThereWasAProblemLabel;

    public WebElement getUserNameEdit() {
        if(mUserNameEdit==null){
            mUserNameEdit=mDriver.findElement(By.xpath(".//*[@id='username']"));
        }
        return mUserNameEdit;
    }

    public WebElement getPasswordEdit() {
        if(mPasswordEdit==null){
            mPasswordEdit=mDriver.findElement(By.xpath(".//*[@id='password']"));
        }
        return mPasswordEdit;
    }

    public WebElement getLoginButton() {
        if(mLoginButton==null){
            mLoginButton=mDriver.findElement(By.cssSelector("input[value$='ogin']"));
        }
        return mLoginButton;
    }

    public WebElement getThereWasAProblemLabel() {
        if(mThereWasAProblemLabel==null){
            //mThereWasAProblemLabel=mDriver.findElement(By.className("glyphicons glyphicons-exclamation-sign x1"));
            mThereWasAProblemLabel=mDriver.findElement(By.xpath(".//*[@id='main']/div/section/div/h2"));
        }
        return mThereWasAProblemLabel;
    }

}
