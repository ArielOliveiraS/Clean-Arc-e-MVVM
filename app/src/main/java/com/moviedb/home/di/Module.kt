package com.moviedb.home.di


import com.moviedb.home.data.api.MovieApi
import com.moviedb.home.data.repository.MoviePopularRepositoryImpl
import com.moviedb.home.data.source.MovieRemoteDataSource
import com.moviedb.home.data.source.MovieRemoteDataSourceImpl
import com.moviedb.home.domain.repository.MoviePopularRepository
import com.moviedb.home.domain.usecases.MoviePopularUseCase
import com.moviedb.home.presentation.MoviePopularViewModel
import com.moviedb.utils.FeatureModule
import com.moviedb.utils.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal class MovieModule : FeatureModule() {
    override val dataModule = module {
        factory { get<HttpClient>().create(service = MovieApi::class.java) }
        factory<MovieRemoteDataSource> { MovieRemoteDataSourceImpl() }
        factory<MoviePopularRepository> { MoviePopularRepositoryImpl(remote = get()) }
        //  single { createServiceApi(url = URL, serviceClass = MovieApi::class.java) }
    }

    override val domainModule = module {
//        factory { MoviePopularMapper() }
//        factory { MovieItemMapper() }
        factory { MoviePopularUseCase(repository = get()) }
    }

    override val presentationModule =
        module { viewModel { MoviePopularViewModel(moviePopularUseCase = get()) } }

}