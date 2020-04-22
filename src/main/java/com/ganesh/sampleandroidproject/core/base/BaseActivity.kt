package com.ganesh.sampleandroidproject.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ganesh.sampleandroidproject.R
import com.ganesh.sampleandroidproject.core.extension.changeToolbarFont
import com.ganesh.sampleandroidproject.core.extension.inTransaction
import kotlinx.android.synthetic.main.activity_layout.*

/**
 * Base Activity class with helper methods for handling fragment transactions and back button
 * events.
 *
 * @see AppCompatActivity
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        addFragment(savedInstanceState)
        supportActionBar?.hide()
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun addFragment(savedInstanceState: Bundle?) =
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(R.id.fragmentContainer, fragment())
        }

    abstract fun fragment(): BaseFragment
}
