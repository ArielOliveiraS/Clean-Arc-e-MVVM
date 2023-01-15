package com.moviedb.moviedetail.domain.usecase

import com.moviedb.moviedetail.data.models.MovieItem
import com.moviedb.moviedetail.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow

const val API_KEY = "1efd8cd26867ff738891e74665d8c9b9"

internal class MovieDetailUseCase(private val repository: MovieDetailRepository) {

    suspend operator fun invoke(movieId: Int): Flow<MovieItem> {
        return repository.getMovieDetails(movieId, API_KEY)
    }
}