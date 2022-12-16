package com.example.mvvmexample.ui.view.home.homeadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.R
import com.example.mvvmexample.data.model.Comic

class ComicsAdapter(private val callback: (comic: Comic) -> (Unit)) :
    RecyclerView.Adapter<ComicsViewHolder>() {
    private val comics = mutableListOf<Comic>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ComicsViewHolder(
            layoutInflater.inflate(R.layout.comic_card, parent, false),
            callback
        )
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val currentComic = comics[position]
        holder.render(currentComic)
    }

    override fun getItemCount(): Int = comics.size

    @SuppressLint("NotifyDataSetChanged")
    fun addData(newComics: List<Comic>) {
        comics.addAll(newComics)
        notifyDataSetChanged()
    }
}