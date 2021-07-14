package com.msa.movie_msa.data.remote
import com.msa.movie_msa.data.remote.Response.GetMovieListResponse
import com.msa.movie_msa.data.remote.model.Login
import com.msa.movie_msa.data.remote.model.Register
import com.msa.movie_msa.data.remote.model.Response_Movie_All
import com.msa.movie_msa.data.remote.requests.LoginRequest
import com.msa.movie_msa.data.remote.requests.MoviesListRequest
import com.msa.movie_msa.data.remote.requests.RegistraRequest
import retrofit2.Response
import retrofit2.http.*

interface ApiService {


    @POST("api/v1/register")
    suspend fun register(
        @Body registrationRequest: RegistraRequest
    ):Response<Register>

    @POST("oauth/token")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ):Response<Login>

   // http://moviesapi.ir/api/v1/movies?page={page}
    @GET("api/v1/movies")
    suspend fun MoviesList(
        @Query("page")page:Int
    ): Response_Movie_All


}