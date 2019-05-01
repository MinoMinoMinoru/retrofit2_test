package com.example.http_test.Retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HTTP_Interface {
//    @FormUrlEncoded
//    formやと怒られる！！！
    @POST("./")
    Call<PostBody> createRequest(@Body PostBody pBody);

}
