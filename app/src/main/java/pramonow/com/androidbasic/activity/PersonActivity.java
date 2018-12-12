package pramonow.com.androidbasic.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import pramonow.com.androidbasic.R;

/*
    Class example for getting intent data
 */
public class PersonActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        textView = findViewById(R.id.name);

        String name = getIntent().getStringExtra("nama");
        textView.setText(name);
    }
}
