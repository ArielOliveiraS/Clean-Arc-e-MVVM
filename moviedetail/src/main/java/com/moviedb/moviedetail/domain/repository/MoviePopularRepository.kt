package com.moviedb.moviedetail.domain.repository

import com.moviedb.moviedetail.data.models.MovieItem

internal interface MovieDetailRepository {

    suspend fun getMovieDetails(movieId: Int, apiKey: String): MovieItem

}