package com.moviedb.home.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moviedb.home.domain.model.MovieListResult
import com.moviedb.home.domain.usecases.MoviePopularUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

internal class MoviePopularViewModel(private val moviePopularUseCase: MoviePopularUseCase) :
    ViewModel() {

    val movieResult: MutableLiveData<MovieListResult> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()
    private val disposable = CompositeDisposable()


    fun getPopularMovies() {
        disposable.add(
            moviePopularUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        movieResult.value = it
                    },
                    {
                        error.value = it.message
                    }
                )
        )
    }
}