package com.msa.movie_msa.data.remote.Response

import com.example.moviedb.data.remote.response.BaseResponse
import com.squareup.moshi.Json

open class BaseListResponse<Item>(
    @Json(name = "page") val page: Int? = null,
    @Json(name = "total_results") val totalResults: Int? = null,
    @Json(name = "total_pages") val totalPages: Int? = null,
    @Json(name = "results") var results: List<Item>? = null
) : BaseResponse()