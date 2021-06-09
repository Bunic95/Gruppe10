package com.example.basicchat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.design.activity.RobotActivity

class turkischactivity : RobotActivity(), RobotLifecycleCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.turkischscreen)
        QiSDK.register(this, this)

        //Button zurück zur Vorrigen Activity
        val backButton = findViewById<Button>(R.id.but_back_turk)
        backButton.setOnClickListener {
            val intent = Intent(this, RezeptActivity::class.java)
            startActivity(intent)
        }
        val but_pide: Button = findViewById(R.id.but_pide) //Button wird als variable deklariert
        but_pide.setOnClickListener {
            // fchat.requestCancellation() //ACHTUNG DIES NOCH EINÜGEN WENN CHAT EINGEFÜGT IST
            goToPide()
            //thread {  }
        }
        val but_baklava: Button = findViewById(R.id.but_baklava) //Button wird als variable deklariert
        but_baklava.setOnClickListener {
            // fchat.requestCancellation() //ACHTUNG DIES NOCH EINÜGEN WENN CHAT EINGEFÜGT IST
            goToBaklava()
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
    private fun goToPide() {
        val changeToPide = Intent(this, PideActivity::class.java)
        startActivity(changeToPide)
    }
    private fun goToBaklava() {
        val changeToBaklava = Intent(this, BaklavaActivity::class.java)
        startActivity(changeToBaklava)
    }
}
