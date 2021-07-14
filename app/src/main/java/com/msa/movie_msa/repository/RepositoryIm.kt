package com.msa.movie_msa.repository

import android.util.Log
import com.msa.movie_msa.data.local.dao.Login_Dao
import com.msa.movie_msa.data.local.model.Login_Entity
import com.msa.movie_msa.data.remote.ApiService
import com.msa.movie_msa.data.remote.Response.GetMovieListResponse
import com.msa.movie_msa.data.remote.model.Login
import com.msa.movie_msa.data.remote.model.Register
import com.msa.movie_msa.data.remote.model.Response_Movie_All
import com.msa.movie_msa.data.remote.requests.LoginRequest
import com.msa.movie_msa.data.remote.requests.MoviesListRequest
import com.msa.movie_msa.data.remote.requests.RegistraRequest
import com.msa.movie_msa.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Ali Soleimani on 08,May,2021
 * Github https://github.com/ALISCHILLER
 * Iran.
 */
class RepositoryIm @Inject constructor(
   private val apiService: ApiService,
   private val loginDao: Login_Dao
):RepositoryInterface {

    override suspend fun login(authLoginRequest: LoginRequest): Flow<Resource<Login>> = flow {
        val getresponse=getlogin(authLoginRequest)
        getresponse.let {
            response ->
            if (response.isSuccessful){
                Log.e("body",Resource.success(response.body()).toString())
                loginDao.deleatlogin()
                loginDao.insertlogin(
                    loginEntity = Login_Entity(
                        token_type = response.body()?.token_type,
                        expries_in = response.body()?.expries_in,
                        refresh_token = response.body()?.refresh_token,
                        access_token = response.body()?.access_token))

                emit(Resource.success(response.body()))


            }else{
                Log.e("error",Resource.error(response.errorBody()).toString())
                
            }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun register(registraRequest: RegistraRequest): Response<Register> {
        return apiService.register(registraRequest)

    }

    override suspend fun getlogin(authLoginRequest: LoginRequest): Response<Login> {
        return apiService.login(authLoginRequest)
    }

    override suspend fun moviesList(moviesListRequest: MoviesListRequest): Flow<Resource<Response_Movie_All>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieList(page: Int): Response_Movie_All {
        return apiService.MoviesList(page)
    }



}
/**
 * Created by Ali Soleimani on 08,May,2021
 * Github https://github.com/ALISCHILLER
 * Iran.
 */