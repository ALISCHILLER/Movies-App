package com.msa.movie_msa.view.fragment


import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.msa.movie_msa.data.remote.model.Data
import com.msa.movie_msa.data.remote.model.Response_Movie_All
import com.msa.movie_msa.databinding.FragmentMoviesListBinding
import com.msa.movie_msa.view.adapter.Movies_List_Adapter
import com.msa.movie_msa.view.base.BasePagingAdapter
import com.msa.movie_msa.view.base.BasePagingFragment
import com.msa.movie_msa.view.base.getNavController
import com.msa.movie_msa.viewmodel.ViewModel_List_Movie
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Ali Soleimani on 08,May,2021
 * Github https://github.com/ALISCHILLER
 * Iran.
 */
@AndroidEntryPoint
class Movies_List_fragment :BasePagingFragment<FragmentMoviesListBinding,ViewModel_List_Movie, Data>(){

    override val viewModel: ViewModel_List_Movie by viewModels()


    override val pagingAdapter: BasePagingAdapter<Data, out ViewDataBinding> by lazy {
        Movies_List_Adapter(
            itemClickListener = {
                toMovieDetail(it)
            }
        )
    }

    override val swipeRefreshLayout: SwipeRefreshLayout
        get() = viewBinding.refreshLayout

    override val recyclerView: RecyclerView
        get() = viewBinding.recyclerView

    private fun toMovieDetail(movie: Data) {
    }
}