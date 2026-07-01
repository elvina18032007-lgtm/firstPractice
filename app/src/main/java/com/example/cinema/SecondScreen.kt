package com.example.cinema

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun SecondScreen() {
    val originalList = DataRepository.filmsList
    var search by remember { mutableStateOf("") }
    var displayedList by remember { mutableStateOf(originalList) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = search,
                onValueChange = { search = it },
                label = {Text("Год выпуска", fontSize = 20.sp)},
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    if (search.isBlank()) {
                        displayedList = originalList
                    } else {
                        val year = search.toIntOrNull()
                        if (year!= null) displayedList = originalList.filter { it.releaseDate <= year }
                    }
                }
            ) {
                Text("Сортировать", fontSize = 20.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (displayedList.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Ничего не найдено", fontSize = 32.sp)
            }
        } else {
            LazyColumn {
                items(displayedList) { film ->
                    FilmItem(film)
                }
            }
        }
    }
}

@Composable
fun FilmItem(film: FilmModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = film.poster,
            contentDescription = film.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .padding(4.dp)
        )
        Text(
            text = film.name,
            fontSize = 32.sp
        )
    }
}