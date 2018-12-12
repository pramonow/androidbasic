package pramonow.com.androidbasic.network;

import android.util.Log;

import pramonow.com.androidbasic.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
    Class for making network
 */

public class NetworkBuilder {

    public static ApiEndpoint service;

    public static void initializeNetwork(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiEndpoint.class);
    }
}
