package com.yellowishdev.gecko.app.main

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.yellowishdev.gecko.R
import com.yellowishdev.gecko.app.ProjectGeckoApp
import com.yellowishdev.gecko.app.viewModels.CoinsInformationViewModel
import com.yellowishdev.gecko.data.model.Coin
import com.yellowishdev.gecko.ui.theme.GeckoTheme
import com.yellowishdev.gecko.utils.DataSet
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<CoinsInformationViewModel> { viewModelFactory }

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
                    // TODO: Load Coin List w/Compose + ViewModel
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

/*
* Compose UI
* */
@Composable
fun CoinCard(coin: Coin) {
    Row(modifier = Modifier.padding(8.dp)) {

        // Icon
        Image(
            painter = painterResource(id = R.drawable.crypto_currency),
            contentDescription = "Currency icon",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Details
        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            targetValue =
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
        )
        Column(
            modifier = Modifier.clickable { isExpanded = !isExpanded }
        ) {
            // Name
            Text(
                text = coin.name,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            // ID + Symbol
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor
            ) {
                Text(
                    text = "Id: ${coin.id}\nSymbol: ${coin.symbol}",
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.body2
                )
            }

        }

    }
}

@Composable
fun CoinList(coins: List<Coin>) {
    LazyColumn {
        items(coins) { coin ->
            CoinCard(coin = coin)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun previewCoinList() {
    GeckoTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CoinList(coins = DataSet.coinListSample)
        }
    }
}
