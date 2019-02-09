package pramonow.com.androidbasic.activity;

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

import pramonow.com.androidbasic.R;
import pramonow.com.androidbasic.adapter.SampleAdapter;
import pramonow.com.androidbasic.model.Person;
import pramonow.com.androidbasic.network.NetworkBuilder;
import pramonow.com.androidbasic.network.PersonListResponse;
import pramonow.com.androidbasic.util.AdapterClickCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
    Example on making recycler view (list)
    Uncomment the call for trying API call
 */
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

        //Set callback for clicking
        sampleAdapter.setAdapterClickCallback(this);
        recyclerView.setAdapter(sampleAdapter);

    }

    @Override
    public void onClick(View view) {

        //Block for making recycler view without API call
        //Made dummy data to show person added
        Person person = new Person();
        person.setId(1L);
        person.setName("Nama 1");
        person.setRole(1);

        List<Person> personList = new ArrayList<>();

        //Added dummy data twice
        personList.add(person);
        personList.add(person);

        sampleAdapter.setPersonList(personList);

        //Notify so the view will change
        sampleAdapter.notifyDataSetChanged();
        //End of block

        //Starting from here is recycler view with API calling

        /*Call<PersonListResponse> call = NetworkBuilder.service.listPerson();

        call.enqueue(new Callback<PersonListResponse>() {
            @Override
            public void onResponse(Call<PersonListResponse> call, Response<PersonListResponse> response) {
                //Success
                PersonListResponse result = response.body();

                //Parse the result
                List<Person> personList = result.getResult();

                //Add it into list
                sampleAdapter.setPersonList(personList);
                sampleAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PersonListResponse> call, Throwable t) {
                //Fail
            }
        });*/
    }

    /*
        We will use this as callback in our adapter
     */
    @Override
    public void onAdapterClick(Person person) {
        Intent intent = new Intent(this,PersonActivity.class);
        intent.putExtra("name",person.getName());
        startActivity(intent);
    }
}
