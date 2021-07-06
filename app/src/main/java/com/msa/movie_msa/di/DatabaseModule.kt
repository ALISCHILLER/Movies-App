package com.msa.movie_msa.di

import android.content.Context
import androidx.room.Room
import com.msa.movie_msa.data.local.AppDatabase
import com.msa.movie_msa.data.local.AppDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {



    @Singleton
    @Provides
    fun provideAppDb(@ApplicationContext context: Context):AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideAuthTokenDao(db: AppDatabase) = db.getlogin_dao()

}