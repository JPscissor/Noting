package ru.jpscissor.noting.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.jpscissor.noting.navigation.NavRoute
import ru.jpscissor.noting.ui.theme.NotingTheme

@Composable
fun AddScreen(navController: NavHostController) {
    var title by remember { mutableStateOf("") }
    var subtitle by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.fillMaxSize().padding(12.dp)

    ) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues),
                verticalArrangement = Arrangement.Top

            ) {
                Card(
                    modifier = Modifier.fillMaxWidth().padding(8.dp)

                ) {
                    Text("Note title:",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(
                            horizontal = 8.dp,
                            vertical = 4.dp
                        )

                    )

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 8.dp),
                        shape = RoundedCornerShape(20.dp),
                        value = title,
                        onValueChange = {title = it},
                        label = { Text("Note title:") }
                    )

                }
                Card(
                    modifier = Modifier.fillMaxWidth().padding(8.dp)

                ) {
                    Text("Subtitle text:",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(
                            horizontal = 8.dp,
                            vertical = 4.dp
                        )

                    )

                    TextField(
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 8.dp),
                        shape = RoundedCornerShape(20.dp),
                        value = subtitle,
                        onValueChange = {subtitle = it},
                        label = { Text("Subtitle text:") }
                    )

                }

                Button(
                    onClick = {navController.navigate(NavRoute.Main.route)},
                    modifier = Modifier.padding(8.dp).align(Alignment.End),
                ) { Text("Add note") }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun PrevAddScreen() {
    NotingTheme {
        AddScreen(navController = rememberNavController())
    }
}