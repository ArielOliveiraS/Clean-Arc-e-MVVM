package com.moviedb.moviedetail.data.api

import com.moviedb.moviedetail.data.models.MovieItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface MovieApi {

    @GET("movie/{movie_id}")
    suspend fun getMoviesDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): MovieItem
}