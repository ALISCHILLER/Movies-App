package com.msa.movie_msa.di

import android.content.Context
import com.msa.movie_msa.data.remote.ApiService
import com.msa.movie_msa.util.Constants
import com.msa.movie_msa.util.interceptor.ConnectionInterceptor
import com.msa.movie_msa.util.network.ConnectionObserver


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideConnectionObserver(@ApplicationContext context: Context): ConnectionObserver =
        ConnectionObserver(context)

    @Provides
    @Singleton
    fun provideConnectionInterceptor(connectionObserver: ConnectionObserver): ConnectionInterceptor =
        ConnectionInterceptor(connectionObserver)

    @Provides
    @Singleton
    fun provideOkHttpClient(connectionInterceptor: ConnectionInterceptor): OkHttpClient =
        OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(connectionInterceptor)
            .readTimeout(20, TimeUnit.SECONDS).build()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()



    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient).build()

    @Provides
    @Singleton
    fun provideMovieApis(retrofit: Retrofit):
            ApiService = retrofit.create(ApiService::class.java)
    
}
