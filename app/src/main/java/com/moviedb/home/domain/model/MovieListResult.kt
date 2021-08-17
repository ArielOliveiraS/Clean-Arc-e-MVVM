package com.moviedb.home.domain.model

import com.moviedb.home.data.models.MovieItem

internal data class MovieListResult(
    val page: Int,
    val results: MutableList<MovieItem>,
    val total_results: Int,
    val total_pages: Int,
)