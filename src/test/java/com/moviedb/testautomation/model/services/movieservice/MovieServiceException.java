package com.moviedb.testautomation.model.services.movieservice;

/**
 * Created by Sarthak on 9/29/2016.
 */
public class MovieServiceException extends Exception {

    public MovieServiceException(final String message) {
        super(message);
    }

    public MovieServiceException(final String message,final Throwable cause) {
        super(message, cause);
    }
}
