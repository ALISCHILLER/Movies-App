package com.msa.movie_msa.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msa.movie_msa.databinding.FragmentBtnLnavMoviesBinding
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass.
 * Use the [Btn_Nav_Movies_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class Btn_Nav_Movies_Fragment : Fragment() {
    private var _vBinding:FragmentBtnLnavMoviesBinding?=null
    private val vBinding get() = _vBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _vBinding = FragmentBtnLnavMoviesBinding.inflate(inflater, container, false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}