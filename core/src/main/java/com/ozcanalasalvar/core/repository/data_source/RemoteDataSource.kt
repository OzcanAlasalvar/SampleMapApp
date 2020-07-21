package com.ozcanalasalvar.core.repository.data_source

import com.ozcanalasalvar.core.BuildConfig
import com.ozcanalasalvar.core.network.model.BaseModel
import com.ozcanalasalvar.core.network.service.Service
import io.reactivex.Single

import javax.inject.Inject

private const val API_KEY = BuildConfig.API_KEY

class RemoteDataSource @Inject constructor(private val service: Service) :
    RemoteSource {


    override suspend fun getPlacesFromApi(input: String): BaseModel {
        return service.fetchPlaces(
            input,
            API_KEY
        )
    }
}