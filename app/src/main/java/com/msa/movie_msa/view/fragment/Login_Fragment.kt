package com.msa.movie_msa.view.fragment


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.msa.movie_msa.R
import com.msa.movie_msa.data.local.dao.Login_Dao
import com.msa.movie_msa.databinding.FragmentLoginBinding
import com.msa.movie_msa.util.Status
import com.msa.movie_msa.viewmodel.ViewModel_Login_Regiter_Movie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi

/**
 * Created by Ali Soleimani on 08,May,2021
 * Github https://github.com/ALISCHILLER
 * Iran.
 */
@InternalCoroutinesApi
@AndroidEntryPoint
class Login_Fragment : Fragment() {

    private var _vBinding: FragmentLoginBinding? = null
    private val vBinding get() = _vBinding!!
    private val viewmodelMovie: ViewModel_Login_Regiter_Movie by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _vBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return vBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       val preferences: SharedPreferences = requireActivity().getSharedPreferences("user",Context.MODE_PRIVATE)
        if (!preferences.getString("email","").isNullOrEmpty() && !preferences.getString("password","").isNullOrEmpty()){
            LoginUser(
                email = preferences.getString("email","").toString(),
                password =  preferences.getString("password","").toString()
            )
        }

        vBinding.loSingUp.setOnClickListener {
            findNavController().navigate(R.id.to_sing_up)
        }


        vBinding.cirLoginButton.setOnClickListener {
            LoginUser(
                email = vBinding.outlinedEmailText.text.toString(),
                password = vBinding.outlinePasswordText.text.toString()
            )
        }
        doObserveViewsWork()
    }


    private fun LoginUser(email:String, password:String){
        if (viewmodelMovie.isValidForLogin(email,password)){
            viewmodelMovie.Login_viewmodel(email,password)
            vBinding.progressbar.visibility = View.VISIBLE
        }
    }
    private fun doObserveViewsWork() {
        viewmodelMovie._loginResult.observe(viewLifecycleOwner, Observer {
            when(it.status){

                Status.SUCCESS ->{

                    findNavController().navigate(R.id.to_movie_list)


                }

                Status.ERROR ->{
                    vBinding.progressbar.visibility = View.INVISIBLE
                }

                Status.LOADING ->{
                    vBinding.progressbar.visibility = View.INVISIBLE

                }

            }

        })
    }
}