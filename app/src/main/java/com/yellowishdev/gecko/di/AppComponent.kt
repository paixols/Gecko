package com.yellowishdev.gecko.di

import android.content.Context
import com.yellowishdev.api.coingecko.di.ApiCoingeckoServiceModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiCoingeckoServiceModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }


}