package com.example.offlinecaching_cif.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.offlinecaching_cif.data.Restaurant
import com.example.offlinecaching_cif.data.RestaurantDao
import com.example.offlinecaching_cif.utils.MyConverter

@Database(entities = [Restaurant::class], version = 1)
@TypeConverters(MyConverter::class)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}