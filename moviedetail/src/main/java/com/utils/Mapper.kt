package com.utils

interface Mapper<S, T> {
    fun map(source: S): T
}