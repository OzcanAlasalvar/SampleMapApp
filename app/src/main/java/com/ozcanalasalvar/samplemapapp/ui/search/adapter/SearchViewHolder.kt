package com.ozcanalasalvar.samplemapapp.ui.search.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ozcanalasalvar.core.network.model.Result
import com.ozcanalasalvar.samplemapapp.ui.search.SearchNavigator
import com.ozcanalasalvar.samplemapapp.databinding.SearchItemLayoutBinding

class SearchViewHolder(var binding: SearchItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(result: Result, navigator: SearchNavigator) {
        binding.model = result
        binding.navigator=navigator
        binding.executePendingBindings()
    }
}