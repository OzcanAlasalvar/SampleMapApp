package com.ozcanalasalvar.samplemapapp.ui.search

import com.ozcanalasalvar.core.network.model.Result

interface SearchNavigator {

    fun onPlaceClicked(result: Result)

    fun onCancelClick();
}