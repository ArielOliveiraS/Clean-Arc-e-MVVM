package com.moviedb.home.data.source

import com.moviedb.home.data.RetrofitService
import com.moviedb.home.data.api.MovieApi
import com.moviedb.home.data.models.MovieResponse
import io.reactivex.Single

class MovieRemoteDataSourceImpl(): MovieRemoteDataSource {

    override fun getPopularMovies(apiKey: String): Single<MovieResponse> {
        return RetrofitService.service.getPopularMovies(apiKey)
    }
}