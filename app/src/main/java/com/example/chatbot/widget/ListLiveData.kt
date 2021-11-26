package com.example.chatbot.widget

import androidx.lifecycle.MutableLiveData

class ListLiveData<T> : MutableLiveData<MutableList<T>>() {

    init {
        value = mutableListOf()
    }

    fun add(item: T) {
        value?.apply {
            add(item)
            notify()
        }
    }

    fun <T> MutableLiveData<T>.notify() {
        value = value
    }
}



