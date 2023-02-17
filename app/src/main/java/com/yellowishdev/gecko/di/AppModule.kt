package com.yellowishdev.gecko.di

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun providesResources(context: Context): Resources {
        return context.applicationContext.resources
    }
}