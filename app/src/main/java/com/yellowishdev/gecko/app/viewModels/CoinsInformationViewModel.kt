package com.yellowishdev.gecko.app.viewModels

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yellowishdev.api.coingecko.dto.Request
import com.yellowishdev.gecko.R
import com.yellowishdev.gecko.data.model.Coin
import com.yellowishdev.gecko.data.model.CoingeckoResponse
import com.yellowishdev.gecko.data.useCases.CoingeckoCoinListUseCase
import com.yellowishdev.gecko.data.useCases.CoingeckoServerPingUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinsInformationViewModel @Inject constructor(
    private val coingeckoServerPing: CoingeckoServerPingUseCase,
    private val coingeckoCoinList: CoingeckoCoinListUseCase,
    private val resources: Resources
) : ViewModel() {

    init {
        // Validate active coin information server
        pingServer()
    }

    private var _serverPing = MutableLiveData<String>().apply {
        value = resources.getString(R.string.server_ping)
    }

    private var _coinList = MutableLiveData<List<Coin>>().apply {
        value = null
    }

    private var _error = MutableLiveData<Exception>().apply {
        value = null
    }

    fun serverPing(): LiveData<String> = _serverPing

    fun coinList(): LiveData<List<Coin>> = _coinList

    fun error(): LiveData<Exception> = _error

    private fun pingServer() {
        viewModelScope.launch {
            when (val result = coingeckoServerPing.invoke(Request.Empty)) {
                is CoingeckoResponse.Ping -> {
                    _serverPing.value = result.message
                }
                is CoingeckoResponse.Error -> {
                    _error.value = result.exception
                }
                else -> {
                    // Left purposely blank
                }
            }
        }
        getCoinList()
    }

    private fun getCoinList() {
        viewModelScope.launch {
            when (val result = coingeckoCoinList.invoke(Request.Empty)) {
                is CoingeckoResponse.Coins -> {
                    _coinList.value = result.coinList
                }
                is CoingeckoResponse.Error -> {
                    _error.value = result.exception
                }
                else -> {
                    // Left purposely blank
                }
            }
        }
    }

}