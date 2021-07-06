package com.msa.movie_msa.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.msa.movie_msa.data.local.dao.Login_Dao
import com.msa.movie_msa.data.local.model.Login_Entity


@Database(entities = [Login_Entity::class],version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getlogin_dao():Login_Dao

    companion object {
        const val DATABASE_NAME = "app_db"
    }
}