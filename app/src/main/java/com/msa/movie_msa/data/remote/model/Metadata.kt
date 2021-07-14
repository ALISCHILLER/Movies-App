package com.msa.movie_msa.data.remote.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Metadata(
    @SerializedName("current_page")
    val current_page: Int,
    @SerializedName("page_count")
    val page_count: Int,
    @SerializedName("per_page")
    val per_page: Int,
    @SerializedName("total_count")
    val total_count: Int
)