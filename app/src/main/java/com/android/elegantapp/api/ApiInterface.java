package com.android.elegantapp.api;

import com.android.elegantapp.modal.apimodal.ReadJson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {

    @GET("hotels.json")
    Call<String> getJsonString(@Header("Content-Type") String cont_type);
}
