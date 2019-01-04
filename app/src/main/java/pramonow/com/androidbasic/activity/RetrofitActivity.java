package pramonow.com.androidbasic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import pramonow.com.androidbasic.R;
import pramonow.com.androidbasic.model.Person;
import pramonow.com.androidbasic.network.NetworkBuilder;
import pramonow.com.androidbasic.network.PersonListResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
    Example class on Retrofit usage
    Using enqueue
 */

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {

    Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        callButton = findViewById(R.id.call);
        callButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Call<PersonListResponse> call = NetworkBuilder.service.listPerson();

        //Calling network here
        call.enqueue(new Callback<PersonListResponse>() {
            @Override
            public void onResponse(Call<PersonListResponse> call, Response<PersonListResponse> response) {
                Toast.makeText(RetrofitActivity.this,"Success",Toast.LENGTH_SHORT).show();
                PersonListResponse result = response.body();
                List<Person> personList = result.getResult();

                for(int i = 0; i<personList.size();i++)
                    Log.d("TAG HERE", personList.get(i).getName());
            }

            @Override
            public void onFailure(Call<PersonListResponse> call, Throwable t) {
                Log.d("TAG HERE", "fail " + t.getMessage());
            }
        });
    }
}
