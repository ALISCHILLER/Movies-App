package com.msa.movie_msa.repository

import com.msa.movie_msa.data.remote.Response.GetMovieListResponse
import com.msa.movie_msa.data.remote.model.Login
import com.msa.movie_msa.data.remote.model.Register
import com.msa.movie_msa.data.remote.model.Response_Movie_All
import com.msa.movie_msa.data.remote.requests.LoginRequest
import com.msa.movie_msa.data.remote.requests.MoviesListRequest
import kotlinx.coroutines.flow.Flow
import com.msa.movie_msa.data.remote.requests.RegistraRequest
import com.msa.movie_msa.util.Resource
import retrofit2.Response

/**
 * Created by Ali Soleimani on 08,May,2021
 * Github https://github.com/ALISCHILLER
 * Iran.
 */

interface RepositoryInterface {


     //Login Register
     suspend fun login(authLoginRequest: LoginRequest) : Flow<Resource<Login>>
     suspend fun register(registraRequest: RegistraRequest): Response<Register>
     suspend fun getlogin(authLoginRequest: LoginRequest) : Response<Login>


     suspend fun moviesList(moviesListRequest: MoviesListRequest):Flow<Resource<Response_Movie_All>>

     suspend fun getMovieList(
          page: Int
     ): Response_Movie_All

}