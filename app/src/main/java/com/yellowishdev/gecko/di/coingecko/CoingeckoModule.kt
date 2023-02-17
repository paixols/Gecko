package com.yellowishdev.gecko.di.coingecko

import androidx.lifecycle.ViewModel
import com.yellowishdev.gecko.app.viewModels.CoinsInformationViewModel
import com.yellowishdev.gecko.data.mappers.CoingeckoMapperInterface
import com.yellowishdev.gecko.data.mappers.CoingeckoMapper
import com.yellowishdev.gecko.data.repositories.CoinsRepository
import com.yellowishdev.gecko.data.repositories.CoinsRepositoryInterface
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

    /*
    * Data Sources
    * */

    @Binds
    abstract fun provideCoinsDataSource(
        coinsDataSource: CoinsDataSource
    ): CoinsDataSourceInterface

    /*
    * Repositories
    * */

    @Binds
    abstract fun provideCoinsRepository(
        coinsRepository: CoinsRepository
    ): CoinsRepositoryInterface

    /*
    * Mappers
    * */

    @Binds
    abstract fun provideCoingeckoMapper(
        coingeckoMapper: CoingeckoMapper
    ): CoingeckoMapperInterface

    /*
    * View Models
    * */

    @Binds
    @IntoMap
    @ViewModelKey(CoinsInformationViewModel::class)
    abstract fun bindViewModel(viewModel: CoinsInformationViewModel): ViewModel
}