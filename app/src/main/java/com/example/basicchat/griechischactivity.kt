package com.example.basicchat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.design.activity.RobotActivity

class griechischactivity : RobotActivity(), RobotLifecycleCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.griechischscreen)
        QiSDK.register(this, this)

        //Button zurück zur Vorrigen Activity
        val backButton = findViewById<Button>(R.id.but_back_griech)
        backButton.setOnClickListener {
            val intent = Intent(this, RezeptActivity::class.java)
            startActivity(intent)
        }
        val but_gyros: Button = findViewById(R.id.but_gyros) //Button wird als variable deklariert
        but_gyros.setOnClickListener {
            // fchat.requestCancellation() //ACHTUNG DIES NOCH EINÜGEN WENN CHAT EINGEFÜGT IST
            goToGyros()
            //thread {  }
        }
        val but_salat: Button = findViewById(R.id.but_salat) //Button wird als variable deklariert
        but_salat.setOnClickListener {
            // fchat.requestCancellation() //ACHTUNG DIES NOCH EINÜGEN WENN CHAT EINGEFÜGT IST
            goToSalat()
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
    private fun goToGyros() {
        val changeToGyros = Intent(this, GyrosActivity::class.java)
        startActivity(changeToGyros)
    }
    private fun goToSalat() {
        val changeToSalat = Intent(this, SalatActivity::class.java)
        startActivity(changeToSalat)
    }
}