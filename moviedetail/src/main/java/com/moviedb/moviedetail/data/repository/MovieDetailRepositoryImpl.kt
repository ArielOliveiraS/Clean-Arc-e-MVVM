package com.moviedb.moviedetail.data.repository

import com.moviedb.moviedetail.data.models.MovieItem
import com.moviedb.moviedetail.data.datasource.MovieDetailRemoteDataSource
import com.moviedb.moviedetail.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MovieDetailRepositoryImpl(private val remote: MovieDetailRemoteDataSource) :
    MovieDetailRepository {

    override suspend fun getMovieDetails(movieId: Int, apiKey: String): Flow<MovieItem> = flow {
        remote.getMovieDetails(movieId, apiKey)
    }
}