package com.example.mvvmexample.ui.view.comicscreen.superheroadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.R
import com.example.mvvmexample.data.model.SuperHero

class SuperHeroAdapter : RecyclerView.Adapter<SuperHeroViewHolder>(){
    private var heroes = mutableListOf<SuperHero>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.character_card, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val currentHero = heroes[position]
        holder.render(currentHero)
    }

    override fun getItemCount() = heroes.size

    @SuppressLint("NotifyDataSetChanged")
    fun addData(newHero : List<SuperHero>){
        heroes.addAll(newHero)
        notifyDataSetChanged()
    }
}