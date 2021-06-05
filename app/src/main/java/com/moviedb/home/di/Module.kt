package com.moviedb.home.di

import com.moviedb.home.data.api.MovieApi
import com.moviedb.home.data.repository.MoviePopularRepositoryImpl
import com.moviedb.home.data.source.MovieRemoteDataSource
import com.moviedb.home.data.source.MovieRemoteDataSourceImpl
import com.moviedb.home.domain.repository.MoviePopularRepository
import com.moviedb.home.domain.usecases.MoviePopularUseCase
import com.moviedb.home.presentation.MoviePopularViewModel
import com.moviedb.utils.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class Module {
    companion object {
        val dataModule = module {
            factory { get<HttpClient>().create(service = MovieApi::class.java) }
            factory<MovieRemoteDataSource> { MovieRemoteDataSourceImpl() }
            factory<MoviePopularRepository> { MoviePopularRepositoryImpl(remote = get()) }
        }

        val domainModule = module {
            factory { MoviePopularUseCase(repository = get())}
        }

        val presentationModule = module { viewModel { MoviePopularViewModel(moviePopularUseCase = get()) } }
    }
}