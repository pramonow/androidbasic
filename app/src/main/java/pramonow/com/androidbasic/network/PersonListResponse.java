package pramonow.com.androidbasic.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pramonow.com.androidbasic.model.Person;

public class PersonListResponse {

    @SerializedName("message")
    private List<Person> result;

    public List<Person> getResult() {
        return result;
    }
}
