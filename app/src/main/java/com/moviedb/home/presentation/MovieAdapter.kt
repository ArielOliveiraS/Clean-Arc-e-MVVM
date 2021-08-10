package com.moviedb.home.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moviedb.R
import com.moviedb.home.data.POSTER_BASE_URL
import com.moviedb.home.data.models.MovieItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*

internal class MovieAdapter(var list: MutableList<MovieItem>):
        RecyclerView.Adapter<MovieAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val characters = list[position]
        holder.onBind(characters)
    }

    fun updateList(newList: MutableList<MovieItem>) {
        this.list.removeAll(list)
        if (newList != null) {
            this.list = newList
        }
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(moviePopular: MovieItem) {
            itemView.movieName.text = moviePopular.title
            Picasso.get().load(POSTER_BASE_URL + moviePopular.posterPath).into(itemView.movieImageView)
        }
    }
}