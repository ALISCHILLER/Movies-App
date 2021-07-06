package com.msa.movie_msa.repository

import com.msa.movie_msa.data.local.model.Login_Entity
import com.msa.movie_msa.data.remote.model.Login
import com.msa.movie_msa.data.remote.model.Register
import com.msa.movie_msa.data.remote.requests.LoginRequest
import kotlinx.coroutines.flow.Flow
import com.msa.movie_msa.data.remote.requests.RegistraRequest
import com.msa.movie_msa.util.AuthToken
import com.msa.movie_msa.util.Resource
import com.msa.movie_msa.util.ViewState
import retrofit2.Response


interface RepositoryInterface {


     suspend fun login(authLoginRequest: LoginRequest) : Flow<Resource<Login>>


    suspend fun register(registraRequest: RegistraRequest): Response<Register>

    suspend fun getlogin(authLoginRequest: LoginRequest) : Response<Login>



}