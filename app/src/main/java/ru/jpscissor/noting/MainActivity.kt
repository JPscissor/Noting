package ru.jpscissor.noting

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.jpscissor.noting.navigation.AppNavHost
import ru.jpscissor.noting.ui.theme.NotingTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotingTheme {

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Noting App") },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Magenta,
                                scrolledContainerColor = Color.Gray,
                                navigationIconContentColor = Color.White,
                                titleContentColor = Color.Black,
                                actionIconContentColor = Color.White
                            )
                        )
                    },
                    content = { paddingValues ->
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues),
                            color = Color.White
                        ) {
                            AppNavHost()
                        }
                    }
                )


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotingTheme {

    }
}