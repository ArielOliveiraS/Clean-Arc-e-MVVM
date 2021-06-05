package com.moviedb.home.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.moviedb.home.data.models.MovieItem
import com.moviedb.R
import com.moviedb.home.di.Module.Companion.dataModule
import com.moviedb.home.di.Module.Companion.domainModule
import com.moviedb.home.di.Module.Companion.presentationModule
import com.moviedb.home.domain.model.MovieItemResult
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    private val list = mutableListOf<MovieItem>()
    private val adapter = MovieAdapter(list)
    private val layoutManager = LinearLayoutManager( this)

    private val viewModel: MoviePopularViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidContext(this@MainActivity)
            modules(listOf(dataModule, domainModule, presentationModule ))
        }
//         val viewModel = ViewModelProviders.of(this).get(MoviePopularViewModel::class.java)


        movieRecyclerView.adapter = adapter
        movieRecyclerView.layoutManager = layoutManager

        viewModel.getPopularMovies()

        viewModel.movieResult.observe(this, Observer {
            adapter.updateList(it.results)
        })
    }
}

