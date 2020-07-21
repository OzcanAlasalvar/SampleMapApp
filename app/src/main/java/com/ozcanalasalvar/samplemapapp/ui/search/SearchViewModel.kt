package com.ozcanalasalvar.samplemapapp.ui.search

import androidx.lifecycle.MutableLiveData
import com.ozcanalasalvar.core.network.model.BaseModel
import com.ozcanalasalvar.samplemapapp.base.BaseViewModel
import com.ozcanalasalvar.samplemapapp.usecase.SearchUseCase
import kotlinx.coroutines.launch

class SearchViewModel(private val useCase: SearchUseCase) : BaseViewModel() {

    val data = MutableLiveData<BaseModel>()

    fun findPlaces(city: String) {
        launch {
            data.value = useCase.getPlacesFromApi(city)
        }
    }


}