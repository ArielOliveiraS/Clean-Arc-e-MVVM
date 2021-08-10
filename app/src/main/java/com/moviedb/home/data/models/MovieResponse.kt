package com.moviedb.home.data.models

data class MovieResponse(
    val page: Int,
    val results: MutableList<MovieItem>,
    val total_results: Int,
    val total_pages: Int
)