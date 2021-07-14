package com.msa.movie_msa.data.remote.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response_Movie_All(

    @SerializedName("data")
    val data: List<Data>,

    @SerializedName("metadata")
    val metadata: Metadata
)