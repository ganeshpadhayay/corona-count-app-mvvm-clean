package com.ganesh.sampleandroidproject.features.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ganesh.sampleandroidproject.R
import com.ganesh.sampleandroidproject.core.base.BaseActivity
import com.ganesh.sampleandroidproject.core.base.BaseFragment
import com.ganesh.sampleandroidproject.core.extension.changeToolbarFont
import kotlinx.android.synthetic.main.activity_layout.*


class HomeActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.title = this.getString(R.string.app_name)
        toolbar.changeToolbarFont()
    }

    override fun fragment(): BaseFragment = HomeFragment()
}

