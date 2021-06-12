package com.example.basicchat

import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.`object`.conversation.BaseQiChatExecutor

class DiscoExecutor(qiContext: QiContext?) :
    BaseQiChatExecutor(qiContext) {
    override fun runWith(params: List<String>) {
        discoreaction(qiContext)
    }
    override fun stop() {}
}