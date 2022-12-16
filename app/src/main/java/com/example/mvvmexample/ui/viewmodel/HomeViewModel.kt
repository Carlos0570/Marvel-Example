package com.example.mvvmexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.data.model.Comic
import com.example.mvvmexample.data.model.SuperHero
import com.example.mvvmexample.domain.GetSuperHeroesUseCase
import com.example.mvvmexample.domain.GetComicsUseCase
import com.example.mvvmexample.domain.GetSuperHeroByComicIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase,
    private val getComicsUseCase: GetComicsUseCase,
    private val getSuperHeroesByComicId : GetSuperHeroByComicIdUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val comicsLiveData = MutableLiveData<List<Comic>>()
    private var isLoading = MutableLiveData<Boolean>()
    val currentComic = MutableLiveData<Comic>()
    val superHeroesLiveData = MutableLiveData<List<SuperHero>>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.value = true
            val comics = getComicsUseCase()
            comics.let {
                comicsLiveData.postValue(it)
            }
            isLoading.value = false
        }
    }

    fun onCreateFragment() {
        if (comicsLiveData.value != null) {
            comicsLiveData.postValue(comicsLiveData.value)
        }
    }

    fun onComicSelected(comic: Comic) {
        currentComic.postValue(comic)
    }

    fun getSuperHero() {
        viewModelScope.launch {
            isLoading.value = true
            val heroes = getSuperHeroesUseCase()
            heroes.let {
                superHeroesLiveData.postValue(it)
            }
            isLoading.value = false

        }
    }

    fun getSuperHeroByComicId(comicId : String) {
        viewModelScope.launch {
            isLoading.value = true
            val heroes = getSuperHeroesByComicId(comicId)
            heroes.let {
                superHeroesLiveData.postValue(it)
            }
            isLoading.value = false

        }
    }
}