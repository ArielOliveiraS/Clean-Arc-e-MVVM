package com.moviedb.home.data.source

import com.moviedb.home.data.models.MovieResponse
import io.reactivex.Single
import kotlinx.coroutines.Deferred

internal interface MovieRemoteDataSource {
    fun getPopularMovies(apiKey: String): Single<MovieResponse>
}