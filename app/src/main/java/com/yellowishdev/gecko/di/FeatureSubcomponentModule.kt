package com.yellowishdev.gecko.di

import com.yellowishdev.gecko.di.coingecko.CoingeckoComponent
import dagger.Module

@Module(
    subcomponents = [
        CoingeckoComponent::class
    ]
)
object FeatureSubcomponentModule