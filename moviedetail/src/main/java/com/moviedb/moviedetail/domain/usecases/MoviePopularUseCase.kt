package com.moviedb.moviedetail.domain.usecases

import com.moviedb.moviedetail.data.models.MovieItem
import com.moviedb.moviedetail.data.repository.MovieDetailRepositoryImpl
import com.moviedb.moviedetail.domain.repository.MovieDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val API_KEY = "1efd8cd26867ff738891e74665d8c9b9"

internal class MovieDetailUseCase(private val repository: MovieDetailRepository) {

    suspend operator fun invoke (movieId: Int): MovieItem {
        return withContext(Dispatchers.IO) {
            repository.getMovieDetails(movieId, API_KEY)
        }
    }
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