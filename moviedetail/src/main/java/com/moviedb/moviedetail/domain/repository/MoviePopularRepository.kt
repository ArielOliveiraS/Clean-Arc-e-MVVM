package com.moviedb.moviedetail.domain.repository

import com.moviedb.moviedetail.data.models.MovieItem
import kotlinx.coroutines.flow.Flow

internal interface MovieDetailRepository {

    suspend fun getMovieDetails(movieId: Int, apiKey: String): Flow<MovieItem>
}