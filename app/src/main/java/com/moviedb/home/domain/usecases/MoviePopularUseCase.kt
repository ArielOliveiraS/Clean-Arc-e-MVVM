package com.moviedb.home.domain.usecases

import com.moviedb.home.data.models.MovieResponse
import com.moviedb.home.domain.model.MovieItemResult
import com.moviedb.home.domain.repository.MoviePopularRepository
import io.reactivex.Single
import kotlinx.coroutines.*

const val API_KEY = "1efd8cd26867ff738891e74665d8c9b9"

internal class MoviePopularUseCase(private val repository: MoviePopularRepository) {

    operator fun invoke(): Single<MovieResponse> {
        return repository.getPopularMovies(API_KEY)
    }

//    suspend operator fun invoke (): MovieResponse {
//        return withContext(Dispatchers.IO) {
//            repository.getPopularMovies(API_KEY)
//        }
//    }
}










































//
//    suspend operator fun invoke (apiKey: String): Deferred<MovieResponse>  {
//        val deferredResult = CoroutineScope(Dispatchers.Main).async {
//            repository.getPopularMovies(apiKey)
//        }
//       return deferredResult.await()
//    }

//    suspend fun getMovies(apiKey: String): MovieResponse {
//        return withContext(Dispatchers.IO) {
//            repository.getPopularMovies(apiKey)
//        }
//    }