 package com.msa.movie_msa.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*

import com.msa.movie_msa.R
import com.msa.movie_msa.data.local.dao.Login_Dao
import com.msa.movie_msa.data.local.model.Login_Entity
import com.msa.movie_msa.data.remote.model.Login
import com.msa.movie_msa.data.remote.model.Register
import com.msa.movie_msa.data.remote.requests.LoginRequest
import com.msa.movie_msa.data.remote.requests.RegistraRequest
import com.msa.movie_msa.repository.RepositoryInterface
import com.msa.movie_msa.util.*

import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

import timber.log.Timber
import javax.inject.Inject
import kotlin.math.log

 @HiltViewModel
class ViewModel_Movie @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repositoryInterface: RepositoryInterface,
    private val networkHelper: NetworkHelper,
    private var loginDao: Login_Dao
): ViewModel() {
    var onResponse: MutableLiveData<Resource<Register>> = MutableLiveData()
    val _loginResult : MutableLiveData<Resource<Login>> = MutableLiveData()

    val LoginCredentials: LiveData<Resource<Login>>
        get() =_loginResult

    val RegisterCredentials: LiveData<Resource<Register>>
        get() =onResponse

     var db: MutableLiveData<Boolean> = MutableLiveData()

     var _logindaoResult :LiveData<Resource<List<Login_Entity>>> = MutableLiveData()



     fun Login_viewmodel(email:String, password:String) {
         viewModelScope.launch {
             if (networkHelper.isNetworkConnected()) {
                 repositoryInterface.login(
                     LoginRequest(
                         grant_type = "password",
                         username = email,
                         password = password
                     )).collect {
                         _loginResult.postValue(it)
                     Log.i("model",it.toString())
                     Toast.makeText(context, "خوش امدید", Toast.LENGTH_SHORT).show()

                 }

             }else{
                 Timber.e("not connecting network ")
                 Toast.makeText(context, "اتصال اینترنت برقرار نیست ", Toast.LENGTH_SHORT).show()
             }
         }




         }





     fun Register_viewmodel(  Username: String,
                                     Email: String,
                                     Password: String)
    {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()){
                repositoryInterface.register(
                    RegistraRequest(name=Username,email =Email,password = Password)).let {
                    if (it.isSuccessful){
                       onResponse.postValue(Resource.success(it.body()))
                        Log.e("body", Resource.success(it.body()).toString())
                        Toast.makeText(context, "ثبت نام با موفقیت انجام شد ", Toast.LENGTH_SHORT).show()
                    } else {
                        onResponse.postValue(Resource.error(it.errorBody()).toString())
                        Log.e("error", Resource.error(it.errorBody()).toString())
                        Toast.makeText(context, "ثبت نام ناموفق ", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Timber.e("not connecting network ")
                Toast.makeText(context, "اتصال اینترنت برقرار نیست ", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun isValidForLogin(
        loginEmail: String?,
        loginPassword: String?
    ):Boolean{
        if (loginEmail.isNullOrEmpty()
            || loginEmail.isNullOrBlank()
            || loginPassword.isNullOrBlank()
            ||loginPassword.isNullOrEmpty()
        ){
            postErrorValue(
                context.getString(R.string.empty_email_or_password)
            )
            Toast.makeText(context, "نام کاربری ایمیل یا رمز ورود خالی است", Toast.LENGTH_SHORT).show()
            return false
        }
        if(loginPassword.length < 6) {
            postErrorValue(
                context.getString(R.string.invalid_password)

            )
            Toast.makeText(context, "رمز وارد شده کمتر از 6 کارکتر هست ", Toast.LENGTH_SHORT).show()
            return false
        }

        return true

    }

    fun isValidForRegistration(
        confirmRegistrationUsername: String?,
        registrationEmail: String?,
        registrationPassword: String?

    ): Boolean {
        if (registrationEmail.isNullOrEmpty()
            || registrationEmail.isNullOrBlank()
            || registrationPassword.isNullOrEmpty()
            || registrationPassword.isNullOrBlank()
            || confirmRegistrationUsername.isNullOrEmpty()
            || confirmRegistrationUsername.isNullOrBlank()
        ) {
            postErrorValue(
                context.getString(R.string.empty_email_or_password)
            )
            Toast.makeText(context, "نام کاربری ایمیل یا رمز ورود خالی است", Toast.LENGTH_SHORT).show()
            return false

        }

        if(registrationPassword.length < 6) {
            postErrorValue(
                context.getString(R.string.invalid_password)

            )
            Toast.makeText(context, "رمز وارد شده کمتر از 6 کارکتر هست ", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun postErrorValue(errorMessage: String) {

    }

}


 private fun <T> LiveData<T>.postValue(toString: String) {

 }

