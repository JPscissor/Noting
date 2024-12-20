package ru.jpscissor.noting.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.jpscissor.noting.ui.theme.NotingTheme

@Composable
fun NoteScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize().padding(12.dp)

    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.Top

        ) {
            Text("Title",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(20.dp)
            )

            Text("This is an example of a note. You can use this area to describe your ideas, jot down quick thoughts, or outline plans for your projects.",
                fontSize = 20.sp,

                )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrevNoteScreen() {
    NotingTheme {
        NoteScreen(navController = rememberNavController())
    }
}