package com.moviedb.moviedetail.domain.mapper

//import com.moviedb.moviedetail.data.models.MovieItem
//import com.moviedb.home.domain.model.MovieItemResult
//import com.utils.Mapper
//
//class MoviePopularMapper : Mapper<List<MovieItem>, List<MovieItemResult>> {
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
//                    rating = source[index].rating
//                )
//            )
//        }
//        return movieList.toList()
//    }
//}