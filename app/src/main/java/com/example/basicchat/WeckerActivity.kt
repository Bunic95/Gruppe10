package com.example.basicchat

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
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
        val but_weckersetzen: Button =
            findViewById(R.id.but_weckersetzen)

        but_weckersetzen.setOnClickListener {

            val intent = Intent(AlarmClock.ACTION_SET_ALARM)
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Neuer Wecker")
            intent.putExtra(AlarmClock.EXTRA_HOUR, 10)
            intent.putExtra(AlarmClock.EXTRA_MINUTES, 32)
            intent.putExtra(AlarmClock.EXTRA_DAYS, arrayListOf(2, 3, 4))
            startActivity(intent)
        }
        //LIVE UHRZEIT IWIE REALISIEREN DAMIT DIESE MIT LÄUFT!!!
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