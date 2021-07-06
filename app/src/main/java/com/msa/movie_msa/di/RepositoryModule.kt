package com.msa.movie_msa.di



import com.msa.movie_msa.data.local.dao.Login_Dao
import com.msa.movie_msa.data.remote.ApiService
import com.msa.movie_msa.repository.RepositoryIm
import com.msa.movie_msa.repository.RepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(
        apiService: ApiService,
        loginDao: Login_Dao

    ): RepositoryInterface {
        return RepositoryIm(
          apiService = apiService,
            loginDao = loginDao
          )
    }
}