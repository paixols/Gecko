package com.yellowishdev.gecko.di.coingecko

import com.yellowishdev.gecko.app.main.MainActivity
import dagger.Subcomponent

@Subcomponent(
    modules = [
        CoingeckoModule::class
    ]
)
interface CoingeckoComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CoingeckoComponent
    }

    fun inject(activity: MainActivity)
}