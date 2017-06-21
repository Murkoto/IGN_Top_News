package murkoto.belajarbikin.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WIN10 on 21/06/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "https://newsapi.org/v1/";
    private static Retrofit ret = null;


    public static Retrofit getClient() {
        if (ret == null) {
            ret = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return ret;
    }

}
