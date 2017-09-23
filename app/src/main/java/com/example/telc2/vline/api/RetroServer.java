package com.example.telc2.vline.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by juvetic on 9/23/17.
 */

public class RetroServer {

    public static final String base_url = "http://192.168.20.237/";

    private static Retrofit retrofit;

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static ApiRequest getRequestService() {
        return getClient().create(ApiRequest.class);
    }



}
