package pramonow.com.androidbasic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import pramonow.com.androidbasic.R;

public class VolleyActivity extends AppCompatActivity implements View.OnClickListener {

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

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://4mxhjr9sci.execute-api.ap-southeast-1.amazonaws.com/dev/member/list";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("TAGHERE", "Response is: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAGHERE", "Error");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
