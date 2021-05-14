package com.saurabh.bluetoothchatapp.chat

interface Message {
    fun content() : Content
    fun father() : Father
    fun child() : Child?
}