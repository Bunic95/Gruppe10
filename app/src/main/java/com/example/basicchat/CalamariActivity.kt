package com.example.basicchat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.design.activity.RobotActivity

class CalamariActivity : RobotActivity(), RobotLifecycleCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calamariscreen)
        QiSDK.register(this, this)

        //Button zurück in den Homescreen
        val but_home = findViewById<ImageButton>(R.id.but_home3)
        but_home.setOnClickListener {
            val intent = Intent(this, DecisionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück zum Anfang", Toast.LENGTH_SHORT).show()
        }


        //Button zurück zur Vorigen Activity
        val backButton = findViewById<Button>(R.id.but_back_calamari)
        backButton.setOnClickListener {
            val intent = Intent(this, Italyactivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück", Toast.LENGTH_SHORT).show()
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

}