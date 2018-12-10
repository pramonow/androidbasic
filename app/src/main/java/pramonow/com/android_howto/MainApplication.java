package pramonow.com.android_howto;

import android.app.Application;

import pramonow.com.android_howto.network.NetworkBuilder;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkBuilder.initializeNetwork();
    }
}
