package com.ozcanalasalvar.samplemapapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ozcanalasalvar.core.repository.MapRepository
import com.ozcanalasalvar.samplemapapp.ui.search.SearchViewModel
import com.ozcanalasalvar.samplemapapp.usecase.SearchUseCase
import javax.inject.Inject

class ViewModelProviderFactory @Inject constructor(private val repository: MapRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java))
            return SearchViewModel(
                SearchUseCase(repository)
            ) as T
        else
            throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name);
    }
}