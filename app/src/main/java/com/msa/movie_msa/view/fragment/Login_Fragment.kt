package com.msa.movie_msa.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.msa.movie_msa.R
import com.msa.movie_msa.data.local.dao.Login_Dao
import com.msa.movie_msa.databinding.FragmentLoginBinding
import com.msa.movie_msa.util.Status
import com.msa.movie_msa.viewmodel.ViewModel_Movie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@AndroidEntryPoint
class Login_Fragment : Fragment() {
    private var _vBinding: FragmentLoginBinding? = null
    private var loginDao:Login_Dao?=null
    private val vBinding get() = _vBinding!!
    private val viewmodelMovie: ViewModel_Movie by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _vBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return vBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        }
    }
    private fun doObserveViewsWork() {
        viewmodelMovie._loginResult.observe(viewLifecycleOwner, Observer {
            when(it.status){

                Status.SUCCESS ->{

                    findNavController().navigate(R.id.to_movie_list)

                }

                Status.ERROR ->{

                }

                Status.LOADING ->{

                }

            }

        })
    }
}