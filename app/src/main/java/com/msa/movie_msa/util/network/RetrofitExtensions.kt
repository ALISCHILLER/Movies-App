package com.msa.movie_msa.util.network

import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

fun <T> httpError(code: Int): Response<T> = Response.error<T>(code, "".toResponseBody(null))
