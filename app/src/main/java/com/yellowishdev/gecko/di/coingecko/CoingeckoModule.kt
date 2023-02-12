package com.yellowishdev.gecko.di.coingecko

import androidx.lifecycle.ViewModel
import com.yellowishdev.api.coingecko.repositories.CoinsRepositoryInterface
import com.yellowishdev.gecko.app.viewModels.CoinsInformationViewModel
import com.yellowishdev.gecko.data.repositories.CoinsRepository
import com.yellowishdev.gecko.data.source.CoinsDataSource
import com.yellowishdev.gecko.data.source.CoinsDataSourceInterface
import com.yellowishdev.gecko.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        CoinsUseCases::class
    ]
)
abstract class CoingeckoModule {

    @Binds
    abstract fun provideCoinsDataSource(
        coinsDataSource: CoinsDataSource
    ): CoinsDataSourceInterface

    @Binds
    abstract fun provideCoinsRepository(
        coinsRepository: CoinsRepository
    ): CoinsRepositoryInterface

    @Binds
    @IntoMap
    @ViewModelKey(CoinsInformationViewModel::class)
    abstract fun bindViewModel(viewModel: CoinsInformationViewModel): ViewModel
}