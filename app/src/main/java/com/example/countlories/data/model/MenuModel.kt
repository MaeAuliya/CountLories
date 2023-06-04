package com.example.countlories.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuModel(

    @field: SerializedName("name")
    val name: String,

    @field: SerializedName("imageUrl")
    val imageUrl: String,

    @field: SerializedName("calorie")
    val calorie: String,

    @field: SerializedName("description")
    val description: String
) : Parcelable
