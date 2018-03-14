package com.example.user.samallanimationproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by User on 3/13/2018.
 */

public interface ApiSerVice {

    @GET("posts")
    Call<List<RecyclerViewResponse>> getInfomation();
}
