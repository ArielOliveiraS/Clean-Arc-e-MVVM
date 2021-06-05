package com.moviedb.home.data.repository

import com.moviedb.home.data.models.MovieResponse
import com.moviedb.home.data.source.MovieRemoteDataSource
import com.moviedb.home.domain.repository.MoviePopularRepository
import io.reactivex.Single

class MoviePopularRepositoryImpl(private val remote: MovieRemoteDataSource): MoviePopularRepository {

    override fun getPopularMovies(apiKey: String): Single<MovieResponse> {
        return remote.getPopularMovies(apiKey)
    }
}