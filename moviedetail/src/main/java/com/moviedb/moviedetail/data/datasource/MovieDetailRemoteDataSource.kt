package com.moviedb.moviedetail.data.datasource

import com.moviedb.moviedetail.data.models.MovieItem
import kotlinx.coroutines.flow.Flow

internal interface MovieDetailRemoteDataSource {
    suspend fun getMovieDetails(movieId: Int, apiKey: String): Flow<MovieItem>
}