package com.example.chatbot.data.response

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("success")
	val success: Int? = null,

	@field:SerializedName("errorMessage")
	val errorMessage: String? = null,

	@field:SerializedName("message")
	val message: Message? = null
)

data class Message(

	@field:SerializedName("chatBotName")
	val chatBotName: String? = null,

	@field:SerializedName("emotion")
	val emotion: Any? = null,

	@field:SerializedName("chatBotID")
	val chatBotID: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
)
