package com.msa.movie_msa.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.msa.movie_msa.BuildConfig
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Data(

    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster")
    val poster: String,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("images")
    val images: List<String>,

): Parcelable {



    fun getFullPosterPath() =
        if (poster.isNullOrBlank()) null else   poster
}