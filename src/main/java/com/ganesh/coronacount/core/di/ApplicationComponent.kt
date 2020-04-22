package com.ganesh.coronacount.core.di

import com.ganesh.coronacount.AndroidApplication
import com.ganesh.coronacount.core.di.viewmodel.ViewModelModule
import com.ganesh.coronacount.core.navigation.RouteActivity
import com.ganesh.coronacount.features.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)

    fun inject(routeActivity: RouteActivity)

    fun inject(homeFragment: HomeFragment)
}
