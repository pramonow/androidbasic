package pramonow.com.android_howto.network;

import android.util.Log;

import pramonow.com.android_howto.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkBuilder {

    public static ApiEndpoint service;

    public static void initializeNetwork(){

        Log.d("baniman", "initializeNetwork: ");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiEndpoint.class);
    }
}
