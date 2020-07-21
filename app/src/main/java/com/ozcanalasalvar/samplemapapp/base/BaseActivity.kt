package com.ozcanalasalvar.samplemapapp.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel>(private val mViewModelClass: Class<VM>) :
    AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutRes(): Int

    val binding by lazy {
        DataBindingUtil.setContentView(this, getLayoutRes()) as DB
    }

    private lateinit var viewModel: VM

    abstract fun getViewModel(): VM

    open fun onInject() {}

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        initViewModel(viewModel)
        super.onCreate(savedInstanceState, persistentState)
        onInject()
    }

    private fun initViewModel(viewModel: VM) {
        this.viewModel = viewModel ?: getViewModel()
    }


//    open fun initBinding() {}
}