package com.moviedb.moviedetail.data.source

import com.moviedb.moviedetail.data.RetrofitService
import com.moviedb.moviedetail.data.models.MovieItem
import com.moviedb.moviedetail.domain.repository.MovieDetailRepository


internal class MovieRemoteDataSourceImpl() :MovieDetailRemoteDataSource {

    override suspend fun getMovieDetails(movieId: Int, apiKey: String): MovieItem {
        return RetrofitService.service.getMoviesDetails(movieId, apiKey)
    }
}