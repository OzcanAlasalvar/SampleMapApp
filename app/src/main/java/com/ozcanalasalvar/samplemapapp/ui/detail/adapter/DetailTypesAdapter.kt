package com.ozcanalasalvar.samplemapapp.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ozcanalasalvar.samplemapapp.R
import com.ozcanalasalvar.samplemapapp.databinding.ItemTypesLayoutBinding

class DetailTypesAdapter(private val types: ArrayList<String>) :
    RecyclerView.Adapter<TypesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemTypesLayoutBinding>(
            inflater,
            R.layout.item_types_layout,
            parent,
            false
        )

        return TypesViewHolder(binding)
    }

    override fun getItemCount(): Int = types.size

    override fun onBindViewHolder(holder: TypesViewHolder, position: Int) {
        holder.bind(types[position])
    }

    fun notifyDataChanges(list: List<String>) {
        types.clear()
        types.addAll(list)
        notifyDataSetChanged()
    }

}