package com.msa.movie_msa.data.remote
import com.msa.movie_msa.data.remote.model.Login
import com.msa.movie_msa.data.remote.model.Register
import com.msa.movie_msa.data.remote.requests.LoginRequest
import com.msa.movie_msa.data.remote.requests.RegistraRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {


    @POST("api/v1/register")
    suspend fun register(
        @Body registrationRequest: RegistraRequest
    ):Response<Register>

    @POST("oauth/token")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ):Response<Login>

}