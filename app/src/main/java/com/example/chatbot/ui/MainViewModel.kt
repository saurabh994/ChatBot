package com.example.chatbot.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.data.repository.Repository
import com.example.chatbot.data.response.Message
import com.example.chatbot.widget.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val mainRepository = Repository()
    val messageList = ListLiveData<Message>()

    fun sendMessage(msg: String) {
        viewModelScope.launch {
                messageList.add(Message("", "", 0, msg, MainActivity.USER_KEY))
                val response = mainRepository.sendMessage(msg)
                if (response.success == 1) {
                    response.message?.apply {
                        sender = MainActivity.BOT_KEY
                    }
                    response.message?.let {
                        messageList.add(it)
                    }
                }
            }
    }
}