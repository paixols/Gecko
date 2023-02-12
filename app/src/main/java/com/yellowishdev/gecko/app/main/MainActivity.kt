package com.yellowishdev.gecko.app.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.yellowishdev.gecko.app.ProjectGeckoApp
import com.yellowishdev.gecko.app.viewModels.CoinsInformationViewModel
import com.yellowishdev.gecko.ui.theme.GeckoTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<CoinsInformationViewModel> { viewModelFactory }

    private val greeting = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDependencyInjection()

        setContent {
            GeckoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (greeting.value.isNotEmpty()) {
                        Greeting(name = greeting.value)
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.serverPing().observe(this) {
            greeting.value = it
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

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GeckoTheme {
        Greeting("Android")
    }
}