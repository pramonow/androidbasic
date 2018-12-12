package pramonow.com.androidbasic.util;

import android.os.AsyncTask;

import java.util.List;

public class AsyncTaskClass extends android.os.AsyncTask<String, Void, Integer> {

    public AsyncTaskClass()
    {

    }

    @Override
    protected Integer doInBackground(String... params) {

        return 0;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        //Do something
    }
}
