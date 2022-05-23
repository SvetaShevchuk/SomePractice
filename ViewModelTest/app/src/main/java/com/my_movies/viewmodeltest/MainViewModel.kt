package com.my_movies.viewmodeltest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var countNumber = MutableLiveData<Int>()

    init{
        countNumber.value = 0
    }

    fun update(){
        countNumber.value = (countNumber.value)?.plus(1)
    }
}