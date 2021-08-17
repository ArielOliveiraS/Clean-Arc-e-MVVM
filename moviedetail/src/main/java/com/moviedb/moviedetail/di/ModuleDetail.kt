package com.moviedb.moviedetail.di

import com.moviedb.moviedetail.data.api.MovieApi
import com.moviedb.moviedetail.data.source.MovieRemoteDataSourceImpl
import com.moviedb.moviedetail.data.repository.MovieDetailRepositoryImpl
import com.moviedb.moviedetail.data.source.MovieDetailRemoteDataSource
import com.moviedb.moviedetail.domain.repository.MovieDetailRepository
import com.moviedb.moviedetail.domain.usecases.MovieDetailUseCase
import com.moviedb.moviedetail.presentation.MovieDetailViewModel
import com.utils.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ModuleDetail : FeatureModule() {
    override val dataModule = module {
        factory { get<HttpClient>().create(service = MovieApi::class.java) }
        factory<MovieDetailRemoteDataSource> { MovieRemoteDataSourceImpl() }
        factory<MovieDetailRepository> { MovieDetailRepositoryImpl(remote = get()) }
    }

    override val domainModule = module {
        factory { MovieDetailUseCase(repository = get()) }
    }

   override val presentationModule = module {
       viewModel { MovieDetailViewModel(moviePopularUseCase = get()) }
   }

}