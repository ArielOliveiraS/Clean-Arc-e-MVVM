package com.moviedb.home.domain.usecases

import android.util.Log
import com.moviedb.home.domain.mapper.toMovieListResult
import com.moviedb.home.domain.model.MovieListResult
import com.moviedb.home.domain.repository.MoviePopularRepository
import io.reactivex.Single

const val API_KEY = "1efd8cd26867ff738891e74665d8c9b9"

internal class MoviePopularUseCase(
    private val repository: MoviePopularRepository,
) {
    operator fun invoke(): Single<MovieListResult> {
        return repository.getPopularMovies(API_KEY)
            .map {
                it.toMovieListResult()
            }
    }
}