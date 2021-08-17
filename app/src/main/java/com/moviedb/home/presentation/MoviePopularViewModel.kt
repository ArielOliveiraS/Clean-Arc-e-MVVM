package com.moviedb.home.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import com.moviedb.home.data.models.MovieResponse
import com.moviedb.home.domain.model.MovieListResult
import com.moviedb.home.domain.usecases.MoviePopularUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*


internal class MoviePopularViewModel(private val moviePopularUseCase: MoviePopularUseCase) :
    ViewModel() {

    val movieResult: MutableLiveData<MovieListResult> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()

    fun getPopularMovies() {
        moviePopularUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    movieResult.value = it
                    Log.i("teste", "viewmodel lista : $it")
                },
                {
                        e ->
                    error.value = e.message
                    Log.i("teste", "viewmodel lista : ${e.message}")
                }
            )
    }
}