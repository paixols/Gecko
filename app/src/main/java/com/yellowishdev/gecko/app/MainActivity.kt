package com.yellowishdev.gecko.app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.yellowishdev.gecko.app.ui.CoinList
import com.yellowishdev.gecko.app.viewModels.CoinsInformationViewModel
import com.yellowishdev.gecko.data.model.Coin
import com.yellowishdev.gecko.ui.theme.GeckoTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<CoinsInformationViewModel> { viewModelFactory }
    private val coinList = mutableStateOf(emptyList<Coin>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDependencyInjection()
        setupUserInterface()
        setupViewModelListeners()
    }

    private fun setupViewModelListeners() {
        viewModel.coinList().observe(this) {
            coinList.value = it
        }
        viewModel.error().observe(this) {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun setupUserInterface() {
        setContent {
            GeckoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CoinList(coins = coinList.value)
                }
            }
        }
    }

    private fun initDependencyInjection() {
        (application as ProjectGeckoApp)
            .appComponent
            .createCoingeckoComponent()
            .create()
            .inject(activity = this)
    }

}
