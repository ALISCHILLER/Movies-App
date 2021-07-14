package com.msa.movie_msa.viewmodel

import com.msa.movie_msa.data.remote.model.Data
import com.msa.movie_msa.data.remote.model.Response_Movie_All
import com.msa.movie_msa.data.source.BasePagingSource
import com.msa.movie_msa.data.source.MoviePagingSource
import com.msa.movie_msa.repository.RepositoryInterface
import com.msa.movie_msa.view.base.BasePagingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel_List_Movie @Inject constructor(
    private val userRepository:RepositoryInterface
): BasePagingViewModel<Data>() {

    override fun createPagingSource(): BasePagingSource<Data> {
        return MoviePagingSource(
            userRepository
        )
    }

}