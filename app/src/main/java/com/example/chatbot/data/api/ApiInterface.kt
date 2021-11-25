package com.example.chatbot.data.api

import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @POST("api/chat/")
    suspend fun sendMessage(@Query("apiKey") apiKey: String =
    "6nt5d1nJHkqbkphe", @Query("message") message: String, @Query("chatBotID") chatBotID: String = "63906",
                            @Query("externalID") externalID: String = "chirag1"): Response<com.example.chatbot.data.response.Response>
}