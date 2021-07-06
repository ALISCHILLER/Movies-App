package com.msa.movie_msa.data.remote.model

import com.google.gson.annotations.SerializedName

data class Register(
    @SerializedName(" created_at")
    val created_at: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("updated")
    val updated_at: String
)