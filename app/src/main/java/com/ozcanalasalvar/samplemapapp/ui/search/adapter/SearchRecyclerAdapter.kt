package com.ozcanalasalvar.samplemapapp.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ozcanalasalvar.samplemapapp.ui.search.SearchNavigator
import com.ozcanalasalvar.samplemapapp.R
import com.ozcanalasalvar.samplemapapp.databinding.SearchItemLayoutBinding
import com.ozcanalasalvar.core.network.model.Result

class SearchRecyclerAdapter(private val resultList: ArrayList<Result>, val navigator: SearchNavigator) :
    RecyclerView.Adapter<SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<SearchItemLayoutBinding>(
            inflater,
            R.layout.search_item_layout,
            parent,
            false
        )

        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int = resultList.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(resultList[position],navigator)
    }

    fun notifyDataChanges(list: List<Result>) {
        resultList.clear()
        resultList.addAll(list)
        notifyDataSetChanged()
    }

}