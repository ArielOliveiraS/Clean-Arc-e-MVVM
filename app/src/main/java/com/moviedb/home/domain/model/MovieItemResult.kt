package com.moviedb.home.domain.model

data class MovieItemResult(
    val budget: Int? = 0,
    val id: Int,
    val overview: String,
    val genre_id: List<Int>? = listOf(),
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val revenue: Long,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val rating: Double
)