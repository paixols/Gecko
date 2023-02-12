package com.yellowishdev.gecko.app

import android.app.Application
import com.yellowishdev.gecko.di.AppComponent
import com.yellowishdev.gecko.di.DaggerAppComponent

class ProjectGeckoApp : Application() {

    val appComponent: AppComponent by lazy {
        initAppComponent()
    }

    private fun initAppComponent(): AppComponent =
        DaggerAppComponent.factory().create(applicationContext)
}