package com.ozcanalasalvar.samplemapapp.usecase

import com.ozcanalasalvar.core.network.model.BaseModel
import com.ozcanalasalvar.core.repository.MapRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val repository: MapRepository) {

    suspend fun getPlacesFromApi(input: String): BaseModel = repository.getPlacesFromApi(input)

}