package com.example.offlinecaching_cif.features.restaurants

import androidx.lifecycle.*
import com.example.offlinecaching_cif.api.RestaurantApi
import com.example.offlinecaching_cif.data.Restaurant
import com.example.offlinecaching_cif.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurants()
}