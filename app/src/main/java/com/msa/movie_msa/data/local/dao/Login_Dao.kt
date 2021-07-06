package com.msa.movie_msa.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.msa.movie_msa.data.local.model.Login_Entity
import com.msa.movie_msa.util.Resource
import kotlinx.coroutines.flow.Flow

@Dao
interface Login_Dao {

    @Insert
    suspend fun insertlogin(loginEntity: Login_Entity)



     @Query("delete from user")
     fun deleatlogin()

    @Query("select * from user")
     fun getAll(): Flow<List<Login_Entity>>

}