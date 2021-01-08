package com.example.da_android;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("account")
    Call<List<Post>> getPost();

    @GET("facility/{id}")
    Call<List<facility>> getFacility(@Path("id") String id);

}
