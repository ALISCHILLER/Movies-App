package com.msa.movie_msa.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.msa.movie_msa.R
import com.msa.movie_msa.data.local.dao.Login_Dao
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ali Soleimani on 08,May,2021
 * Github https://github.com/ALISCHILLER
 * Iran.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}