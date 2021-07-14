package com.msa.movie_msa.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movie")
data class Data_Entity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val poster: String,
    val genres: List<String>,
    val images: List<String>,

)