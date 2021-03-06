package com.msa.movie_msa.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msa.movie_msa.R
import com.msa.movie_msa.databinding.FragmentProfileBinding


/**
 * Created by Ali Soleimani on 08,May,2021
 * Github https://github.com/ALISCHILLER
 * Iran.
 */
class Profile_fragment : Fragment() {

   private var _vBinding:FragmentProfileBinding?=null
    private val vBinding get() = _vBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _vBinding= FragmentProfileBinding.inflate(inflater,container,false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}