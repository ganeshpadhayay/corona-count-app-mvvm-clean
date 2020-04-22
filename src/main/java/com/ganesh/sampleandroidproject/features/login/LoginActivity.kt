package com.ganesh.sampleandroidproject.features.login

import android.content.Context
import android.content.Intent
import com.ganesh.sampleandroidproject.core.base.BaseActivity
import com.ganesh.sampleandroidproject.core.base.BaseFragment

class LoginActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    override fun fragment(): BaseFragment = LoginFragment()
}
