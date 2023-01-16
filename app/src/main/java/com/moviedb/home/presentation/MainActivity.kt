package com.moviedb.home.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.moviedb.R
import com.moviedb.home.data.models.MovieItem
import com.moviedb.home.domain.mapper.toMovieItemResult
import com.moviedb.home.domain.model.MovieItemResult
import com.moviedb.home.presentation.adapter.GenreAdapter
import com.moviedb.home.presentation.adapter.MovieAdapter
import com.moviedb.moviedetail.presentation.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MovieListener {

    private val list = mutableListOf<MovieItem>()
    private var genreList = mutableListOf("Ação", "Comédia", "Aventura", "Romance", "Terror", "Animação", "Documentário")
    private val adapter = MovieAdapter(list, this)
    private val genreAdapter = GenreAdapter(genreList)
    private val layoutManager = LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL, false)
    private val layoutManager2 = LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL, false)

    private val viewModel: MoviePopularViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        startKoin {
//            androidContext(this@MainActivity)
//            modules(listOf(dataModule, domainModule, presentationModule ))
//        }


        movieRecyclerView.adapter = adapter
        movieRecyclerView.layoutManager = layoutManager

        genreRecyclerView.adapter = genreAdapter
        genreRecyclerView.layoutManager = layoutManager2

        viewModel.getPopularMovies()

        viewModel.movieResult.observe(this, Observer {
            adapter.updateList(it.results)
        })
    }

    override fun openMovieDetails(movieId: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("movie_id", movieId)
        startActivity(intent)
    }
}

