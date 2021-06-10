package com.example.basicchat

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
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
        val datumsformat = SimpleDateFormat("dd.MM.yyyy")
        val txt_datumaktuell: TextView = findViewById(R.id.txt_datumaktuell)
        txt_datumaktuell.setText(datumsformat.format(kalender.time))

        //Button zurück in den Homescreen
        val but_home = findViewById<ImageButton>(R.id.but_home16)
        but_home.setOnClickListener {
            val intent = Intent(this, DecisionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück zum Anfang", Toast.LENGTH_SHORT).show()
        }
        //Button zurück zur Vorrigen Activity
        val backButton = findViewById<Button>(R.id.but_back_wecker)
        backButton.setOnClickListener {
            val intent = Intent(this, OrganizerActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück", Toast.LENGTH_SHORT).show()
        }
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