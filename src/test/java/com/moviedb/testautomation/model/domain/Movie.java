package com.moviedb.testautomation.model.domain;

/**
 * Created by Sarthak on 9/29/2016.
 */
public class Movie {

    private int mId;
    private String mOriginalTitle;
    private String mPlotOverview;
    private double mVoteAverage;
    private String mReleaseDate;
    private double mPopularity;
    private String mPosterPath;

    public Movie() {

    }

    public Movie(String posterPath, int id, String originalTitle, String plotOverview, double popularity, String releaseDate, double voteAverage) {
        mPosterPath = posterPath;
        mId = id;
        mOriginalTitle = originalTitle;
        mPlotOverview = plotOverview;
        mPopularity = popularity;
        mReleaseDate = releaseDate;
        mVoteAverage = voteAverage;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
    }

    public String getPlotOverview() {
        return mPlotOverview;
    }

    public void setPlotOverview(String plotOverview) {
        mPlotOverview = plotOverview;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(double popularity) {
        mPopularity = popularity;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mId=" + mId +
                ", mOriginalTitle='" + mOriginalTitle + '\'' +
                ", mPlotOverview='" + mPlotOverview + '\'' +
                ", mVoteAverage=" + mVoteAverage +
                ", mReleaseDate='" + mReleaseDate + '\'' +
                ", mPopularity=" + mPopularity +
                ", mPosterPath='" + mPosterPath + '\'' +
                '}';
    }


}
