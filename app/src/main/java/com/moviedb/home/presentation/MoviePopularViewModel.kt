package com.moviedb.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moviedb.home.data.models.MovieResponse
import com.moviedb.home.domain.model.MovieItemResult
import com.moviedb.home.domain.usecases.MoviePopularUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

const val API_KEY = "1efd8cd26867ff738891e74665d8c9b9"

class MoviePopularViewModel(private val moviePopularUseCase: MoviePopularUseCase) : ViewModel() {


    val movieResult: MutableLiveData<MovieResponse> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()

    fun getPopularMovies() {
        moviePopularUseCase(API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            movieResult.value = it
                        },
                        { e -> error.value = e.message }
                )
    }

}