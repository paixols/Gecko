package com.yellowishdev.gecko.app.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yellowishdev.api.coingecko.model.Request
import com.yellowishdev.gecko.data.useCases.CoingeckoServerPingUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinsInformationViewModel @Inject constructor(
    private val coingeckoServerPing: CoingeckoServerPingUseCase
) : ViewModel() {

    init {
        // Validate active coin information server
        pingServer()
    }

    private var _serverPing = MutableLiveData<String>().apply {
        value = "No Service Available"
    }

    fun serverPing(): LiveData<String> = _serverPing

    private fun pingServer() {
        viewModelScope.launch {
            val result = coingeckoServerPing.invoke(Request.Empty)
            _serverPing.value = result.geckoSays
        }
    }

}