package com.example.chatbot.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbot.R
import com.example.chatbot.data.response.Message
import com.example.chatbot.widget.isConnected
import com.example.chatbot.widget.toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels ()
    private val messageRVAdapter by lazy {
        MessageRVAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        idChats.apply {
            this.adapter = messageRVAdapter
        }
        idIBSend.setOnClickListener {
            if (isConnected) {
                if (idEdtMessage.text.toString().isEmpty()) {
                    toast("Please enter your message..")
                } else {
                    mainViewModel.sendMessage(idEdtMessage.text.toString())
                    idEdtMessage.setText("")
                }
            } else toast("No Network Available")
        }
        mainViewModel.messageList.observe(this, {
            messageRVAdapter.submitList(it)
            messageRVAdapter.notifyDataSetChanged()
            if (it.count() > 0)
            idChats.smoothScrollToPosition(it.count()-1)
        })
    }

    companion object {
        const val USER_KEY = "user"
        const val BOT_KEY = "bot"
    }
}