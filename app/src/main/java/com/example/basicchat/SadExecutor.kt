package com.example.basicchat

import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.`object`.conversation.BaseQiChatExecutor

class SadExecutor(qiContext: QiContext?) :
    BaseQiChatExecutor(qiContext) {
    override fun runWith(params: List<String>) {
        sadreaction(qiContext)
    }
    override fun stop() {}
}