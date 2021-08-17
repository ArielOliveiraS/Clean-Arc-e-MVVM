package com.moviedb.home.domain.mapper

import com.moviedb.home.data.models.MovieItem
import com.moviedb.home.data.models.MovieResponse
import com.moviedb.home.domain.model.MovieItemResult
import com.moviedb.home.domain.model.MovieListResult
import com.moviedb.utils.Mapper
import io.reactivex.Single



internal fun MovieResponse.toMovieListResult(): MovieListResult {
    return MovieListResult(
        page,
        results,
        total_results,
        total_pages
    )
}

internal fun MutableList<MovieItem>.toMovieItemResult(): MutableList<MovieItemResult> {
    val movieList = arrayListOf<MovieItemResult>()

    for (index in this.indices) {
        movieList.add(
            MovieItemResult(
                budget = this[index].budget,
                id = this[index].id,
                overview = this[index].overview,
                popularity = this[index].popularity,
                posterPath = this[index].posterPath,
                releaseDate = this[index].releaseDate,
                revenue = this[index].revenue,
                runtime = this[index].runtime,
                status = this[index].status,
                tagline = this[index].tagline,
                title = this[index].title,
                video = this[index].video,
                rating = this[index].rating,
                genre_id = this[index].genre_id
            )
        )
    }
    return movieList
}













//
//internal class MoviePopularMapper : Mapper<MovieResponse, MovieListResult> {
//
//    override fun map(source: MovieResponse): MovieListResult {
//        return MovieListResult(
//            page = source.page,
//            results = source.results.toMovieItemResult(),
//            total_results = source.total_results,
//            total_pages = source.total_pages
//        )
//    }
//}
//
//internal class MovieItemMapper : Mapper<List<MovieItemResult>, List<MovieItemResult>> {
//
//    override fun map(source: List<MovieItemResult>): List<MovieItemResult> {
//        val movieList = arrayListOf<MovieItemResult>()
//
//        for (index in source.indices) {
//            movieList.add(
//                MovieItemResult(
//                    budget = source[index].budget,
//                    id = source[index].id,
//                    overview = source[index].overview,
//                    popularity = source[index].popularity,
//                    posterPath = source[index].posterPath,
//                    releaseDate = source[index].releaseDate,
//                    revenue = source[index].revenue,
//                    runtime = source[index].runtime,
//                    status = source[index].status,
//                    tagline = source[index].tagline,
//                    title = source[index].title,
//                    video = source[index].video,
//                    rating = source[index].rating,
//                    genre_id = source[index].genre_id
//                )
//            )
//        }
//        return movieList.toList()
//    }
//}
//
//internal class MoviePopularMapperr : Mapper<List<MovieItem>, List<MovieItemResult>> {
//
//    override fun map(source: List<MovieItem>): List<MovieItemResult> {
//        val movieList = arrayListOf<MovieItemResult>()
//
//        for (index in source.indices) {
//            movieList.add(
//                MovieItemResult(
//                    budget = source[index].budget,
//                    id = source[index].id,
//                    overview = source[index].overview,
//                    popularity = source[index].popularity,
//                    posterPath = source[index].posterPath,
//                    releaseDate = source[index].releaseDate,
//                    revenue = source[index].revenue,
//                    runtime = source[index].runtime,
//                    status = source[index].status,
//                    tagline = source[index].tagline,
//                    title = source[index].title,
//                    video = source[index].video,
//                    rating = source[index].rating,
//                    genre_id = source[index].genre_id
//                )
//            )
//        }
//        return movieList.toList()
//    }
//}