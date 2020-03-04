package com.android.elegantapp.api;

import android.content.Context;
import android.util.Log;

import com.android.elegantapp.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private final String LOG_TAG = ApiClient.class.getSimpleName();
    private static String baseURL;
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        baseURL = "https://dl.dropboxusercontent.com/s/6nt7fkdt7ck0lue/";

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
