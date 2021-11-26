package com.example.chatbot.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.*
import android.widget.TextView
import com.example.chatbot.R
import com.example.chatbot.data.response.Message
import com.example.chatbot.databinding.BotMsgBinding
import com.example.chatbot.databinding.UserMsgBinding

class MessageRVAdapter :
    ListAdapter<Message, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    private lateinit var userMsgBinding : UserMsgBinding
    private lateinit var botMsgBinding: BotMsgBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> {
                userMsgBinding = UserMsgBinding.inflate(layoutInflator, parent, false)
                UserViewHolder(userMsgBinding)
            }
            1 -> {
                botMsgBinding = BotMsgBinding.inflate(layoutInflator, parent, false)
                BotViewHolder(botMsgBinding)
            }
            else -> {
                botMsgBinding = BotMsgBinding.inflate(layoutInflator, parent, false)
                BotViewHolder(botMsgBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val modal: Message = getItem(position)
        when (modal.sender) {
            "user" ->
                userMsgBinding.idTVUser.text = modal.message
            "bot" ->
                botMsgBinding.idTVBot.text = modal.message
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).sender) {
            "user" -> 0
            "bot" -> 1
            else -> -1
        }
    }

    inner class UserViewHolder(binding: UserMsgBinding) : RecyclerView.ViewHolder(binding.root)

    inner class BotViewHolder(binding: BotMsgBinding) : RecyclerView.ViewHolder(binding.root)

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