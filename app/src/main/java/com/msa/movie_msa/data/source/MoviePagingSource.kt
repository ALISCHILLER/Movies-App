package com.msa.movie_msa.data.source


import android.util.Log
import com.msa.movie_msa.data.remote.ApiParams
import com.msa.movie_msa.data.remote.model.Data
import com.msa.movie_msa.data.remote.model.Response_Movie_All
import com.msa.movie_msa.repository.RepositoryInterface


class MoviePagingSource(
    private val userRepository: RepositoryInterface
) : BasePagingSource<Data>() {

    override suspend fun loadData(params: LoadParams<Int>): List<Data>? {
        val hashMap = HashMap<String, String>()
        hashMap[ApiParams.PAGE] = (params.key ?: getFirstPage()).toString()
        hashMap[ApiParams.SORT_BY] = ApiParams.POPULARITY_DESC

        var page=(params.key ?: getFirstPage()).toInt()
        Log.e("page",page.toString())
        return userRepository.getMovieList(page).data
    }
}