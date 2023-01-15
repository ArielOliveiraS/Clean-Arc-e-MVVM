package com.moviedb.moviedetail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviedb.moviedetail.data.models.MovieItem
import com.moviedb.moviedetail.domain.usecase.MovieDetailUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

internal class MovieDetailViewModel(
    private val moviePopularUseCase: MovieDetailUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    val movieResult: MutableLiveData<MovieItem> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()

    fun getPopularMovies(movieId: Int) {
        viewModelScope.launch {
            moviePopularUseCase(movieId)
                .flowOn(dispatcher)
//                .onStart { showLoading() }
//                .onCompletion { hideLoading() }
                .catch { e -> error.value = e.message }
                .collect { movieItem ->
                    movieResult.value = movieItem
                }
        }
    }
}
