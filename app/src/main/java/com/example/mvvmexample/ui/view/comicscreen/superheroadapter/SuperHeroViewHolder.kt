package com.example.mvvmexample.ui.view.comicscreen.superheroadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmexample.data.model.SuperHero
import com.example.mvvmexample.databinding.CharacterCardBinding

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = CharacterCardBinding.bind(view)
    fun render(hero: SuperHero) {
        binding.characterName.text = hero.name
        Glide.with(binding.characterImage.context)
            .load(hero.getFormattedURLLandscapeImage())
            .into(binding.characterImage)
    }
}