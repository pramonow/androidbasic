package pramonow.com.androidbasic.util;

import pramonow.com.androidbasic.model.Person;

//Interface used to pass in data from adapter to new activity
public interface AdapterClickCallback {
    void onAdapterClick(Person person);
}
