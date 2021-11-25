package com.example.chatbot.data.repository

import com.example.chatbot.data.api.ApiInterface
import com.example.chatbot.network.ApiClient
import retrofit2.Response


class Repository {

    private var api: ApiInterface = ApiClient.getApi()

    suspend fun sendMessage(message: String): Response<com.example.chatbot.data.response.Response> {
        return api.sendMessage(message = message)
    }
}