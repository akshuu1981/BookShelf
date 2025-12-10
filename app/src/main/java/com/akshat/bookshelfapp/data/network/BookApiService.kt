package com.akshat.bookshelfapp.data.network

import com.akshat.bookshelfapp.data.model.TopLevel
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiService {

    @GET("volumes")
    suspend fun getBooks(@Query(/* value = */ "q")terms: String): TopLevel
}