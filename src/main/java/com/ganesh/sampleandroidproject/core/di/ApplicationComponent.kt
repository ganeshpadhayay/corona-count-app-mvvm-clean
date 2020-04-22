package com.ganesh.sampleandroidproject.core.di

import com.ganesh.sampleandroidproject.AndroidApplication
import com.ganesh.sampleandroidproject.core.di.viewmodel.ViewModelModule
import com.ganesh.sampleandroidproject.core.navigation.RouteActivity
import com.ganesh.sampleandroidproject.features.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)

    fun inject(routeActivity: RouteActivity)

    fun inject(homeFragment: HomeFragment)
}
