package com.example.basicchat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.design.activity.RobotActivity

class Italyactivity : RobotActivity(), RobotLifecycleCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.italyscreen)
        QiSDK.register(this, this)

        //Button zurück zur Vorrigen Activity
        val backButton = findViewById<Button>(R.id.but_back_italy)
        backButton.setOnClickListener {
            val intent = Intent(this, RezeptActivity::class.java)
            startActivity(intent)
        }
        val but_risotto: Button = findViewById(R.id.but_risotto) //Button wird als variable deklariert
        but_risotto.setOnClickListener {
            // fchat.requestCancellation() //ACHTUNG DIES NOCH EINÜGEN WENN CHAT EINGEFÜGT IST
            goToRisotto()
            //thread {  }
        }
        val but_calamari: Button = findViewById(R.id.but_calamari) //Button wird als variable deklariert
        but_calamari.setOnClickListener {
            // fchat.requestCancellation() //ACHTUNG DIES NOCH EINÜGEN WENN CHAT EINGEFÜGT IST
            goToCalamari()
            //thread {  }
        }
    }

    override fun onRobotFocusGained(qiContext: QiContext?) {
        TODO("Not yet implemented")
    }

    override fun onRobotFocusLost() {
        TODO("Not yet implemented")
    }

    override fun onRobotFocusRefused(reason: String?) {
        TODO("Not yet implemented")
    }
    private fun goToRisotto() {
        val changeToRisotto = Intent(this, RisottoActivity::class.java)
        startActivity(changeToRisotto)
    }
    private fun goToCalamari() {
        val changeToCalamari = Intent(this, CalamariActivity::class.java)
        startActivity(changeToCalamari)
    }
}