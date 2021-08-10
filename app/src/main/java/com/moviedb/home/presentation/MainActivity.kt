package com.moviedb.home.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.moviedb.R
import com.moviedb.home.data.models.MovieItem
import com.moviedb.home.di.Module.Companion.dataModule
import com.moviedb.home.di.Module.Companion.domainModule
import com.moviedb.home.di.Module.Companion.presentationModule
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    private val list = mutableListOf<MovieItem>()
    private var genreList = mutableListOf("Ação", "Comédia", "Aventura", "Romance", "Terror", "Animação", "Documentário")
    private val adapter = MovieAdapter(list)
    private val genreAdapter = GenreAdapter(genreList)
    private val layoutManager = LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL, false)
    private val layoutManager2 = LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL, false)

    private val viewModel: MoviePopularViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidContext(this@MainActivity)
            modules(listOf(dataModule, domainModule, presentationModule ))
        }


        movieRecyclerView.adapter = adapter
        movieRecyclerView.layoutManager = layoutManager

        genreRecyclerView.adapter = genreAdapter
        genreRecyclerView.layoutManager = layoutManager2

        viewModel.getPopularMovies()

        viewModel.movieResult.observe(this, Observer {
            adapter.updateList(it.results)
        })
    }
}

