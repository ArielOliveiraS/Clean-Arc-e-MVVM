package com.moviedb.moviedetail.data.repository

import com.moviedb.moviedetail.data.models.MovieItem
import com.moviedb.moviedetail.data.source.MovieDetailRemoteDataSource
import com.moviedb.moviedetail.data.source.MovieRemoteDataSourceImpl
import com.moviedb.moviedetail.domain.repository.MovieDetailRepository

internal class MovieDetailRepositoryImpl(private val remote: MovieDetailRemoteDataSource): MovieDetailRepository {
   override suspend fun getMovieDetails(movieId: Int, apiKey: String): MovieItem {
        return remote.getMovieDetails(movieId, apiKey)
    }
}