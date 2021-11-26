package com.example.chatbot.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.NonNull
import com.example.chatbot.R
import com.example.chatbot.data.response.Message
import java.util.ArrayList

class MessageRVAdapter(messageModalArrayList: ArrayList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var messageModalArrayList= ArrayList<Message>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        when (viewType) {
            0 -> {
                //below line we are inflating user message layout.
                view = LayoutInflater.from(parent.context).inflate(R.layout.user_msg, parent, false)
                return UserViewHolder(view)
            }
            1 -> {
                //below line we are inflating bot message layout.
                view = LayoutInflater.from(parent.context).inflate(R.layout.bot_msg, parent, false)
                return BotViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.bot_msg, parent, false)
                return BotViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //this method is use to set data to our layout file.
        val modal: Message = messageModalArrayList[position]
        when (modal.sender) {
            "user" ->
                (holder as UserViewHolder).userTV.text = modal.message
            "bot" ->
                (holder as BotViewHolder).botTV.text = modal.message
        }
    }

    override fun getItemViewType(position: Int): Int {
        //below line of code is to set position.
        return when (messageModalArrayList[position].sender) {
            "user" -> 0
            "bot" -> 1
            else -> -1
        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //creating a variable for our text view.
        var userTV: TextView

        init {
            userTV = itemView.findViewById(R.id.idTVUser)
        }
    }

    class BotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //creating a variable for our text view.
        var botTV: TextView

        init {
            //initializing with id.
            botTV = itemView.findViewById(R.id.idTVBot)
        }
    }

    override fun getItemCount(): Int {
        //return the size of array list
        return messageModalArrayList.size
    }

    init {
        this.messageModalArrayList = messageModalArrayList
    }
}