package com.example.chatbot.network

import com.example.chatbot.data.api.ApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiClient {

    private fun getHttpLogClient(): OkHttpClient {
        val httpClient = OkHttpClient().newBuilder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)

        val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(loggingInterceptor)
        return httpClient.build()
    }

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .client(getHttpLogClient())
        .baseUrl(Urls.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApi(): ApiInterface = retrofit().create(ApiInterface::class.java)
}