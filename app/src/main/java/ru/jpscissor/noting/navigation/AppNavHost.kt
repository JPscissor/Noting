package ru.jpscissor.noting.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.jpscissor.noting.screens.AddScreen
import ru.jpscissor.noting.screens.MainScreen
import ru.jpscissor.noting.screens.NoteScreen
import ru.jpscissor.noting.screens.StartScreen

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
        composable(NavRoute.Start.route){ StartScreen(navController)}
        composable(NavRoute.Main.route){ MainScreen(navController) }
        composable(NavRoute.Add.route){ AddScreen(navController) }
        composable(NavRoute.Note.route){ NoteScreen(navController) }
    }

}