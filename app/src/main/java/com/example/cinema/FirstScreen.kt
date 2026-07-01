package com.example.cinema

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
@Composable
fun FirstScreen(onNavigateToSecondScreen: () -> Unit) {
    var numText by remember { mutableStateOf("") }
    var isList by remember { mutableStateOf(false) }
    var userInput = numText.toIntOrNull()
    val isNum = userInput != null && userInput > 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = numText,
            onValueChange = {
                numText = it
                isList = false
            },
            label = { Text("Введите количество фильмов: ", fontSize = 20.sp, color = Color.Gray) },
            textStyle = TextStyle(fontSize = 32.sp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (userInput != null){
                    val randomFilms = DataRepository.mockFilms.shuffled().take(userInput)
                    DataRepository.filmsList = randomFilms
                    isList = true
                }
            },
            enabled = isNum,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сгенерировать", fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { onNavigateToSecondScreen() },
            enabled = isList,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Открыть каталог", fontSize = 24.sp)
        }
    }
}