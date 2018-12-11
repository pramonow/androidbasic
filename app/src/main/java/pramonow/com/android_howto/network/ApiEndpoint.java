package pramonow.com.android_howto.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndpoint {
    @GET("member/list")
    Call<PersonListResponse> listPerson();
}
