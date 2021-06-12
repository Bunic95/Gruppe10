package com.example.basicchat

import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.`object`.conversation.BaseQiChatExecutor

class DanceExecutor(qiContext: QiContext?) :
    BaseQiChatExecutor(qiContext) {
    override fun runWith(params: List<String>) {
        dancereaction(qiContext)
    }
    override fun stop() {}
}