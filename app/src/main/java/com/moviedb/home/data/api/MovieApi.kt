package com.moviedb.home.data.api

import com.moviedb.home.data.models.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Single<MovieResponse>
}