package com.moviedb.moviedetail.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.moviedb.moviedetail.R
import com.moviedb.moviedetail.data.POSTER_BASE_URL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: MovieDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        
        val movieId: Int = intent.getIntExtra("movie_id", -1)

        if (movieId != null) {
            viewModel.getPopularMovies(movieId)
            viewModel.movieResult.observe(this, Observer { movie ->
                Picasso.get().load(POSTER_BASE_URL + movie.posterPath).into(posterMovie)
                movieTitle.text = movie.title
                txtViewOverview.text = movie.title
                movieSynopsis.text = movie.overview

            })
        }
    }
}

