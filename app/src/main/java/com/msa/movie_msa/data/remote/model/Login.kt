package com.msa.movie_msa.data.remote.model

import com.google.gson.annotations.SerializedName

data class Login(

    @SerializedName("token_type")
    val token_type: String,
    @SerializedName("expries_in")
    val expries_in: Int,
    @SerializedName("refresh_token")
    val refresh_token: String,
    @SerializedName("access_token")
    val access_token: String

)