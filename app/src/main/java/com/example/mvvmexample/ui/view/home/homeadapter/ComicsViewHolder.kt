package com.example.mvvmexample.ui.view.home.homeadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmexample.data.model.Comic
import com.example.mvvmexample.databinding.ComicCardBinding

class ComicsViewHolder(view: View, val callback : (comic : Comic)-> (Unit)) : RecyclerView.ViewHolder(view) {
    private val binding = ComicCardBinding.bind(view)

    fun render(comic: Comic) {
        binding.comicTitle.text = comic.title
        Glide.with(binding.comicImage.context)
            .load(comic.getFormattedURLImage())
            .into(binding.comicImage)
        binding.comicCard.setOnClickListener {
        callback(comic)
        }
    }
}