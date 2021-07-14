package com.msa.movie_msa.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.msa.movie_msa.R
import com.msa.movie_msa.data.remote.Response.MoviePaging
import com.msa.movie_msa.data.remote.model.Data
import com.msa.movie_msa.data.remote.model.Response_Movie_All
import com.msa.movie_msa.databinding.MovieListItemBinding
import com.msa.movie_msa.util.Constants
import com.msa.movie_msa.util.imageHelper.LoadImageHelper
import com.msa.movie_msa.util.setSingleClick
import com.msa.movie_msa.view.base.BaseListAdapter
import com.msa.movie_msa.view.base.BasePagingAdapter

class Movies_List_Adapter(
    val itemClickListener: (Data) -> Unit = {}
): BasePagingAdapter<Data, MovieListItemBinding>(object : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}) {
    override fun getLayoutRes(viewType: Int): Int {
        return R.layout.movie_list_item
    }

    override fun bindFirstTime(binding: MovieListItemBinding) {
        binding.apply {
            root.setSingleClick {
                item?.apply {
                    itemClickListener(this)
                }
            }
        }
    }
}


