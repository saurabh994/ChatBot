package com.example.chatbot.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.*
import android.widget.TextView
import com.example.chatbot.R
import com.example.chatbot.data.response.Message

class MessageRVAdapter :
    ListAdapter<Message, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        val layoutInflator = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> {
                view = layoutInflator.inflate(R.layout.user_msg, parent, false)
                UserViewHolder(view)
            }
            1 -> {
                view = layoutInflator.inflate(R.layout.bot_msg, parent, false)
                BotViewHolder(view)
            }
            else -> {
                view = layoutInflator.inflate(R.layout.bot_msg, parent, false)
                BotViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val modal: Message = getItem(position)
        when (modal.sender) {
            "user" ->
                (holder as UserViewHolder).userTV.text = modal.message
            "bot" ->
                (holder as BotViewHolder).botTV.text = modal.message
        }
    }

    override fun getItemViewType(position: Int): Int {
        //below line of code is to set position.
        return when (getItem(position).sender) {
            "user" -> 0
            "bot" -> 1
            else -> -1
        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //creating a variable for our text view.
        var userTV: TextView = itemView.findViewById(R.id.idTVUser)
    }

    class BotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //creating a variable for our text view.
        var botTV: TextView = itemView.findViewById(R.id.idTVBot)
    }

    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<Message> =
            object : DiffUtil.ItemCallback<Message>() {
                override fun areItemsTheSame(
                    inputParams: Message,
                    t1: Message
                ): Boolean {
                    return inputParams == t1
                }

                override fun areContentsTheSame(
                    inputParams: Message,
                    t1: Message
                ): Boolean {
                    return inputParams.id == t1.id
                }
            }
    }
}