package com.moviedb.testautomation.model.business.topratedpage;

import com.moviedb.testautomation.model.business.accounthomepage.AccountHomePageMgr;
import com.moviedb.testautomation.model.domain.Movie;
import com.moviedb.testautomation.model.services.movieservice.IMovieService;
import com.moviedb.testautomation.model.services.movieservice.MovieServiceException;
import com.moviedb.testautomation.model.services.movieservice.MovieServiceImpl;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Sarthak on 10/1/2016.
 */
public class TopRatedPageMgr extends LoadableComponent<TopRatedPageMgr> {

    private WebDriver mDriver;
    private TopRatedPageUIMap mTopRatedPageUIMap;
    private List<Movie> mMovieList;

    public TopRatedPageMgr(WebDriver driver) {
        mDriver = driver;
        PageFactory.initElements(mDriver,this);
        mTopRatedPageUIMap =new TopRatedPageUIMap(mDriver);
    }


    public void validateMovieList(){
        getMovieList();
        List<WebElement> movieItemPosterCardList= mTopRatedPageUIMap.getMovieItemPosterCardElements();
        for (WebElement movieItemPosterCard:movieItemPosterCardList){
            Movie movie=mMovieList.get(movieItemPosterCardList.indexOf(movieItemPosterCard));
            validateMovie(movieItemPosterCard,movie);
        }
    }

    private void getMovieList(){
        IMovieService movieService=new MovieServiceImpl();
        try {
            mMovieList=movieService.getMoviesByTopRated();
        } catch (MovieServiceException e) {
            e.printStackTrace(); //TODO this needs to go in a separate function
        }
    }
    private void validateMovie(WebElement movieItemPosterCard,Movie movie){

        validateMovieId(mTopRatedPageUIMap.getMovieItemPosterCardIdValue(movieItemPosterCard), String.valueOf(movie.getId()));
        validateMovieOverView(mTopRatedPageUIMap.getMovieItemPosterCardOverViewValue(movieItemPosterCard),movie.getPlotOverview());
    }

    public AccountHomePageMgr clickUserHome(){
        mTopRatedPageUIMap.clickUserHomeLinkElement();
        return new AccountHomePageMgr(mDriver);
    }

    private void validateMovieId(String expected, String actual){
        actual="movie_" + actual;
/*        System.out.println(expected);
        System.out.println(actual);*/

        Assert.assertTrue(expected.trim().equalsIgnoreCase(actual.trim()),"validateMovieId");
    }

    private void validateMovieOverView(String expected, String actual){
/*
        System.out.println(expected);
        System.out.println(actual);
*/
        Assert.assertTrue(expected.substring(0,5).trim().equalsIgnoreCase(actual.substring(0,5).trim()),"validateMovieOverView");
    }

    protected void load() {

    }

    protected void isLoaded() throws Error {
        try {
            Assert.assertTrue(mTopRatedPageUIMap.getUserHomeLinkElement().isDisplayed(), "UserHomeLinkElement is not displayed"); //TODO this check can be made generic
        } catch (NoSuchElementException ex) {
            throw new AssertionError();
        }
    }
}
