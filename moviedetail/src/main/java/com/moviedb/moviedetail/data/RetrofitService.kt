package com.moviedb.moviedetail.data

import com.google.gson.GsonBuilder
import com.moviedb.moviedetail.data.api.MovieApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "1efd8cd26867ff738891e74665d8c9b9"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500/"


internal class RetrofitService {
    companion object {
        val service: MovieApi

        init {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val gson = GsonBuilder().setLenient().create()

            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()

            service = retrofit.create(MovieApi::class.java)
        }
    }
}
