package com.moviedb.moviedetail.data.datasource

import com.moviedb.moviedetail.data.RetrofitService
import com.moviedb.moviedetail.data.models.MovieItem

internal class MovieRemoteDataSourceImpl() : MovieDetailRemoteDataSource {

    override suspend fun getMovieDetails(movieId: Int, apiKey: String): MovieItem =
        RetrofitService.service.getMoviesDetails(movieId, apiKey)
}