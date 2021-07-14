package com.msa.movie_msa.view.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.msa.movie_msa.R
import com.msa.movie_msa.databinding.FragmentSplashBinding
import com.msa.movie_msa.util.Status
import com.msa.movie_msa.view.base.BaseFragment
import com.msa.movie_msa.view.base.BaseViewModel
import com.msa.movie_msa.viewmodel.ViewModel_Login_Regiter_Movie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * Created by Ali Soleimani on 08,May,2021
 * Github https://github.com/ALISCHILLER
 * Iran.
 */
@AndroidEntryPoint
class Splash_Fragment : BaseFragment<FragmentSplashBinding,BaseViewModel>(){
    override val layoutId: Int = R.layout.fragment_splash
    override val viewModel: BaseViewModel by viewModels()
    private val viewmodelMovie: ViewModel_Login_Regiter_Movie by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(1000)
            navigateToOther()
        }
        doObserveViewsWork()
    }
    private fun navigateToOther() {
        val preferences: SharedPreferences = requireActivity().getSharedPreferences("user", Context.MODE_PRIVATE)
        if (!preferences.getString("email","").isNullOrEmpty() &&
            !preferences.getString("password","").isNullOrEmpty()){
            LoginUser(
                email = preferences.getString("email","").toString(),
                password =  preferences.getString("password","").toString()
            )
        }else{
            findNavController().navigate(R.id.to_login)
        }
    }

    private fun LoginUser(email:String, password:String){
        if (viewmodelMovie.isValidForLogin(email,password)){
            viewmodelMovie.Login_viewmodel(email,password)
        }
    }

    private fun doObserveViewsWork() {
        viewmodelMovie._loginResult.observe(viewLifecycleOwner, Observer {
            when(it.status){

                Status.SUCCESS ->{

                    findNavController().navigate(R.id.to_movie_list)


                }

                Status.ERROR ->{
                    findNavController().navigate(R.id.to_login)
                }

                Status.LOADING ->{


                }

            }

        })
    }

}