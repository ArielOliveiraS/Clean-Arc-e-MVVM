package com.moviedb.home.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moviedb.R
import kotlinx.android.synthetic.main.genre_item.view.*

class GenreAdapter(var list: MutableList<String>):
    RecyclerView.Adapter<GenreAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val genres = list[position]
        holder.onBind(genres)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(genre: String) {
            itemView.genreName.text = genre
        }
    }
}