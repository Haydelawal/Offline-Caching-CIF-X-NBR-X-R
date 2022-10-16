package com.example.offlinecaching_cif.data

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.offlinecaching_cif.utils.Constants.RESTAURANT_TABLE


@Entity(tableName = RESTAURANT_TABLE)
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val type: String,
    val logo: String,
    val address: String
)