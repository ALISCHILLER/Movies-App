package com.msa.movie_msa.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.msa.movie_msa.R
import com.msa.movie_msa.databinding.FragmentSplashBinding
import com.msa.movie_msa.view.base.BaseFragment
import com.msa.movie_msa.view.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Splash_Fragment : BaseFragment<FragmentSplashBinding,BaseViewModel>(){
    override val layoutId: Int = R.layout.fragment_splash
    override val viewModel: BaseViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(1000)
          //  navigateToOther()
        }
    }

}