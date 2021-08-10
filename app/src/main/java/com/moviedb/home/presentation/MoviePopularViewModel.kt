package com.moviedb.home.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moviedb.home.data.models.MovieResponse
import com.moviedb.home.domain.usecases.MoviePopularUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*


class MoviePopularViewModel(private val moviePopularUseCase: MoviePopularUseCase) : ViewModel() {

    val movieResult: MutableLiveData<MovieResponse> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()

    fun getPopularMovies() {
        moviePopularUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { movieResult.value = it },
                { e -> error.value = e.message }
            )
    }

//
//    fun getPopularMovies() {
//        viewModelScope.launch {
//            runCatching {
//                moviePopularUseCase()
//            }.onSuccess {
//                movieResult.value = it
//            }.onFailure { e ->
//                error.value = e.message
//            }
//        }
//    }

}


//    fun getPopularMovies() {
//        viewModelScope.launch {
//
//            val async = async {
//                moviePopularUseCase.getMovies(API_KEY)
//            }
//
//            runCatching {
//                async.await()
//            }.onSuccess {
//                movieResult.value = it
//            }.onFailure { e ->
//                error.value = e.message
//            }
//        }
//    }

//CoroutineScope -> ambiente controlado para executar as coroutines

//launch -> cria um job e a execuçao é imediada... o que dentro do launch já é processado
//assync ->  devevolve um Deferred que é um job que armazena o resultado lá dentro que é executado no await()

//onde precisa do resultado usa o await(), ele executa o que a gente precisa, no caso o getPopularMovies

