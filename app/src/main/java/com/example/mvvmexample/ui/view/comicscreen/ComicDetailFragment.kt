package com.example.mvvmexample.ui.view.comicscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmexample.databinding.FragmentComicBinding
import com.example.mvvmexample.ui.view.comicscreen.superheroadapter.SuperHeroAdapter
import com.example.mvvmexample.ui.viewmodel.HomeViewModel

class ComicDetailFragment : Fragment() {
    private lateinit var binding: FragmentComicBinding
    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.currentComic.observe(this) {
            binding.comicTitle.text = it.title
            binding.comicDescription.text = it.textObjects.firstOrNull()?.text
            Glide.with(binding.comicCover.context)
                .load(it.getFormattedURLLandscapeImage())
                .into(binding.comicCover)
        }
        homeViewModel.superHeroesLiveData.observe(this) {
            it.let {
                (binding.characterRecycler.adapter as SuperHeroAdapter).addData(it)
                if (it.isNotEmpty())
                    binding.comicCharacters.visibility = View.VISIBLE
            }
        }
    }

    private fun initSuperHeroRecycler() {
        val recycler = binding.characterRecycler
        recycler.adapter = SuperHeroAdapter()
        recycler.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComicBinding.inflate(layoutInflater, container, false)
        initSuperHeroRecycler()
        return binding.root
    }
}