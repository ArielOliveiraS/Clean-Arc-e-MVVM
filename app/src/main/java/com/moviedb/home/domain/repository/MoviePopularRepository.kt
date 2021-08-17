package com.moviedb.home.domain.repository

import com.moviedb.home.data.models.MovieResponse
import io.reactivex.Single

internal interface MoviePopularRepository {
    fun getPopularMovies(apiKey: String): Single<MovieResponse>
}