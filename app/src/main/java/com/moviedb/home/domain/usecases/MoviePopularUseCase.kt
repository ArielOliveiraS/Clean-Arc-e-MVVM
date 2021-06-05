package com.moviedb.home.domain.usecases

import com.moviedb.home.data.models.MovieResponse
import com.moviedb.home.domain.model.MovieItemResult
import com.moviedb.home.domain.repository.MoviePopularRepository
import io.reactivex.Single

class MoviePopularUseCase(
    private val repository: MoviePopularRepository
) {

    operator fun invoke(apiKey: String): Single<MovieResponse> {
        return repository.getPopularMovies(apiKey)
//            .map {
//                mapper.map(it.results)
//            }
        // .map(mapper::map)

    }
}