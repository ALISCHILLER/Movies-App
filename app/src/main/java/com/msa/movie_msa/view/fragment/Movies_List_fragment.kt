package com.msa.movie_msa.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msa.movie_msa.R
import com.msa.movie_msa.databinding.FragmentMoviesListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [Movies_List_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Movies_List_fragment : Fragment() {
    private var _vBinding:FragmentMoviesListBinding?=null
    private val vBinding get() = _vBinding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _vBinding= FragmentMoviesListBinding.inflate(inflater,container,false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}