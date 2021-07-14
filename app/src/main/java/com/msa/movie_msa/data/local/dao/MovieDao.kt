package com.msa.movie_msa.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.msa.movie_msa.data.local.model.Data_Entity


@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    suspend fun getMovieList(): List<Data_Entity>?

    @Query("SELECT * FROM movie WHERE movie.id = :id")
    suspend fun getMovie(id: String): Data_Entity?

    @Insert(onConflict = IGNORE)
    suspend fun insert(movie: Data_Entity)

    @Insert(onConflict = IGNORE)
    suspend fun insert(list: List<Data_Entity>)

    @Insert(onConflict = REPLACE)
    suspend fun update(movie: Data_Entity)

    @Delete
    suspend fun deleteMovie(movie: Data_Entity)

    @Query("DELETE FROM movie WHERE id = :id")
    suspend fun deleteMovie(id: String)

    @Query("DELETE FROM movie")
    suspend fun deleteAll()

    /*
    @Query("SELECT * FROM playlist " +
    "WHERE playlist_title LIKE '% :playlistTitle %' " +
    "GROUP BY playlist_title " +
    "ORDER BY playlist_title " +
    "LIMIT :limit")
    List<IPlaylist> searchPlaylists(String playlistTitle, int limit);
     */
    @Query("SELECT * FROM movie LIMIT :pageSize OFFSET :pageIndex")
    suspend fun getMoviePage(pageSize: Int, pageIndex: Int): List<Data_Entity>?

}