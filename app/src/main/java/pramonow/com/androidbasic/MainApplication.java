package pramonow.com.androidbasic;

import android.app.Application;

import pramonow.com.androidbasic.network.NetworkBuilder;

//Normal Application Example
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkBuilder.initializeNetwork();
    }
}
