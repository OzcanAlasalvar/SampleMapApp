package com.ozcanalasalvar.samplemapapp.ui.detail


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ozcanalasalvar.samplemapapp.base.BaseFragment
import com.ozcanalasalvar.samplemapapp.R
import com.ozcanalasalvar.samplemapapp.databinding.FragmentDetailBinding
import com.ozcanalasalvar.samplemapapp.ui.detail.adapter.DetailTypesAdapter

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    private val adapter = DetailTypesAdapter(arrayListOf())

    override val mViewModel: DetailViewModel
        get() = ViewModelProviders.of(this).get(DetailViewModel::class.java)

    override fun getLayoutResId(): Int = R.layout.fragment_detail
    override fun init() {
        mViewModel.getSharedPlace()
        observePlaceLiveData()
        binding.adapter = adapter
    }

    private fun observePlaceLiveData() {
        mViewModel.sharedPlace.observe(this, Observer { place ->
            place?.let {
                binding.place = it

                it.types?.let { types ->
                    adapter.notifyDataChanges(types)
                }

                binding.executePendingBindings()
            }
        })
    }

}