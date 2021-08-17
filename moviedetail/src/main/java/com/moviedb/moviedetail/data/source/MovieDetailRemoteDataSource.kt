package com.moviedb.moviedetail.data.source

import com.moviedb.moviedetail.data.models.MovieItem

internal interface MovieDetailRemoteDataSource {
    suspend fun getMovieDetails(movieId: Int, apiKey: String): MovieItem
}