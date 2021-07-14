package com.msa.movie_msa

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Ali Soleimani on 08,May,2021
 * Github https://github.com/ALISCHILLER
 * Iran.
 */
@HiltAndroidApp
class MovieExploreApp:Application()

fun enableLogging() = BuildConfig.BUILD_TYPE != "release"