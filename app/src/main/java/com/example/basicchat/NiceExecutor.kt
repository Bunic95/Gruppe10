package com.example.basicchat

import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.`object`.conversation.BaseQiChatExecutor

class NiceExecutor(qiContext: QiContext?) :
    BaseQiChatExecutor(qiContext) {
    override fun runWith(params: List<String>) {
        nicereaction(qiContext)
    }
    override fun stop() {}
}
