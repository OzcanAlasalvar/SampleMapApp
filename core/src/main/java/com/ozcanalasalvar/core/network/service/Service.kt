package com.ozcanalasalvar.core.network.service

import com.ozcanalasalvar.core.network.model.BaseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface Service {

    @GET("/maps/api/place/textsearch/json")
    suspend fun fetchPlaces(
        @Query("query") input: String,
        @Query("key") apiKey: String
    ): BaseModel

}