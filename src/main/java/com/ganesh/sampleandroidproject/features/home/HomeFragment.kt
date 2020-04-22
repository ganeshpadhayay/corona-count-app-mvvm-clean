package com.ganesh.sampleandroidproject.features.home

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ganesh.sampleandroidproject.R
import com.ganesh.sampleandroidproject.core.base.BaseFragment
import com.ganesh.sampleandroidproject.core.beans.Corona
import com.ganesh.sampleandroidproject.core.beans.india.CoronaIndia
import com.ganesh.sampleandroidproject.core.beans.network.NetworkResource
import com.ganesh.sampleandroidproject.core.extension.failure
import com.ganesh.sampleandroidproject.core.extension.observe
import com.ganesh.sampleandroidproject.core.extension.viewModel
import com.ganesh.sampleandroidproject.core.navigation.Navigator
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_fragment.view.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var navigator: Navigator

    lateinit var tf: Typeface

    private lateinit var homeViewModel: HomeViewModel

    override fun layoutId(): Int {
        return R.layout.home_fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        homeViewModel = viewModel(viewModelFactory) {
            observe(coronaData, ::renderCoronaData)
            failure(failure, ::handleFailure)
        }

        homeViewModel.coronaIndiaData.observeForever {
            renderCoronaIndiaData(it as CoronaIndia)
        }

        tf = Typeface.createFromAsset(context?.assets, "font/montserrat_black.otf")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.lytMainContainer1?.visibility = View.GONE
        view.tvWorldCoronaCount?.visibility = View.GONE
        view.lytMainContainer2?.visibility = View.GONE
        view.tvIndiaCoronaCount?.visibility = View.GONE
        showProgress()
        loadData()
        view.swipeToRefresh?.setOnRefreshListener {
            loadData()
        }
    }

    private fun loadData() {
        homeViewModel.loadCoronaData()
        homeViewModel.loadCoronaIndiaData()
    }

    private fun renderCoronaData(corona: Corona?) {
        hideProgress()
        swipeToRefresh.isRefreshing = false
        lytMainContainer1?.visibility = View.VISIBLE
        tvWorldCoronaCount?.visibility = View.VISIBLE
        tvWorldCoronaCount?.typeface = tf

        tvTotalActiveCases1?.text = corona?.cases
        tvTotalActiveCases1?.typeface = tf
        tvTotalRecoveredCases1?.text = corona?.recovered
        tvTotalRecoveredCases1?.typeface = tf
        tvTotalDeceasedCases1?.text = corona?.deaths
        tvTotalDeceasedCases1?.typeface = tf

        tvActiveCasesToday1?.text = "(+" + corona?.todayCases + ")"
        tvActiveCasesToday1?.typeface = tf
        tvDeceasedCasesToday1?.text = "(+" + corona?.todayDeaths + ")"
        tvDeceasedCasesToday1?.typeface = tf
    }

    private fun renderCoronaIndiaData(coronaIndia: CoronaIndia?) {
        hideProgress()
        swipeToRefresh.isRefreshing = false
        lytMainContainer2?.visibility = View.VISIBLE
        tvIndiaCoronaCount?.visibility = View.VISIBLE
        tvIndiaCoronaCount?.typeface = tf

        tvTotalActiveCases2?.text = coronaIndia?.statewise?.get(0)?.confirmed
        tvTotalActiveCases2?.typeface = tf
        tvTotalRecoveredCases2?.text = coronaIndia?.statewise?.get(0)?.recovered
        tvTotalRecoveredCases2?.typeface = tf
        tvTotalDeceasedCases2?.text = coronaIndia?.statewise?.get(0)?.deaths
        tvTotalDeceasedCases2?.typeface = tf

        val index: Int? = coronaIndia?.casesTimeSeries?.size
        tvActiveCasesToday2?.text =
            "(+" + index?.let { coronaIndia.casesTimeSeries?.get(it - 1)?.dailyconfirmed } + ")"
        tvActiveCasesToday2?.typeface = tf
        tvRecoveredCasesToday2?.text =
            "(+" + index?.let { coronaIndia.casesTimeSeries?.get(it - 1)?.dailyrecovered } + ")"
        tvRecoveredCasesToday2?.typeface = tf
        tvDeceasedCasesToday2?.text =
            "(+" + index?.let { coronaIndia.casesTimeSeries?.get(it - 1)?.dailydeceased } + ")"
        tvDeceasedCasesToday2?.typeface = tf
    }

    private fun handleFailure(networkResource: NetworkResource?) {
        context?.let {
            hideProgress()
            swipeToRefresh.isRefreshing = false
            Toast.makeText(context, networkResource?.error.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}