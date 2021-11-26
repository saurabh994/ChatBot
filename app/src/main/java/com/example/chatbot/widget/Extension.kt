package com.example.chatbot.widget

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast


val Context.isConnected: Boolean
    get() = (getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager)?.activeNetworkInfo?.isConnected == true

fun Context.toast(msg: String) {
    Toast.makeText(
        this,
        msg,
        Toast.LENGTH_SHORT
    )
        .show()
}