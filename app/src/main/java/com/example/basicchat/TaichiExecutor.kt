package com.example.basicchat

import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.`object`.conversation.BaseQiChatExecutor

class TaichiExecutor(qiContext: QiContext?) :
    BaseQiChatExecutor(qiContext) {
    override fun runWith(params: List<String>) {
        taichireaction(qiContext)
    }
    override fun stop() {}
}
