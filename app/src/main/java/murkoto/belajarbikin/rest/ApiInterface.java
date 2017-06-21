package murkoto.belajarbikin.rest;

import murkoto.belajarbikin.model.Articles;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by WIN10 on 21/06/2017.
 */

public interface ApiInterface {
    @GET("articles")
    Call<Articles> getTopArticles(@Query("source") String src, @Query("sortBy") String srt, @Query("apiKey") String apiKey);
}
