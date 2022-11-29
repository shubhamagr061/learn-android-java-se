package com.akshara.besoftware.api;

import com.akshara.besoftware.response.FoodResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/food")
    Call<FoodResponse> getFood();
}
