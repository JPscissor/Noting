package ru.jpscissor.noting.screens

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.jpscissor.noting.MainViewModel
import ru.jpscissor.noting.MainViewModelFactory
import ru.jpscissor.noting.navigation.NavRoute
import ru.jpscissor.noting.ui.theme.NotingTheme
import ru.jpscissor.noting.utils.TYPE_DATABASE
import ru.jpscissor.noting.utils.TYPE_FIREBASE
import ru.jpscissor.noting.utils.TYPE_ROOM


@Composable
fun StartScreen(navController: NavHostController) {

    val context = LocalContext.current
    val mViewModel : MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "How do you prefer to save your data?",
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(32.dp)
            )

            Button(
                onClick = {
                    mViewModel.initDatabase(TYPE_ROOM)
                    navController.navigate(route = NavRoute.Main.route)
                          },
                colors = ButtonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.Gray
                ),
                modifier = Modifier
                    .width(200.dp)
                    .padding(4.dp)
            ) {
                Text("Locally", fontSize = 24.sp)
            }

            Button(
                onClick = {
                    mViewModel.initDatabase(TYPE_FIREBASE)
                    navController.navigate(route = NavRoute.Main.route)
                          },
                colors = ButtonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.Gray
                ),
                modifier = Modifier
                    .width(200.dp)
                    .padding(4.dp)
            ) {
                Text("Online", fontSize = 24.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevStartScreen() {
        NotingTheme {
            StartScreen(navController = rememberNavController())
    }
}