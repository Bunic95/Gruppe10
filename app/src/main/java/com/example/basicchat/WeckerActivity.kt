package com.example.basicchat

import android.os.Bundle
import android.widget.TextView
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.design.activity.RobotActivity
import java.text.SimpleDateFormat
import java.util.*

class WeckerActivity : RobotActivity(), RobotLifecycleCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weckerscreen)
        QiSDK.register(this, this)

        val kalender: Calendar = Calendar.getInstance()
        val zeitformat = SimpleDateFormat("HH:mm")
        val txt_zeitaktuell: TextView = findViewById(R.id.txt_zeitaktuell)
        txt_zeitaktuell.setText(zeitformat.format(kalender.getTime()))


        //https://www.youtube.com/watch?v=xJr7N6bSPLc&ab_channel=derAndroidPro (Time und Date Picker)

        val datumsformat = SimpleDateFormat("dd.MM.yyyy")
        val txt_datumaktuell: TextView = findViewById(R.id.txt_datumaktuell)
        txt_datumaktuell.setText(datumsformat.format(kalender.time))
    }

    override fun onRobotFocusGained(qiContext: QiContext?) {

    }

    override fun onRobotFocusLost() {
        TODO("Not yet implemented")
    }

    override fun onRobotFocusRefused(reason: String?) {
        TODO("Not yet implemented")
    }
}