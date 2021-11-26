package com.example.chatbot.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbot.R
import com.example.chatbot.data.response.Message
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val messageModalArrayList= ArrayList<Message>()
    private lateinit var messageRVAdapter: MessageRVAdapter
    private val mainViewModel: MainViewModel by viewModels ()
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        idChats.apply {
            messageRVAdapter = MessageRVAdapter(messageModalArrayList)
            linearLayoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            this.adapter = messageRVAdapter
        }
        idIBSend.setOnClickListener {

            if (idEdtMessage.text.toString().isEmpty()) {
                Toast.makeText(this@MainActivity, "Please enter your message..", Toast.LENGTH_SHORT)
                    .show()
            } else {
                mainViewModel.sendMessage(idEdtMessage.text.toString())
                idEdtMessage.setText("")
            }
        }
    }
}