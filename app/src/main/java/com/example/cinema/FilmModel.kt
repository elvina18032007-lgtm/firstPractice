package com.example.cinema

class FilmModel(
    val id: String,
    val poster: Int,
    val name: String,
    val description: String? = null,
    val releaseDate: Int
)

object DataRepository {
    var filmsList: List<FilmModel> = emptyList()
    val mockFilms = listOf(
        FilmModel(
            id = "1",
            poster = R.drawable.first,
            name = "Как приручить дракона",
            releaseDate = 2025
        ),
        FilmModel(
            id = "2",
            poster = R.drawable.second,
            name = "Головоломка",
            releaseDate = 2015
        ),
        FilmModel(
            id = "3",
            poster = R.drawable.third,
            name = "Зверополис",
            releaseDate = 2016
        ),
        FilmModel(
            id = "4",
            poster = R.drawable.fourth,
            name = "Шрек",
            releaseDate = 2001
        ),
        FilmModel(
            id = "5",
            poster = R.drawable.fifth,
            name = "Унесенные призраками",
            releaseDate = 2001
        ),
        FilmModel(
            id = "6",
            poster = R.drawable.sixth,
            name = "Король Лев",
            releaseDate = 1994
        ),
        FilmModel(
            id = "7",
            poster = R.drawable.seventh,
            name = "История игрушек ",
            releaseDate = 1995
        ),
        FilmModel(
            id = "8",
            poster = R.drawable.eighth,
            name = "Мой сосед Тоторо",
            releaseDate = 1988
        ),
        FilmModel(
            id = "9",
            poster = R.drawable.ninth,
            name = "В поисках Немо",
            releaseDate = 2003
        ),
        FilmModel(
            id = "10",
            poster = R.drawable.tenth,
            name = "Душа",
            releaseDate = 2020
        )

    )
}