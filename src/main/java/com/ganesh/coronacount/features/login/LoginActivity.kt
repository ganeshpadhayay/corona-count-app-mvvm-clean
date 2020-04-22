package com.ganesh.coronacount.features.login

import android.content.Context
import android.content.Intent
import com.ganesh.coronacount.core.base.BaseActivity
import com.ganesh.coronacount.core.base.BaseFragment

class LoginActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    override fun fragment(): BaseFragment = LoginFragment()
}
