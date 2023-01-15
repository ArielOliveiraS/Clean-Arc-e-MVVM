package com.moviedb.moviedetail.data.datasource

import com.moviedb.moviedetail.data.RetrofitService
import com.moviedb.moviedetail.data.models.MovieItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MovieRemoteDataSourceImpl() : MovieDetailRemoteDataSource {

    override suspend fun getMovieDetails(movieId: Int, apiKey: String): Flow<MovieItem> = flow {
        RetrofitService.service.getMoviesDetails(movieId, apiKey)
    }
}