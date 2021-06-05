package com.moviedb.home.domain.model

data class MovieItemResult(
    val budget: Int? = 0,
    val id: Int? = 0,
    val overview: String? = "",
    val popularity: Double? = 0.0,
    val posterPath: String? = "",
    val releaseDate: String? = "",
    val revenue: Long? = 0L,
    val runtime: Int? = 0,
    val status: String? = "",
    val tagline: String? = "",
    val title: String? = "",
    val video: Boolean? = false,
    val rating: Double? = 0.0
)