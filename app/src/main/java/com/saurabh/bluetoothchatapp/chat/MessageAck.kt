package com.saurabh.bluetoothchatapp.chat

data class MessageAck(
    var isMe : Boolean,
    var status :MessageStatus,
    val UID : String,
    val content: String
)