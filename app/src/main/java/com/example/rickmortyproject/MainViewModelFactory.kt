package com.example.rickmortyproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.utils.ResourceProvider

@ExperimentalPagingApi
class MainViewModelFactory (val mResourceProvider: ResourceProvider) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(mResourceProvider) as T
    }
}