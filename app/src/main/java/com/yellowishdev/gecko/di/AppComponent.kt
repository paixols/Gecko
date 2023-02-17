package com.yellowishdev.gecko.di

import android.content.Context
import com.yellowishdev.gecko.di.coingecko.CoingeckoComponent
import com.yellowishdev.gecko.di.network.NetworkServiceModule
import com.yellowishdev.gecko.di.viewmodel.ViewModelBuilderModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        FeatureSubcomponentModule::class,
        NetworkServiceModule::class,
        ViewModelBuilderModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    /*Components*/
    fun createCoingeckoComponent(): CoingeckoComponent.Factory

}