package com.example.mvvmexample.ui.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvvmexample.R
import com.example.mvvmexample.databinding.FragmentComicsBinding
import com.example.mvvmexample.ui.view.home.homeadapter.ComicsAdapter
import com.example.mvvmexample.ui.viewmodel.HomeViewModel

class ComicsFragment : Fragment() {
    private lateinit var binding: FragmentComicsBinding
    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.comicsLiveData.observe(this) { comics ->
            (binding.comicsRecycler.adapter as ComicsAdapter).addData(comics)
        }
    }

    private fun initComicsRecycler() {
        val recycler = binding.comicsRecycler
        recycler.layoutManager = GridLayoutManager(requireContext(), 2)
        recycler.adapter = ComicsAdapter {
            findNavController().navigate(R.id.action_comicsFragment_to_comicFragment)
            homeViewModel.onComicSelected(it)
            homeViewModel.getSuperHeroByComicId(it.id.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComicsBinding.inflate(layoutInflater, container, false)
        initComicsRecycler()
        homeViewModel.onCreateFragment()
        return binding.root
    }
}