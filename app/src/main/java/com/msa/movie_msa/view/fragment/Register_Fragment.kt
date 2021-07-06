package com.msa.movie_msa.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.msa.movie_msa.R
import com.msa.movie_msa.databinding.FragmentRegisterBinding
import com.msa.movie_msa.util.NetworkHelper
import com.msa.movie_msa.util.ResponseType
import com.msa.movie_msa.viewmodel.ViewModel_Movie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber


@AndroidEntryPoint
class Register_Fragment() : Fragment() {
    private var _vBinding:FragmentRegisterBinding ?=null
    private val vBinding get() = _vBinding!!
    private val viewmodelMovie:ViewModel_Movie by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _vBinding= FragmentRegisterBinding.inflate(inflater,container,false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vBinding.cirSingUpButton.setOnClickListener {
            registerUser(
                vBinding.outUserEditText.text.toString(),
                vBinding.outEmailEditText.text.toString(),
                vBinding.outPasswordEditText.text.toString()
            )
        }

        vBinding.sigLogin.setOnClickListener {
            findNavController().navigate(R.id.to_login)
        }
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewmodelMovie.RegisterCredentials.let {
            Log.e("Register_body", it.value.toString())
        }
    }
    private fun registerUser(username:String?,email:String?,password:String?){

        if (viewmodelMovie.isValidForRegistration(username,email,password)){
              viewmodelMovie.Register_viewmodel(username!!, email!!, password!!)
            }

    }

}