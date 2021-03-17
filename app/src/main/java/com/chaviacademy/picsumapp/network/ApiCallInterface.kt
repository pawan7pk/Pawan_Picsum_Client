package com.chaviacademy.picsumapp.network

import com.chaviacademy.picsumapp.model.AuthorDetails
import retrofit2.Response
import retrofit2.http.GET

interface ApiCallInterface {

    @GET("/list")
    suspend fun getPhotosList(
    ) : Response<ArrayList<AuthorDetails>>
}