package com.ozcanalasalvar.samplemapapp.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.ozcanalasalvar.samplemapapp.R
import com.ozcanalasalvar.samplemapapp.base.BaseActivity
import com.ozcanalasalvar.samplemapapp.base.BaseViewModel
import com.ozcanalasalvar.samplemapapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>(BaseViewModel::class.java) {

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.executePendingBindings()
    }

    override fun getViewModel(): BaseViewModel =
        ViewModelProviders.of(this).get(BaseViewModel::class.java)


}
