package com.moviedb.home.data.source

import com.moviedb.home.data.RetrofitService
import com.moviedb.home.data.models.MovieResponse
import io.reactivex.Single

class MovieRemoteDataSourceImpl(): MovieRemoteDataSource {

    override fun getPopularMovies(apiKey: String): Single<MovieResponse> {
        return RetrofitService.service.getPopularMovies(apiKey)
    }

//    override suspend fun getPopularMovies(apiKey: String): MovieResponse{
//        return RetrofitService.service.getPopularMovies(apiKey)
//    }
}





































//    override suspend fun getPopularMovies(apiKey: String): MovieResponse {  // suspend function sao funçoes que podem ter sua execuçao pausada e retomad no futuro
//        return RetrofitService.service.getPopularMovies(apiKey)
//    }