package com.example.offlinecaching_cif.api

import com.example.offlinecaching_cif.data.Restaurant
import retrofit2.http.GET

interface RestaurantApi {


    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<Restaurant>
}