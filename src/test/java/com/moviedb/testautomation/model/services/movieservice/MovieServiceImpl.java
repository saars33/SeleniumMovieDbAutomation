package com.moviedb.testautomation.model.services.movieservice;

import com.moviedb.testautomation.model.domain.Movie;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarthak on 9/29/2016.
 */
public class MovieServiceImpl implements IMovieService {

    private String API_KEY_PARAM_VALUE="7ad4746a014b069d279129054ba59f8b";

    private static final String API_KEY_PARAM_KEY = "api_key";
    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static final String POPULAR_MOVIES_APPENDED_URL = "/movie/popular";
    private static final String TOP_RATED_MOVIES_APPENDED_URL = "/movie/top_rated";

    public List<Movie> getMoviesByPopularity() throws MovieServiceException {
        List<Movie> movieList;
        String appendedUrl=BASE_URL + POPULAR_MOVIES_APPENDED_URL;
        String urlSpec=null;
        try {
            urlSpec= new URIBuilder(appendedUrl).addParameter(API_KEY_PARAM_KEY, API_KEY_PARAM_VALUE).build().toString();
            movieList=getMovieListForUrl(urlSpec);
        } catch (IOException e) {
            throw new MovieServiceException("IOException thrown by getMovieListForUrl for urlSpec: " +urlSpec,e);
        } catch (JSONException e) {
            throw new MovieServiceException("JSONException thrown by getMovieListForUrl for urlSpec: " +urlSpec,e);
        } catch (URISyntaxException e) {
            throw new MovieServiceException("URISyntaxException thrown by getMovieListForUrl for urlSpec: " +urlSpec,e);
        }
        return movieList;
    }

    public List<Movie> getMoviesByTopRated() throws MovieServiceException {

        List<Movie> movieList;
        String appendedUrl=BASE_URL + TOP_RATED_MOVIES_APPENDED_URL;
        String urlSpec=null;
        try {
            urlSpec= new URIBuilder(appendedUrl).addParameter(API_KEY_PARAM_KEY, API_KEY_PARAM_VALUE).build().toString();
            movieList=getMovieListForUrl(urlSpec);
        } catch (IOException e) {
            throw new MovieServiceException("IOException thrown by getMovieListForUrl for urlSpec: " +urlSpec,e);
        } catch (JSONException e) {
            throw new MovieServiceException("JSONException thrown by getMovieListForUrl for urlSpec: " +urlSpec,e);
        } catch (URISyntaxException e) {
            throw new MovieServiceException("URISyntaxException thrown by getMovieListForUrl for urlSpec: " +urlSpec,e);
        }
        return movieList;
    }

    public String getResponsePayload(String urlSpec) throws IOException {
        String retVal=null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(urlSpec);
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new IOException("Received a response status of " + response.getStatusLine() + "for the urlSpec" + urlSpec);
            }

            inputStreamReader = new InputStreamReader(response.getEntity().getContent());
            bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder builder = new StringBuilder();
            String line;
            int cntr = 0;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line).append("\n"); //Adding a new line isn't necessary but will provide more readability
            }
            retVal=builder.toString();
        }finally {
            httpClient.close();
            if(response!=null){
                response.close();
            }
            if(bufferedReader!=null){
                bufferedReader.close();
            }
            if(inputStreamReader!=null){
                inputStreamReader.close();
            }
        }
        return retVal;
    }

    private List<Movie> getMovieListForUrl(String urlSpec) throws IOException, JSONException {
        List<Movie> movieList;
        String responseJSON=getResponsePayload(urlSpec);
        JSONObject responseJsonObject=new JSONObject(responseJSON);
        movieList=parseResponseAndReturnMovieList(responseJsonObject);

        return movieList;
    }

    private List<Movie> parseResponseAndReturnMovieList(JSONObject jsonBody) throws JSONException {
        ArrayList<Movie> movieArrayList = new ArrayList<Movie>();

        JSONArray resultsJsonArray=jsonBody.getJSONArray("results");
        for (int itr=0;itr<resultsJsonArray.length();itr++){
            JSONObject movieJsonObject=resultsJsonArray.getJSONObject(itr);
            Movie movie=returnMovieForJSONObject(movieJsonObject);
            movieArrayList.add(movie);
        }
        return movieArrayList;
    }

    private Movie returnMovieForJSONObject(JSONObject jsonObject) throws JSONException {
        int id = jsonObject.getInt("id");
        String original_title = jsonObject.getString("original_title");
        String overview = jsonObject.getString("overview");
        double vote_average = jsonObject.getDouble("vote_average");
        double popularity=jsonObject.getDouble("popularity");
        String poster_path=jsonObject.getString("poster_path");
        String release_date=jsonObject.getString("release_date");

        return new Movie(poster_path, id, original_title, overview, popularity, release_date, vote_average);

    }

}
