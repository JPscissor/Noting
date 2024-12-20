package ru.jpscissor.noting.screens

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.jpscissor.noting.navigation.NavRoute
import ru.jpscissor.noting.ui.theme.NotingTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height


@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(route = NavRoute.Add.route) }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Icon",
                    tint = MaterialTheme.colors.onSecondary
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Your Notes",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )

            NoteItem("Note 1", "text text text", navController)
            NoteItem("Note 1", "text text text", navController)
            NoteItem("Note 1", "text text text", navController)
        }
    }
}


@Composable
fun NoteItem(title: String, subtitle: String, navController: NavHostController){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .clickable { navController.navigate(NavRoute.Note.route) },
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.body2
                )
            }
        }
}


@Preview(showBackground = true)
@Composable
fun PrevMainScreen() {
    NotingTheme {
        MainScreen(navController = rememberNavController())
    }
}