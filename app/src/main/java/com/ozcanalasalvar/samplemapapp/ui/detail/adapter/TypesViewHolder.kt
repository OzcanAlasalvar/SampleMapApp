package com.ozcanalasalvar.samplemapapp.ui.detail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ozcanalasalvar.samplemapapp.databinding.ItemTypesLayoutBinding

class TypesViewHolder(var binding: ItemTypesLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(type: String) {
        binding.type = type
        binding.executePendingBindings()
    }
}