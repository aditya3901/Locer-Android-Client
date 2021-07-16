package org.locer.`in`

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.locer.`in`.utils.PopularFood
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository): ViewModel() {

    val products get() = run {
        val productLiveData = MutableLiveData<List<PopularFood>>()
        viewModelScope.launch {
            productLiveData.postValue(homeRepository.getProducts())
        }
        productLiveData
    }

}