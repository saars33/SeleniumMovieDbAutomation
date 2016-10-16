package com.moviedb.testautomation.model.services.movieservice;

import com.moviedb.testautomation.model.domain.Movie;

import java.util.List;

/**
 * Created by Sarthak on 9/29/2016.
 */
public interface IMovieService {
    public final String NAME="IMovieService";

    public List<Movie> getMoviesByPopularity() throws MovieServiceException;

    public  List<Movie> getMoviesByTopRated() throws MovieServiceException;

}