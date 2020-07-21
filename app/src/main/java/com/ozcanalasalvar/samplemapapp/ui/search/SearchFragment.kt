package com.ozcanalasalvar.samplemapapp.ui.search

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.ozcanalasalvar.core.network.model.Result
import com.ozcanalasalvar.samplemapapp.base.BaseFragment
import com.ozcanalasalvar.samplemapapp.App
import com.ozcanalasalvar.samplemapapp.DataHolder
import com.ozcanalasalvar.samplemapapp.R
import com.ozcanalasalvar.samplemapapp.ViewModelProviderFactory
import com.ozcanalasalvar.samplemapapp.databinding.FragmentSearchBinding
import com.ozcanalasalvar.samplemapapp.ui.search.adapter.SearchRecyclerAdapter
import javax.inject.Inject

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>(), SearchNavigator {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val adapter = SearchRecyclerAdapter(arrayListOf(), this)


    override val mViewModel: SearchViewModel
        get() = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)

    override fun getLayoutResId(): Int = R.layout.fragment_search

    override fun init() {
        App.INSTANCE.getAppComponent().inject(this)
        initBinding()
        observeLiveData()
    }

    private fun observeLiveData() {
        mViewModel.data.observe(this, Observer { data ->
            data.results?.let {
                adapter.notifyDataChanges(it)
            }
        })

    }

    private fun initBinding() {
        binding.adapter = adapter
        binding.navigator = this
        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String?): Boolean {
                query?.let {
                    mViewModel.findPlaces(it)
                }
                return true
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }
        })

        binding.executePendingBindings()
    }

    override fun onPlaceClicked(result: Result) {
        DataHolder.setData(result)
        navigateToMap()
    }

    override fun onCancelClick() {
        navigateToMap()
    }

    private fun navigateToMap() {
        Navigation.findNavController(this.requireView())
            .navigate(SearchFragmentDirections.actionSearchFragmentToMapsFragment())
    }

}