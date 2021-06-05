package com.moviedb.utils

interface Mapper<S, T> {
    fun map(source: S): T
}