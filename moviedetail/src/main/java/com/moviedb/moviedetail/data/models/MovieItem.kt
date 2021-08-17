package com.moviedb.moviedetail.data.models

import com.google.gson.annotations.SerializedName

internal data class MovieItem(
    val budget: Int,
    val id: Int,
    val overview: String,
    val genre_id: List<Int>,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Long,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val rating: Double
)
