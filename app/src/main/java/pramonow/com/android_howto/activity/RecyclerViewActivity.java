package pramonow.com.android_howto.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pramonow.com.android_howto.R;
import pramonow.com.android_howto.adapter.SampleAdapter;
import pramonow.com.android_howto.model.Person;
import pramonow.com.android_howto.network.NetworkBuilder;
import pramonow.com.android_howto.network.PersonListResponse;
import pramonow.com.android_howto.util.AdapterClickCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener, AdapterClickCallback {

    RecyclerView recyclerView;
    SampleAdapter sampleAdapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.member_list);
        button = findViewById(R.id.load);
        button.setOnClickListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        sampleAdapter = new SampleAdapter();
        sampleAdapter.setAdapterClickCallback(this);
        recyclerView.setAdapter(sampleAdapter);

    }

    @Override
    public void onClick(View view) {

        Person person = new Person();
        person.setId(1L);
        person.setName("Nama 1");
        person.setRole(1);

        List<Person> personList = new ArrayList<>();
        personList.add(person);

        sampleAdapter.setPersonList(personList);
        sampleAdapter.notifyDataSetChanged();

        /*Call<PersonListResponse> call = NetworkBuilder.service.listPerson();
        //String result = call.execute().body();

        call.enqueue(new Callback<PersonListResponse>() {
            @Override
            public void onResponse(Call<PersonListResponse> call, Response<PersonListResponse> response) {
                //Success

                PersonListResponse result = response.body();
                List<Person> personList = result.getResult();

                sampleAdapter.setPersonList(personList);
                sampleAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PersonListResponse> call, Throwable t) {
                Log.d("baniman", "fail " + t.getMessage());
                //Fail
            }
        });*/
    }

    @Override
    public void onAdapterClick(Person person) {
        Intent intent = new Intent(this,PersonActivity.class);
        intent.putExtra("nama",person.getName());
        startActivity(intent);
    }
}
