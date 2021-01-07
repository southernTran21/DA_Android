package com.example.da_android;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("account")
    Call<List<Post>> getPost();

}
