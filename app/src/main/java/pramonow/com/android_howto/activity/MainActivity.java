package pramonow.com.android_howto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pramonow.com.android_howto.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonOne, buttonTwo, buttonNavigate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonNavigate = findViewById(R.id.buttonNavigate);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);

        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateActivity();
            }
        });
    }

    @Override
    public void onClick(View view) {

        if(view == buttonOne)
        {
            Toast.makeText(this,"Button one pressed", Toast.LENGTH_SHORT).show();
        }
        else if(view == buttonTwo)
        {
            Toast.makeText(this,"Button two pressed", Toast.LENGTH_SHORT).show();
        }
    }

    private void navigateActivity()
    {
        Intent intent = new Intent(this, NavigatedActivity.class);
        startActivity(intent);
    }
}
