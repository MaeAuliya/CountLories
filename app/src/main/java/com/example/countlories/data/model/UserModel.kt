package com.example.countlories.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName


@Parcelize
data class UserModel(

    @field: SerializedName("username")
    val username : String,

    @field: SerializedName("email")
    val email : String,

    @field: SerializedName("password")
    val password : String,

    @field: SerializedName("imageUrl")
    val imageUrl : String? = null

) : Parcelable