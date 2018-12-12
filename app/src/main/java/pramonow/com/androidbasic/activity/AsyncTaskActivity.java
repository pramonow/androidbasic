package pramonow.com.androidbasic.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import pramonow.com.androidbasic.R;
import pramonow.com.androidbasic.util.AsyncTaskClass;

/*
    Activity showing how to implement Async Task with 2 different methods:
    1. With Inner class
    2. With outer class
 */

public class AsyncTaskActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        button = findViewById(R.id.task_button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //example on outer class
        //AsyncTaskClass asyncTaskClass = new AsyncTaskClass();
        //asyncTaskClass.execute();

        InnerAsyncTask innerAsyncTask = new InnerAsyncTask(this);
        innerAsyncTask.execute("params");
    }

    /*
        Inner async task class example
     */
    private class InnerAsyncTask extends AsyncTask<String, Void, Integer> {

        private WeakReference<AsyncTaskActivity> activityReference;
        private AsyncTaskActivity asyncTaskActivity;

        public InnerAsyncTask(AsyncTaskActivity context)
        {
            activityReference = new WeakReference<>(context);
            asyncTaskActivity = activityReference.get();
        }

        @Override
        protected Integer doInBackground(String... params) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 3;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Toast.makeText(asyncTaskActivity,integer + " Seconds have passed", Toast.LENGTH_SHORT).show();
        }

    }
}
