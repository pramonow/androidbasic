package pramonow.com.android_howto.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pramonow.com.android_howto.R;
import pramonow.com.android_howto.network.NetworkBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        Call<String> call = NetworkBuilder.service.listPerson();

        //String result = call.execute().body();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //Success
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                //Fail
            }
        });
    }
}
