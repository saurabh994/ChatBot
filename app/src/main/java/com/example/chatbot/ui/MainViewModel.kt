package com.example.chatbot.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.data.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val mainRepository = Repository()

    fun sendMessage(msg:String) {
        viewModelScope.launch {
            mainRepository.sendMessage(msg)
        }
    }
}