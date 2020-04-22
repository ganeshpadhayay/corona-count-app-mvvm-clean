package com.ganesh.coronacount.features.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ganesh.coronacount.R
import com.ganesh.coronacount.core.base.BaseActivity
import com.ganesh.coronacount.core.base.BaseFragment
import com.ganesh.coronacount.core.extension.changeToolbarFont
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

