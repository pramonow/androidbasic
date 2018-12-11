package pramonow.com.android_howto.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pramonow.com.android_howto.model.Person;

public class PersonListResponse {

    @SerializedName("message")
    private List<Person> result;

    public List<Person> getResult() {
        return result;
    }
}
