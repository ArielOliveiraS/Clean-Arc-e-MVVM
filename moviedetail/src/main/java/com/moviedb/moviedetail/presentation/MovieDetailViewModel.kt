package com.moviedb.moviedetail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviedb.moviedetail.data.models.MovieItem
import com.moviedb.moviedetail.domain.usecases.MovieDetailUseCase
import kotlinx.coroutines.launch

internal class MovieDetailViewModel(private val moviePopularUseCase: MovieDetailUseCase) : ViewModel() {

    val movieResult: MutableLiveData<MovieItem> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()

    fun getPopularMovies(movieId: Int) {
        viewModelScope.launch {
            runCatching {
                moviePopularUseCase(movieId)
            }.onSuccess {
                movieResult.value = it
            }.onFailure { e ->
                error.value = e.message
            }
        }
    }
}
