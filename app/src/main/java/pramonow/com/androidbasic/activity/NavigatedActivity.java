package pramonow.com.androidbasic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pramonow.com.androidbasic.R;

/*
    Activity used for navigation
 */
public class NavigatedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigated);
    }
}
