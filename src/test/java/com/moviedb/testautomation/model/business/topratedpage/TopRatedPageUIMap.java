package com.moviedb.testautomation.model.business.topratedpage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Sarthak on 10/1/2016.
 */
public class TopRatedPageUIMap {

    private WebDriver mDriver;
    private WebElement mTopRatedListElement;
    private List<WebElement> mMovieItemPosterCardElements;
    private WebElement mUserHomeLinkElement;

    public TopRatedPageUIMap(WebDriver driver) {
        mDriver = driver;
    }

    public WebElement getTopRatedListElement() {
        if(mTopRatedListElement ==null){
            mTopRatedListElement =mDriver.findElement(By.cssSelector("div[class*='results']"));
        }
        return mTopRatedListElement;
    }

    public List<WebElement> getMovieItemPosterCardElements(){
        if(mMovieItemPosterCardElements==null){
            mMovieItemPosterCardElements=getTopRatedListElement().findElements(By.cssSelector("div[class='item poster card']"));
        }
        return mMovieItemPosterCardElements;
    }

    public WebElement getMovieItemPosterCardElementAtIndex(int index){
        List<WebElement> posterCardList= getMovieItemPosterCardElements();
        if(posterCardList.size()<index){
            throw new NoSuchElementException("The specified index " + index + " is less than the posterCardList size " + posterCardList.size());
        }
        return posterCardList.get(index);
    }

    public WebElement getMovieItemPosterCardIdElement(WebElement movieItemPosterCard){
        return movieItemPosterCard.findElement(By.xpath(".//*[(@class='info')]/descendant::*[(@title)]"));
    }


    public WebElement getMovieItemPosterCardOverViewElement(WebElement movieItemPosterCard){
        return movieItemPosterCard.findElement(By.xpath(".//*[(@class='info')]/descendant::*[(@class='overview')]"));
    }

    public WebElement getUserHomeLinkElement() {
        if(mUserHomeLinkElement==null) {
            mUserHomeLinkElement = mDriver.findElement(By.cssSelector("li[class='user']"));
        }
        return mUserHomeLinkElement;
    }

    public String getMovieItemPosterCardIdValue(WebElement movieItemPosterCard){
        return getMovieItemPosterCardIdElement(movieItemPosterCard).getAttribute("id");
    }

    public String getMovieItemPosterCardOverViewValue(WebElement movieItemPosterCard){
        return getMovieItemPosterCardOverViewElement(movieItemPosterCard).getText();
    }

    public void clickUserHomeLinkElement(){
        getUserHomeLinkElement().click();
    }
}
