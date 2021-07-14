package com.msa.movie_msa.data.remote.requests

import com.squareup.moshi.JsonClass
import retrofit2.http.Query

@JsonClass(generateAdapter = true)
data class LoginRequest(
    val grant_type:String,
    val username: String,
    val password: String
)
@JsonClass(generateAdapter = true)
data class RegistraRequest(
    val name:String,
    val email:String,
    val password:String

)
@JsonClass(generateAdapter = true)
data class MoviesListRequest(
    val page:Query
)