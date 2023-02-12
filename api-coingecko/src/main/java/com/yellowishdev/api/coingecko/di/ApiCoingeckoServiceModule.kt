package com.yellowishdev.api.coingecko.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object ApiCoingeckoServiceModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @JvmStatic
    @Singleton
    @Provides
    fun providesOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(interceptor).build()

    @JvmStatic
    @Singleton
    @Provides
    fun providesGsonConverter(): GsonConverterFactory =
        GsonConverterFactory.create()

    @JvmStatic
    @Singleton
    @Provides
    fun providesRetrofit(
        httpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .client(httpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
}