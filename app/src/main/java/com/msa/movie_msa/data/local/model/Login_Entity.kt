package com.msa.movie_msa.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class Login_Entity(

    val token_type: String?,
    @PrimaryKey(autoGenerate = false)
    val expries_in: Int?,
    val refresh_token: String?,
    val access_token: String?,
)