package com.example.lab3_6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    private val _counter = MutableLiveData<Int>()

    val counter: LiveData<Int> get() = _counter

    init{
        _counter.value = 0
    }

    fun incrementCounter() {
        _counter.value = (_counter.value?:0)+1
    }
    fun incrementCounter(savedCounter: Int) {
        _counter.value = savedCounter
    }
}