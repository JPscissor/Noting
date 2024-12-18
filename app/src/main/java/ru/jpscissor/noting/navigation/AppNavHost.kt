package ru.jpscissor.noting.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.jpscissor.noting.screens.Add
import ru.jpscissor.noting.screens.Main
import ru.jpscissor.noting.screens.Note
import ru.jpscissor.noting.screens.Start

sealed class NavRoute (val route: String) {
    object Start: NavRoute("start_screen")
    object Main: NavRoute("main_screen")
    object Add: NavRoute("add_screen")
    object Note: NavRoute("note_screen")
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route){ Start(navController)}
        composable(NavRoute.Main.route){ Main(navController) }
        composable(NavRoute.Add.route){ Add(navController) }
        composable(NavRoute.Note.route){ Note(navController) }
    }

}