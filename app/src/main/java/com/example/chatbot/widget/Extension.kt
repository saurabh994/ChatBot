package com.example.chatbot.widget

import androidx.lifecycle.MutableLiveData


fun <T> MutableLiveData<T>.notify() {
    value = value
}